package com.frontend.web.model.chart.factor;

/**
 * top排名各因子属性
 * @author wangluyang
 *
 */
public class RankElement {

	/**
	 * yyyy-mm-dd hh:mm:ss
	 */
	private String dateString;
	
	/**
	 * 父节点code
	 */
	private String parentCode;
	
	/**
	 * 父节点name
	 */
	private String parentName;
	
	private String code;
	
	private String name;
	
	private String text;
	
	/**
	 * 
	 */
	private int sortIndex;

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}
}
