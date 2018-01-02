package com.frontend.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.frontend.web.bo.TdChartDataRule;
import com.frontend.web.bo.TdChartDataRuleCriteria;
import com.frontend.web.bo.TdQuotaWarning;
import com.frontend.web.bo.TdQuotaWarningCriteria;
import com.frontend.web.bo.TdRouteRule;
import com.frontend.web.bo.TdRouteRuleCriteria;
import com.frontend.web.bo.TdRouteRuleCriteria.Criteria;
import com.frontend.web.bo.TdViewArch;
import com.frontend.web.bo.TdViewArchCriteria;
import com.frontend.web.bo.TdViewArchElement;
import com.frontend.web.bo.TdViewArchElementCriteria;
import com.frontend.web.bo.TdViewChart;
import com.frontend.web.bo.TdViewChartCriteria;
import com.frontend.web.bo.TdViewPage;
import com.frontend.web.bo.TdViewPageCriteria;
import com.frontend.web.bo.TdViewVirtualArch;
import com.frontend.web.bo.TdViewVirtualArchCriteria;
import com.frontend.web.constants.CommonConstants;
import com.frontend.web.dao.TdChartDataRuleMapper;
import com.frontend.web.dao.TdQuotaWarningMapper;
import com.frontend.web.dao.TdRouteRuleMapper;
import com.frontend.web.dao.TdViewArchElementMapper;
import com.frontend.web.dao.TdViewArchMapper;
import com.frontend.web.dao.TdViewChartMapper;
import com.frontend.web.dao.TdViewPageMapper;
import com.frontend.web.dao.TdViewVirtualArchMapper;
import com.frontend.web.exception.BusinessException;
import com.frontend.web.model.ArchElement;
import com.frontend.web.model.ArchExtFactorVo;
import com.frontend.web.model.ArchVarReq;
import com.frontend.web.model.ArchVarResp;
import com.frontend.web.model.ResponseData;
import com.frontend.web.model.SectionVo;
import com.frontend.web.model.ViewArchVo;
import com.frontend.web.model.chart.CommonChart;
import com.frontend.web.model.chart.PercentChart;
import com.frontend.web.model.chart.RankingData;
import com.frontend.web.model.chart.base.ChartBuilderFactory;
import com.frontend.web.model.chart.factor.AxisVo;
import com.frontend.web.model.chart.factor.SeriesVo;
import com.frontend.web.model.request.ReqCycle;
import com.frontend.web.model.request.ReqCycleValue;
import com.frontend.web.model.request.ReqDic;
import com.frontend.web.model.request.ReqDim;
import com.frontend.web.model.request.ReqQuota;
import com.frontend.web.model.request.ReqTopflag;
import com.frontend.web.model.request.Reqdata;
import com.frontend.web.model.request.Request;
import com.frontend.web.model.response.Reponse;
import com.frontend.web.service.interfaces.IFrontendManage;
import com.frontend.web.utils.DateUtil;
import com.frontend.web.utils.HttpClientUtil;

@Service
@Transactional
@SuppressWarnings("all")
public class FrontendManageImpl implements IFrontendManage {

	private static final Logger logger = LoggerFactory.getLogger(FrontendManageImpl.class);
	
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    
    public static final String VAR_SPLIT_FIELD = ",";
    public static final String VAR_PREFIX = "V";
    public static final String CHART_TYPE_CODE = "C";

	@Override
	public ArchVarResp getArchByVar(ArchVarReq archVarReq) {
		// TODO Auto-generated method stub
		ArchVarResp result = new ArchVarResp();
		
		TdViewPage viewPage = this.QueryViewPageByCode(archVarReq.getPageCode());
		TdViewArch arch = this.QueryViewArchByCode(archVarReq.getPageCode(), archVarReq.getArchCode());
		
		result.setPageCode(viewPage.getPageCode());
		result.setArchCode(arch.getArchCode());
		
		ViewArchVo archVo = new ViewArchVo();
		Long routeId = this.getRouteId(archVarReq.getVariables());
		
		TdViewVirtualArch viewVirtualArch = this.QueryViewVirtualArch(arch.getArchCode(), routeId);
		if(viewVirtualArch!=null){
			archVo.setArchCode(viewVirtualArch.getVirtualArchCode());
			archVo.setArchName(viewVirtualArch.getVirtualArchName());
			archVo.setTimeValRal(String.valueOf(viewVirtualArch.getStaytimeValue()));
			archVo.setTimeUnit(viewVirtualArch.getStaytimeUnit());
		}
		
		List<ArchElement> elements = new ArrayList<>();
		
		if(routeId!=null){
			
			List<TdViewArchElement> archElements = this.getArchElementByRouteId(archVarReq.getPageCode(),archVarReq.getArchCode(),routeId,null);
			if(!CollectionUtils.isEmpty(archElements)){
				for(TdViewArchElement archElement : archElements){
					ArchElement element = new ArchElement();
					element.setElementCode(archElement.getElementCode());
					element.setElementTypeCode(archElement.getElementTypeCode());
					element.setElementUrl(archElement.getElementUrl());
					element.setShowOrder(String.valueOf(archElement.getShowOrder()));
					elements.add(element);
					String chartCode = archElement.getElementCodeVirtual();
					List<TdViewChart> viewCharts = this.getViewChartByChartCode(chartCode);
					if(!CollectionUtils.isEmpty(viewCharts)){
						for (TdViewChart viewChart : viewCharts) {
							if(viewChart.getWarnningTag().equals("Y")){
								String ruleCode = viewChart.getRuleCode();
								List<TdChartDataRule> chartDataRules = this.getChartDataRuleByQuotaCode(ruleCode);
								if(!CollectionUtils.isEmpty(chartDataRules)){
									List list = new ArrayList<>();
									String quotaCode = "";
									String dimCode = "";
									for (TdChartDataRule chartDataRule : chartDataRules) {
										if(chartDataRule.getParamCode().equals("quota_code")){
											quotaCode = chartDataRule.getParamValue1();
										}
										if(chartDataRule.getParamCode().equals("dim_code")){
											dimCode = chartDataRule.getParamValue1();
										}
										list.add(chartDataRule.getParamValue1());
									}
									Map<String, Object> map = new HashMap<String, Object>();
									map.put("QuotaCode", quotaCode);
									map.put("DimCode", dimCode);
									map.put("ruleCode", ruleCode);
									map.put("ParamCode", "DIC_CODE");
									TdQuotaWarningMapper chartDataRuleMapper = this.sqlSessionTemplate.getMapper(TdQuotaWarningMapper.class);
									List<TdQuotaWarning> archExtFactorVos = null;
									List<ArchExtFactorVo> arrayList = new ArrayList<ArchExtFactorVo>();
									for (int i = 0; i < list.size(); i++) {
										map.put("DicCode", list.get(i));
										List<TdQuotaWarning> sectionVos = chartDataRuleMapper.selectBySectionVo(map);
										if(!CollectionUtils.isEmpty(sectionVos)){
											List<SectionVo> sectionVoList = new ArrayList<SectionVo>();
											for (TdQuotaWarning tdQuotaWarning : sectionVos) {
												SectionVo sectionVo = new SectionVo();
												sectionVo.setName(tdQuotaWarning.getDicCode());
												sectionVo.setValue(tdQuotaWarning.getWarningMax());
												sectionVoList.add(sectionVo);
											}
											archExtFactorVos = chartDataRuleMapper.selectByArchExtFactorVo(map);
											ArchExtFactorVo extFactorVo = null;
											for (TdQuotaWarning tdQuotaWarning : archExtFactorVos) {
												extFactorVo = new ArchExtFactorVo();
												extFactorVo.setFactorCode(tdQuotaWarning.getDicCode());
												extFactorVo.setFactorName(tdQuotaWarning.getDicCode());
												extFactorVo.setProcessMaxNum(tdQuotaWarning.getWarningMax());
												extFactorVo.setProcessMinNum(tdQuotaWarning.getWarningMin());
												extFactorVo.setSectionFileds(sectionVoList);
											}
											arrayList.add(extFactorVo);
										}
									}
									element.setDimFactors(arrayList);
								}
							}
						}
					}
				}
			}
		}
		archVo.setArchElements(elements);
		result.setArchVo(archVo);
		
		return result;
	}
	
	@Override
	public ResponseData<String> getDataByChart(ArchVarReq archVarReq) {
		// TODO Auto-generated method stub
		
		Request resultData = new Request();
		resultData.setReqtype("getdata");

		Reqdata reqdata = new Reqdata();
		ReqQuota reqQuota = new ReqQuota();

		String chartCode = "";
		String chartType = "";
		String url = "";
		ReqCycle cycles = new ReqCycle();
		ReqDim dim = new ReqDim();
		ReqTopflag reqTopflag= new ReqTopflag();
		List<ReqCycleValue> listReqCycleValue =new ArrayList<ReqCycleValue>();
		ReqCycleValue reqCycleValue = new ReqCycleValue();
		
		Long routeId = this.getRouteId(archVarReq.getVariables());
		if(routeId!=null){
			List<TdViewArchElement> archElements = this.getArchElementByRouteId(archVarReq.getPageCode(),archVarReq.getArchCode(),routeId,archVarReq.getElementCode());
			for(TdViewArchElement archElement:archElements){
				if(StringUtils.equals(CHART_TYPE_CODE, archElement.getElementTypeCode())){
					String virtualchartCode = archElement.getElementCodeVirtual();
					List<TdViewChart> charts = this.getViewChartByVirtualCode(virtualchartCode);
					if(!CollectionUtils.isEmpty(charts)){
						chartCode = charts.get(0).getRuleCode();
						chartType = charts.get(0).getChartTypeCode();
						List<TdChartDataRule> dataRules = this.getChartDataRuleByChartCode(chartCode);
						if(!CollectionUtils.isEmpty(dataRules)){
							List<ReqDic> dics = new ArrayList<>();
							for(TdChartDataRule chartDataRule:dataRules){
								if(StringUtils.equals("quota_code", chartDataRule.getParamCode())){
									chartCode = chartDataRule.getParamValue1();
								}
								if(StringUtils.equals("dim_code", chartDataRule.getParamCode())){
									dim.setDim_code(chartDataRule.getParamValue1());
								}
								if(StringUtils.equals("dic_code", chartDataRule.getParamCode())){
									ReqDic dic = new ReqDic();
									dic.setDic_code(chartDataRule.getParamValue1());
									dics.add(dic);

									dim.setDic(dics);
								}
								if(StringUtils.equals("url", chartDataRule.getParamCode())){
									url = chartDataRule.getParamValue1();
								}
								//处理 top
								if(StringUtils.equals("rows", chartDataRule.getParamCode())){
										reqTopflag.setRows(Integer.parseInt(chartDataRule.getParamValue1()));
										reqQuota.setTop_flag(reqTopflag);
								}
								//处理cycle  cycle_type=DAY/MONTH,LASTDAY/LASTMONTH
								if(StringUtils.equals("cycle_type", chartDataRule.getParamCode())){
									cycles.setCycle_type(chartDataRule.getParamValue1());
									reqQuota.setCycle(cycles);
								}

								//处理cycle  cycle_type=DAY/MONTH ,要补充cycle_value
								if(StringUtils.equals("cycle_value", chartDataRule.getParamCode())){
									reqCycleValue = new ReqCycleValue();
									reqCycleValue.setVal(chartDataRule.getParamValue1());
									listReqCycleValue.add(reqCycleValue);
									cycles.setCycle_value(listReqCycleValue);
								}

								//处理cycle  cycle_type=LASTDAY/LASTMONTH ,要补充cycle_cnt
								if(StringUtils.equals("cycle_cnt", chartDataRule.getParamCode())){
									cycles.setCycle_cnt(Integer.parseInt(chartDataRule.getParamValue1()));
									reqQuota.setCycle(cycles);
								}
								
								if(StringUtils.equals("interval", chartDataRule.getParamCode())){
									cycles.setInterval(Integer.parseInt(chartDataRule.getParamValue1()));
									reqQuota.setCycle(cycles);
								}
							}
						}
					}
				}
			}
		}
		reqQuota.setQuota_code(chartCode);
		reqQuota.setDim(dim);
		
		reqdata.setQuota(reqQuota);
		resultData.setReqdata(reqdata);
			
		//根据不同类型的cycleType转换cyclevalue
		this.convertCycleValue(resultData);
		
		logger.info("resultData------>"+JSONObject.toJSONString(resultData));    
		logger.info("url------>"+url);
		if(StringUtils.isNotBlank(url)){
			//将返回的数据解析
			String respStr = HttpClientUtil.sendPost(url, "data="+JSONObject.toJSONString(resultData));
			if(StringUtils.isNotBlank(respStr)){
				return this.getConvertRespStr(respStr, chartType);
			}else{
				throw new BusinessException(ResponseData.AJAX_STATUS_FAILURE, "response is null!");
			}
		}else{
			throw new BusinessException(ResponseData.AJAX_STATUS_FAILURE, "url is null!");
		}
	}
	
	/**
	 * 返回转换数据
	 * @param respStr
	 * @return
	 */
	private ResponseData<String> getConvertRespStr(String respStr, String chartType){
		
		Reponse response = JSON.toJavaObject(JSON.parseObject(respStr), Reponse.class);
		
		if(null!=response.getRepcode()&&response.getRepcode().equals(CommonConstants.Exception.NOTDATA)){
			throw new BusinessException(ResponseData.AJAX_STATUS_NODATA, response.getRepmsg());
		}
		if(null!=response.getRepcode()&&!response.getRepcode().equals(CommonConstants.Exception.SUCCESS)){
			throw new BusinessException(ResponseData.AJAX_STATUS_FAILURE, response.getRepmsg());
		}
		
		String respData = "";
		
		List<List<PercentChart>> chartList = new ArrayList<>();
		if(StringUtils.isNotBlank(respStr)){
			if(StringUtils.equals("KHL", chartType) || StringUtils.equals("YHL_P", chartType) || StringUtils.equals("YHL_C", chartType) || StringUtils.equals("ZT", chartType) || StringUtils.equals("ZX", chartType)|| StringUtils.equals("ZX_Y", chartType)|| StringUtils.equals("ZT_Y", chartType)){
				CommonChart obj = (CommonChart) ChartBuilderFactory
						.getInstance(chartType).build(response);
				respData = JSONObject.toJSONString(obj);
			}else if(StringUtils.equals("JDL", chartType) || StringUtils.equals("TOP_B", chartType)){
				List<PercentChart> objs = (List<PercentChart>) ChartBuilderFactory
				.getInstance(chartType).builds(response);
				respData = JSONObject.toJSONString(objs);
			}else if(StringUtils.equals("TOP_A", chartType) || StringUtils.equals("QYT", chartType) || StringUtils.equals("UCC", chartType)){
				RankingData obj = (RankingData) ChartBuilderFactory
				.getInstance(chartType).build(response);
				respData = JSONObject.toJSONString(obj);
			}else if(StringUtils.equals("ZXS", chartType)){
				List<CommonChart> objs = (List<CommonChart>) ChartBuilderFactory
				.getInstance(chartType).builds(response);
				respData = JSONObject.toJSONString(objs);
			}
		}
		return new ResponseData<String>(ResponseData.AJAX_STATUS_SUCCESS, "ok",respData);
	}
	
	private List<TdChartDataRule> getChartDataRuleByChartCode(String chartCode){
		TdChartDataRuleMapper dataRuleMapper = this.sqlSessionTemplate.getMapper(TdChartDataRuleMapper.class);
		TdChartDataRuleCriteria chartDataRuleCriteria = new TdChartDataRuleCriteria();
		com.frontend.web.bo.TdChartDataRuleCriteria.Criteria criteria = chartDataRuleCriteria.createCriteria();
		criteria.andRuleCodeEqualTo(chartCode);
		return dataRuleMapper.selectByExample(chartDataRuleCriteria);
	}
	
	private List<TdViewChart> getViewChartByVirtualCode(String virtualchartCode){
		TdViewChartMapper chartMapper = this.sqlSessionTemplate.getMapper(TdViewChartMapper.class);
		TdViewChartCriteria chartCriteria = new TdViewChartCriteria();
		com.frontend.web.bo.TdViewChartCriteria.Criteria criteria = chartCriteria.createCriteria();
		criteria.andChartCodeEqualTo(virtualchartCode);
		return chartMapper.selectByExample(chartCriteria);
	}
	
	/**
	 * 根据指标取数规则编码 rule_code 获取具体指标阀值
	 * @param map
	 * @return
	 */
	private List<TdQuotaWarning> getSectionVoById(Map map){
		TdQuotaWarningMapper chartDataRuleMapper = this.sqlSessionTemplate.getMapper(TdQuotaWarningMapper.class);
		TdQuotaWarningCriteria quotaWarningCriteria = new TdQuotaWarningCriteria();
		com.frontend.web.bo.TdQuotaWarningCriteria.Criteria criteria = quotaWarningCriteria.createCriteria();
		return chartDataRuleMapper.selectBySectionVo(map);
	}
	/**
	 * 根据指标取数规则编码 rule_code 获取指标获取参数
	 * @param ruleCode
	 * @return
	 */
	private List<TdChartDataRule> getChartDataRuleByQuotaCode(String ruleCode){
		TdChartDataRuleMapper chartDataRuleMapper = this.sqlSessionTemplate.getMapper(TdChartDataRuleMapper.class);
		TdChartDataRuleCriteria chartDataRuleCriteria = new TdChartDataRuleCriteria();
		com.frontend.web.bo.TdChartDataRuleCriteria.Criteria criteria = chartDataRuleCriteria.createCriteria();
		criteria.andRuleCodeEqualTo(ruleCode);
		return chartDataRuleMapper.selectByExample(chartDataRuleCriteria);
	}
	/**
	 * 根据元素id获取取数规则列表
	 * @param chartCode
	 * @return
	 */
	private List<TdViewChart> getViewChartByChartCode(String chartCode){
		TdViewChartMapper viewChartMapper = this.sqlSessionTemplate.getMapper(TdViewChartMapper.class);
		TdViewChartCriteria viewChartCriteria = new TdViewChartCriteria();
		com.frontend.web.bo.TdViewChartCriteria.Criteria criteria = viewChartCriteria.createCriteria();
		criteria.andChartCodeEqualTo(chartCode);
		return viewChartMapper.selectByExample(viewChartCriteria);
	}
	/**
	 * 根据路由id获取元素列表
	 * @param routeId
	 * @return
	 */
	private List<TdViewArchElement> getArchElementByRouteId(String pageCode, String archCode, Long routeId, String elementCode){
		TdViewArchElementMapper elementMapper = this.sqlSessionTemplate.getMapper(TdViewArchElementMapper.class);
		TdViewArchElementCriteria elementCriteria = new TdViewArchElementCriteria();
		com.frontend.web.bo.TdViewArchElementCriteria.Criteria criteria = elementCriteria.createCriteria();
		criteria.andPageCodeEqualTo(pageCode);
		criteria.andArchCodeEqualTo(archCode);
		if(StringUtils.isNotBlank(elementCode)){
			criteria.andElementCodeEqualTo(elementCode);
		}
		if(routeId!=null){
			criteria.andRouteIdEqualTo(routeId);
		}
		return elementMapper.selectByExample(elementCriteria);
	}
	
	/**
	 * 根据变量值获得路由规则id
	 * @param vars
	 * @return
	 */
	private Long getRouteId(String vars){
		TdRouteRuleMapper routeRuleMapper = this.sqlSessionTemplate.getMapper(TdRouteRuleMapper.class);
		TdRouteRuleCriteria routeRuleCriteria = new TdRouteRuleCriteria();
		Criteria  criteria = routeRuleCriteria.createCriteria();
		criteria.andGetValueExprEqualTo(vars);
		List<TdRouteRule> routeRules = routeRuleMapper.selectByExample(routeRuleCriteria);
		if(!CollectionUtils.isEmpty(routeRules)){
			return routeRules.get(0).getRouteId();
		}else{
			return null;
		}
	}
	
	private TdViewArch QueryViewArchByCode(String pageCode, String archCode){
		TdViewArchMapper archMapper = sqlSessionTemplate.getMapper(TdViewArchMapper.class);
		TdViewArchCriteria archCriteria = new TdViewArchCriteria();
		com.frontend.web.bo.TdViewArchCriteria.Criteria criteria = archCriteria.createCriteria();
		criteria.andArchCodeEqualTo(archCode);
		criteria.andPageCodeEqualTo(pageCode);
		List<TdViewArch> archs = archMapper.selectByExample(archCriteria);
		if(!CollectionUtils.isEmpty(archs)){
			return archs.get(0);
		}else{
			return null;
		}
	}
	
	private TdViewPage QueryViewPageByCode(String code){
		TdViewPageMapper viewPageMapper = sqlSessionTemplate.getMapper(TdViewPageMapper.class);
		TdViewPageCriteria viewPageCriteria = new TdViewPageCriteria();
		com.frontend.web.bo.TdViewPageCriteria.Criteria pageCriteria = viewPageCriteria.createCriteria();
		pageCriteria.andPageCodeEqualTo(code);
		List<TdViewPage> tdViewPages = viewPageMapper.selectByExample(viewPageCriteria);
		if(!CollectionUtils.isEmpty(tdViewPages)){
			return tdViewPages.get(0);
		}else{
			return null;
		}
	}
	
	private TdViewVirtualArch QueryViewVirtualArch(String archCode, Long routeId){
		TdViewVirtualArchMapper archMapper = sqlSessionTemplate.getMapper(TdViewVirtualArchMapper.class);
		TdViewVirtualArchCriteria virtualArchCriteria = new TdViewVirtualArchCriteria();
		com.frontend.web.bo.TdViewVirtualArchCriteria.Criteria criteria = virtualArchCriteria.createCriteria();
		criteria.andArchCodeEqualTo(archCode);
		criteria.andRouteIdEqualTo(routeId);
		List<TdViewVirtualArch> virtualArchs =  archMapper.selectByExample(virtualArchCriteria);
		if(!CollectionUtils.isEmpty(virtualArchs)){
			return virtualArchs.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 
	 * @param resultData
	 */
	public void convertCycleValue(Request resultData){
		if(resultData.getReqdata().getQuota().getCycle()!=null &&
				StringUtils.equals("HOUR", resultData.getReqdata().getQuota().getCycle().getCycle_type())){
			List<ReqCycleValue> list  = resultData.getReqdata().getQuota().getCycle().getCycle_value();
			if(!CollectionUtils.isEmpty(list)){
				List<ReqCycleValue> cycleValues = new ArrayList<>();
				for(ReqCycleValue value:list){
					ReqCycleValue cycleValue = new ReqCycleValue();
					String corn = value.getVal();
					if(StringUtils.isNotBlank(corn)){
						cycleValue.setVal(DateUtil.getDateString(DateUtil.getDateByCorn(corn), DateUtil.YYYYMMDD));
					}
					cycleValues.add(cycleValue);
				}
				resultData.getReqdata().getQuota().getCycle().setCycle_value(cycleValues);
			}
		}
	}
	
	/**
	 * 得到数据库变量名称
	 * @param index
	 * @return
	 */
	public static String getVarName(int index){
		return VAR_PREFIX+String.valueOf(index+1);
	}
}
