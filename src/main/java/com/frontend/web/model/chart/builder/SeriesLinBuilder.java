package com.frontend.web.model.chart.builder;

import java.util.ArrayList;
import java.util.List;

import com.frontend.web.model.chart.CommonChart;
import com.frontend.web.model.chart.base.AbstractChart;
import com.frontend.web.model.chart.base.AbstractChartBuilder;
import com.frontend.web.model.chart.factor.AxisVo;
import com.frontend.web.model.chart.factor.SeriesVo;
import com.frontend.web.model.response.RepDic;
import com.frontend.web.model.response.Reponse;
import com.frontend.web.utils.ReponseUtils;

/**
 * 柱状/条形图<br>
 *
 * @author knowAndDo
 *
 */
public class SeriesLinBuilder extends AbstractChartBuilder {

	/**
	 * xAxis.data取自dim.dic.dic_code集合<br>
	 * seriesData.legendCode取自dim.dic.dic_data_cycle.cycle_data_set.cycle_value<br>
	 * seriesData.legendName取自dim.dic.dic_data_cycle.cycle_data_set.cycle_value<br>
	 * seriesData.data取自dim.dic.dic_data_cycle.cycle_data_set.cycle_data_row.row_data.data_value<br>
	 */

	@Override
	public AbstractChart build(Reponse rdata) {
	
		CommonChart chart = new CommonChart();
		chart.setQuotaCode(rdata.getQuota().getQuota_code());
		chart.setRepcode(rdata.getRepcode());
		chart.setRepmsg(rdata.getRepmsg());
		chart.setTitle(rdata.getQuota().getQuota_name());
		List<SeriesVo> seriesData = ReponseUtils.getLinSeriesVosByRep(rdata);
		chart.setSeriesData(seriesData);
		AxisVo xAxis = new AxisVo();
		xAxis.setData(ReponseUtils.getLinSeriesDataByRep(rdata));
		chart.setxAxis(xAxis);
		List<AxisVo> yAxis = new ArrayList<AxisVo>();
		chart.setyAxis(yAxis);
		return chart;
	}

	@Override
	public List<CommonChart> builds(Reponse rdata) {

		List<CommonChart> charts = new ArrayList<CommonChart>();
		List<RepDic> repDics = rdata.getQuota().getDim().getDic();
		for (RepDic repDic : repDics) {
			CommonChart chart = new CommonChart();
			chart.setDicCode(repDic.getDic_code());
			chart.setDicName(repDic.getDic_name());
			chart.setQuotaCode(rdata.getQuota().getQuota_code());
			chart.setRepcode(rdata.getRepcode());
			chart.setRepmsg(rdata.getRepmsg());
			chart.setTitle(rdata.getQuota().getQuota_name());
			List<String> x_data = ReponseUtils.getLinSeriesDataByRepDic(repDic);
			List<SeriesVo> seriesData = ReponseUtils.getSeriesDataByRepDic(repDic, x_data);
			chart.setSeriesData(seriesData);
			AxisVo xAxis = new AxisVo();
			xAxis.setData(x_data);
			xAxis.setDataType("category");
			chart.setxAxis(xAxis);
			List<AxisVo> yAxis = new ArrayList<AxisVo>();
			AxisVo xAxis2 = new AxisVo();
			xAxis2.setSplitNumber(5);
			xAxis2.setShowName("户");
			yAxis.add(xAxis2);
			chart.setyAxis(yAxis);
			charts.add(chart);
		}
		return charts;
	}

}
