package com.frontend.web.service.interfaces;

import com.frontend.web.model.ArchVarReq;
import com.frontend.web.model.ArchVarResp;
import com.frontend.web.model.ResponseData;

public interface IFrontendManage {
    
    public ArchVarResp getArchByVar(ArchVarReq archVarReq);
    
    public ResponseData<String> getDataByChart(ArchVarReq archVarReq);
}
