package com.frontend.web.model.request;

import java.io.Serializable;

public class Reqdata implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 指标
	 */
	private ReqQuota quota;

	public ReqQuota getQuota() {
		return quota;
	}

	public void setQuota(ReqQuota quota) {
		this.quota = quota;
	}

	
}
