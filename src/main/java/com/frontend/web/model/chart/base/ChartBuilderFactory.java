package com.frontend.web.model.chart.base;

import java.util.HashMap;

import com.frontend.web.utils.ServiceConfUtil;
import com.frontend.web.utils.StringUtil;

public class ChartBuilderFactory {

	private static HashMap<String, AbstractChartBuilder> baseChartsMap = new HashMap<String, AbstractChartBuilder>();

	public static AbstractChartBuilder getInstance(String chartType) {
		if (!baseChartsMap.containsKey(chartType)) {
			/* 1.获取配置的服务标识 */
			String clazzname = ServiceConfUtil.getService(chartType);
			/* 2.获取对应的实例 */
			if (!StringUtil.isBlank(clazzname)) {
				AbstractChartBuilder base = AbstractChartBuilder.getInstance(clazzname);
				base.chartType = chartType;
				baseChartsMap.put(chartType, base);
			}
		}
		AbstractChartBuilder group = baseChartsMap.get(chartType);
		if (group == null) {
			System.out.println("没有配置图表类型chartType为[" + chartType + "]的组件实现类");
		}
		return group;
	}

	public static AbstractChartBuilder getInstance(Class<?> clazz) {
		return getInstance(clazz.getName());
	}

}
