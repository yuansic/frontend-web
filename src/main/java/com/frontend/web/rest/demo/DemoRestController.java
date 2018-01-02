package com.frontend.web.rest.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.frontend.web.model.ArchVarReq;
import com.frontend.web.model.ResponseData;
import com.frontend.web.rest.demo.service.IFrontendManageDemo;

@RestController
@RequestMapping("/frontend/demo")
public class DemoRestController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
    private IFrontendManageDemo frontendManage;
    
    private static final Logger logger = LoggerFactory.getLogger(DemoRestController.class);
	
	@CrossOrigin
    @RequestMapping("/getDataByChart")
    public ResponseData<Object> getDataByChart(ArchVarReq reqData) {
        ResponseData<Object> responseData = null;
        try {
        	logger.info(JSONObject.toJSONString(reqData));
        	if(reqData!=null){
        		Object respData = frontendManage.getDataByChart(reqData);
        		if(respData!=null){
        			responseData = new ResponseData<Object>(
                            ResponseData.AJAX_STATUS_SUCCESS, "查找任务成功",
                            respData);
        		}else{
        			responseData = new ResponseData<Object>(
                            ResponseData.AJAX_STATUS_FAILURE, "查询数据失败",
                            respData);
        		}
        	}else{
        		responseData = new ResponseData<Object>(
                        ResponseData.AJAX_STATUS_FAILURE, "入參不能为空",
                        null);
        	}
        } catch (Exception e) {
            e.printStackTrace();
            responseData = new ResponseData<Object>(
                    ResponseData.AJAX_STATUS_FAILURE, "查找任务失败" + e.getMessage());
        }
        return responseData;
    }
}
