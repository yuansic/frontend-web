package com.frontend.web.model.chart;

import java.util.List;

import com.frontend.web.model.chart.factor.AxisVo;
import com.frontend.web.model.chart.factor.SeriesVo;



/**
 * 常用图表
 * 支持面积图,折线图，柱状图
 * @author wangluyang
 *
 */
public class CommonChart extends BaseChart{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String dicCode;
	
	private String dicName;

	/**
	 * 图表类型
	 * line:折线图，面积图
	 * bar：柱状图
	 * scatter：散点图
	 */
	private String chartType;
	
	/**
	 * x坐标轴
	 */
	private AxisVo xAxis;
	
	/**
	 * y坐标轴,兼容双y轴，最多两条数据
	 */
	private List<AxisVo> yAxis;
	
	/**
	 * 数据
	 */
	private List<SeriesVo> seriesData;

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

	public String getChartType() {
		return chartType;
	}

	public void setChartType(String chartType) {
		this.chartType = chartType;
	}

	public AxisVo getxAxis() {
		return xAxis;
	}

	public void setxAxis(AxisVo xAxis) {
		this.xAxis = xAxis;
	}
	
	public List<AxisVo> getyAxis() {
		return yAxis;
	}

	public void setyAxis(List<AxisVo> yAxis) {
		this.yAxis = yAxis;
	}

	public List<SeriesVo> getSeriesData() {
		return seriesData;
	}

	public void setSeriesData(List<SeriesVo> seriesData) {
		this.seriesData = seriesData;
	}
}
