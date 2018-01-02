package com.frontend.web.model.chart;

import java.io.Serializable;

import com.frontend.web.model.chart.base.AbstractChart;

/**
 * 图表基础属性
 * 
 * @author wangluyang
 *
 */
public class BaseChart extends AbstractChart implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 指标编码
	 */
	private String quotaCode; 

	private String repcode;

	private String repmsg;

	private String title;

	public String getQuotaCode() {
		return quotaCode;
	}

	public void setQuotaCode(String quotaCode) {
		this.quotaCode = quotaCode;
	}

	public String getRepcode() {
		return repcode;
	}

	public void setRepcode(String repcode) {
		this.repcode = repcode;
	}

	public String getRepmsg() {
		return repmsg;
	}

	public void setRepmsg(String repmsg) {
		this.repmsg = repmsg;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
