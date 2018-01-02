package com.frontend.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.frontend.web.exception.BusinessException;
import com.frontend.web.model.ArchVarReq;
import com.frontend.web.model.ArchVarResp;
import com.frontend.web.model.ResponseData;
import com.frontend.web.service.interfaces.IFrontendManage;

@RestController
@RequestMapping("/frontend/service")
public class FrontendController {

    @Autowired
    private IFrontendManage frontendManage;
    
    private static final Logger logger = LoggerFactory.getLogger(FrontendController.class);

    @CrossOrigin
    @RequestMapping("/getArchByVar")
    public ResponseData<ArchVarResp> getArchByVar(ArchVarReq reqData) {
        ResponseData<ArchVarResp> responseData = null;
        try {
        	logger.info(JSONObject.toJSONString(reqData));
        	ArchVarResp varResp = new ArchVarResp();
        	if(reqData!=null){
        		varResp = frontendManage.getArchByVar(reqData);
        		if(varResp!=null){
        			responseData = new ResponseData<ArchVarResp>(
                            ResponseData.AJAX_STATUS_SUCCESS, "查找任务成功",
                            varResp);
        		}else{
        			responseData = new ResponseData<ArchVarResp>(
                            ResponseData.AJAX_STATUS_FAILURE, "未查询到数据",
                            varResp);
        		}
        		
        	}else{
        		responseData = new ResponseData<ArchVarResp>(
                        ResponseData.AJAX_STATUS_FAILURE, "入參不能为空",
                        null);
        	}
        } catch (Exception e) {
            e.printStackTrace();
            responseData = new ResponseData<ArchVarResp>(
                    ResponseData.AJAX_STATUS_FAILURE, "查找任务失败" + e.getMessage());
        }
        return responseData;
    }
    
    @CrossOrigin
    @RequestMapping("/getDataByChart")
    public ResponseData<String> getDataByChart(ArchVarReq reqData) {
        ResponseData<String> responseData = null;
        try {
        	logger.info(JSONObject.toJSONString(reqData));
        	if(reqData!=null){
        		
        		try {
        			responseData = frontendManage.getDataByChart(reqData);
				} catch(BusinessException e ){
					logger.error("请求参数 ： {},查询异常 ： {}" , JSON.toJSONString(reqData) , e.getMessage() );
					responseData = new ResponseData<String>(
                            e.getRepcode(), e.getMessage(),
                            null);
				}catch (Exception e) {
					logger.error("请求参数 ： {},查询异常 ： {}" , JSON.toJSONString(reqData) , e.getMessage() );
					responseData = new ResponseData<String>(
                            ResponseData.AJAX_STATUS_FAILURE, e.getMessage(),
                            null);
				}
        		
        	}else{
        		responseData = new ResponseData<String>(
                        ResponseData.AJAX_STATUS_FAILURE, "入參不能为空",
                        null);
        	}
        } catch (Exception e) {
        	logger.error("请求参数 ： {},查询异常 ： {}" , JSON.toJSONString(reqData) , e.getMessage() );
            responseData = new ResponseData<String>(
                    ResponseData.AJAX_STATUS_FAILURE, "查找任务失败" + e.getMessage());
        }
        return responseData;
    }
}
