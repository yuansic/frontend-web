package com.frontend.web.model.chart.base;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.frontend.web.model.chart.BaseChart;
import com.frontend.web.model.response.Reponse;
import com.frontend.web.utils.StringUtil;

public abstract class AbstractChartBuilder {

	protected String chartType;

	public static AbstractChartBuilder getInstance(String clazzName) {

		AbstractChartBuilder groupBase = null;
		if (StringUtil.isBlank(clazzName)) {
			System.out.println("获取处理组件出错：没有指定实现类");
		}
		try {
			groupBase = (AbstractChartBuilder) (Class.forName(clazzName).newInstance());
		} catch (Exception e) {
			System.out.println("获取处理组件出错");
		}
		return groupBase;
	}

	public abstract AbstractChart build(Reponse jsondata);

	public abstract List<? extends AbstractChart> builds(Reponse jsondata);

	public Reponse TransJson2Rep(String jsondata) {
		if (StringUtil.isBlank(jsondata)) {
			return null;
		}
		Reponse rep = JSON.toJavaObject(JSON.parseObject(jsondata), Reponse.class);

		return rep;
	}

	public void setAbstractPro(BaseChart chart, Reponse rep) {
		// skip
	}
}
