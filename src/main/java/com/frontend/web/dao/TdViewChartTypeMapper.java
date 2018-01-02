package com.frontend.web.dao;

import java.util.List;

import com.frontend.web.bo.TdViewChartType;

public interface TdViewChartTypeMapper {

	int deleteByPrimaryKey(String chartTypeCode);

	int insert(TdViewChartType record);

	int insertSelective(TdViewChartType record);

	TdViewChartType selectByPrimaryKey(String chartTypeCode);

	TdViewChartType selectByChartTypeCode(String chartTypeCode);

	List<TdViewChartType> selectAll();

	int updateByPrimaryKeySelective(TdViewChartType record);

	int updateByPrimaryKey(TdViewChartType record);
}