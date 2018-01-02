package com.frontend.web.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.frontend.web.bo.TdViewChartType;
import com.frontend.web.dao.TdViewChartTypeMapper;

/**
 * 
 * @author knowAndDo
 *
 */
public class ServiceConfUtil {

	private static SqlSessionTemplate sqlSessionTemplate;

	private static final Map<String, String> services = new HashMap<String, String>();

	/**
	 * @param serviceId
	 * @return
	 */
	public static String getService(String serviceId) {

		if (services.containsKey(serviceId)) {
			return services.get(serviceId);
		}
		List<TdViewChartType> typelist = getAll();
		if (CollectionUtils.isEmpty(typelist)) {
			return null;
		}
		for (TdViewChartType tdViewChartType : typelist) {
			services.put(tdViewChartType.getChartTypeCode(), tdViewChartType.getDealClass());
		}
		return services.get(serviceId);
	}

	public static List<TdViewChartType> getAll() {
		TdViewChartTypeMapper dao = sqlSessionTemplate.getMapper(TdViewChartTypeMapper.class);
		return dao.selectAll();

	}

	public static SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public static void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		ServiceConfUtil.sqlSessionTemplate = sqlSessionTemplate;
	}

}
