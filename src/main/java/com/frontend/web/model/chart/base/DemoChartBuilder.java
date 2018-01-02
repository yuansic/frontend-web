package com.frontend.web.model.chart.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;

import com.alibaba.fastjson.JSON;
import com.frontend.web.model.chart.CommonChart;

public class DemoChartBuilder {

	public static void main(String[] args) {
		String jsondata = "";
		Reader input = null;
		StringBuffer sb = new StringBuffer();
		try {
			input = Resources.getResourceAsReader("all.json");
			BufferedReader r = new BufferedReader(input);
			String line;
			while ((line = r.readLine()) != null) {
				sb.append(line);
			}
			System.out.println("内容为：" + sb); // 把字符数组变为字符串输出
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			jsondata = sb.toString();
		}
		System.out.println("jsondata=" + jsondata);
//		CommonChart objZT = (CommonChart) ChartBuilderFactory.getInstance("ZT_Y").build(jsondata);
//		System.out.println("CommonChart=" + JSON.toJSONString(objZT));
		// @SuppressWarnings("unchecked")
		// List<PercentChart> objZT = (List<PercentChart>)
		// ChartBuilderFactory.getInstance("TOP_B").builds(jsondata);
		// System.out.println("List<PercentChart>=" + JSON.toJSONString(objZT));
		// RankingData objZT = (RankingData)
		// ChartBuilderFactory.getInstance("TOP_A").build(jsondata);
		// System.out.println("RankingData=" + JSON.toJSONString(objZT));
		// @SuppressWarnings("unchecked")
		// List<PercentChart> objZT = (List<PercentChart>)
		// ChartBuilderFactory.getInstance("JDL").builds(jsondata);
		// System.out.println("List<AbstractChart>=" +
		// JSON.toJSONString(objZT));
		// CommonChart objZT = (CommonChart)
		// ChartBuilderFactory.getInstance("ZT").build(jsondata);
		// CommonChart objZX = (CommonChart)
		// ChartBuilderFactory.getInstance("ZX").build(jsondata);
		//
		// System.out.println("CommonChartobjZT=" + JSON.toJSONString(objZT));
		// System.out.println("CommonChartobjZX=" + JSON.toJSONString(objZX));
	}

}
