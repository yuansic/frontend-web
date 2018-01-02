package com.frontend.web.model.chart;

import java.util.List;

import com.frontend.web.model.chart.factor.GuageFactorVo;


/**
 * 百分比图
 * @author wangluyang
 *
 */
public class PercentChart extends BaseChart{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * lineProcess 进度条
	 * ring	环形图
	 * gauge 仪表盘
	 */
	private String type;
	
	/**
	 * 指标编码
	 */
	private String quotaCode;
	
	private String dicCode;
	
	private String dicName;
	
	private String factorCode;
	
	private String factorName;
	
	private String title;
	
	/**
	 * 百分比 小于100
	 */
	private String percentage;
	
	/**
	 * 最小值
	 */
	private String minNum;
	/**
	 * 最大值
	 */
	private String maxNum;
	/**
	 * 具体数值
	 */
	private String data;
	
	//------------进度条,环形图属性-------
	/**
	 * 当前进度条颜色
	 */
	private String processColor;
	/**
	 * 背景颜色
	 */
	private String backgroundColor;
	
	//------------仪表盘属性-------
	/**
	 * 指针颜色
	 */
	private String axisTickColor;
	/**
	 * 分割区域
	 */
	private String splitNumber;
	private List<GuageFactorVo> guageFactors;
		
	private String sortIndex;
	
	public String getQuotaCode() {
		return quotaCode;
	}
	public void setQuotaCode(String quotaCode) {
		this.quotaCode = quotaCode;
	}
	public String getDicCode() {
		return dicCode;
	}
	public void setDicCode(String dicCode) {
		this.dicCode = dicCode;
	}
	public String getDicName() {
		return dicName;
	}
	public void setDicName(String dicName) {
		this.dicName = dicName;
	}
	
	public String getFactorCode() {
		return factorCode;
	}
	public void setFactorCode(String factorCode) {
		this.factorCode = factorCode;
	}
	public String getFactorName() {
		return factorName;
	}
	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getProcessColor() {
		return processColor;
	}
	public void setProcessColor(String processColor) {
		this.processColor = processColor;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getAxisTickColor() {
		return axisTickColor;
	}
	public void setAxisTickColor(String axisTickColor) {
		this.axisTickColor = axisTickColor;
	}
	public String getSplitNumber() {
		return splitNumber;
	}
	public void setSplitNumber(String splitNumber) {
		this.splitNumber = splitNumber;
	}
	public List<GuageFactorVo> getGuageFactors() {
		return guageFactors;
	}
	public void setGuageFactors(List<GuageFactorVo> guageFactors) {
		this.guageFactors = guageFactors;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getMinNum() {
		return minNum;
	}
	public void setMinNum(String minNum) {
		this.minNum = minNum;
	}
	public String getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(String maxNum) {
		this.maxNum = maxNum;
	}
	public String getSortIndex() {
		return sortIndex;
	}
	public void setSortIndex(String sortIndex) {
		this.sortIndex = sortIndex;
	}
}
