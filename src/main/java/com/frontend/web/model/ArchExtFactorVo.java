package com.frontend.web.model;

import java.util.List;

/**
 * 图框扩展信息
 * 
 * @author wangluyang
 *
 */
public class ArchExtFactorVo {
	
	/**
	 * 纬度名称
	 */
	private String factorName;
	
	/**
	 * 纬度编码
	 */
	private String factorCode;
	
	/**
	 * 最小值（进度条和仪表盘）
	 */
	private String processMinNum;
	/**
	 * 最大值（进度条和仪表盘）
	 */
	private String processMaxNum;
	
	private List<SectionVo> sectionFileds;

	/**
	 * 扩展属性，json格式
	 */
	private String extAttributes;
	
	public String getFactorName() {
		return factorName;
	}

	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}

	public String getFactorCode() {
		return factorCode;
	}

	public void setFactorCode(String factorCode) {
		this.factorCode = factorCode;
	}

	public String getExtAttributes() {
		return extAttributes;
	}

	public void setExtAttributes(String extAttributes) {
		this.extAttributes = extAttributes;
	}

	public String getProcessMinNum() {
		return processMinNum;
	}

	public void setProcessMinNum(String processMinNum) {
		this.processMinNum = processMinNum;
	}

	public String getProcessMaxNum() {
		return processMaxNum;
	}

	public void setProcessMaxNum(String processMaxNum) {
		this.processMaxNum = processMaxNum;
	}

	public List<SectionVo> getSectionFileds() {
		return sectionFileds;
	}

	public void setSectionFileds(List<SectionVo> sectionFileds) {
		this.sectionFileds = sectionFileds;
	}
}
