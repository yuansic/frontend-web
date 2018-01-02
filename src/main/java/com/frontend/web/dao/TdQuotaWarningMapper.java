package com.frontend.web.dao;

import com.frontend.web.bo.TdQuotaWarning;
import com.frontend.web.bo.TdQuotaWarningCriteria;
import com.frontend.web.model.ArchExtFactorVo;
import com.frontend.web.model.SectionVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TdQuotaWarningMapper {
    int countByExample(TdQuotaWarningCriteria example);

    int deleteByExample(TdQuotaWarningCriteria example);

    int deleteByPrimaryKey(Long warnigId);

    int insert(TdQuotaWarning record);

    int insertSelective(TdQuotaWarning record);

    List<TdQuotaWarning> selectByExample(TdQuotaWarningCriteria example);

    TdQuotaWarning selectByPrimaryKey(Long warnigId);

    int updateByExampleSelective(@Param("record") TdQuotaWarning record, @Param("example") TdQuotaWarningCriteria example);

    int updateByExample(@Param("record") TdQuotaWarning record, @Param("example") TdQuotaWarningCriteria example);

    int updateByPrimaryKeySelective(TdQuotaWarning record);

    int updateByPrimaryKey(TdQuotaWarning record);
    
    List<TdQuotaWarning> selectByArchExtFactorVo(Map map);
    
    List<TdQuotaWarning> selectBySectionVo(Map map);
}