package com.frontend.web.model.response;

import java.io.Serializable;

public class Reponse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 返回代码
	 */
	private String repcode;
	
	/**
	 * 返回数据
	 */
	private RepQuota quota;
	
	/**
	 * 返回信息
	 */
	private String repmsg;
	
	public String getRepcode() {
		return repcode;
	}
	public void setRepcode(String repcode) {
		this.repcode = repcode;
	}
	
	
	public RepQuota getQuota() {
		return quota;
	}
	public void setQuota(RepQuota quota) {
		this.quota = quota;
	}
	public String getRepmsg() {
		return repmsg;
	}
	public void setRepmsg(String repmsg) {
		this.repmsg = repmsg;
	}
	
}
