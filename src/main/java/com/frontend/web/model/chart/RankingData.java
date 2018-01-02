package com.frontend.web.model.chart;

import java.util.List;

import com.frontend.web.model.chart.factor.RankElement;


public class RankingData extends BaseChart{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 因子，支持树形结构
	 */
	private List<RankElement> elements;
	
	/**
	 * 请求频率毫秒
	 */
	private String periodString;

	public List<RankElement> getElements() {
		return elements;
	}

	public void setElements(List<RankElement> elements) {
		this.elements = elements;
	}

	public String getPeriodString() {
		return periodString;
	}

	public void setPeriodString(String periodString) {
		this.periodString = periodString;
	}
}
