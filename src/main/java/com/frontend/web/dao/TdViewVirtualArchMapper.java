package com.frontend.web.dao;

import com.frontend.web.bo.TdViewVirtualArch;
import com.frontend.web.bo.TdViewVirtualArchCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TdViewVirtualArchMapper {
    int countByExample(TdViewVirtualArchCriteria example);

    int deleteByExample(TdViewVirtualArchCriteria example);

    int deleteByPrimaryKey(Long virtualArchId);

    int insert(TdViewVirtualArch record);

    int insertSelective(TdViewVirtualArch record);

    List<TdViewVirtualArch> selectByExample(TdViewVirtualArchCriteria example);

    TdViewVirtualArch selectByPrimaryKey(Long virtualArchId);

    int updateByExampleSelective(@Param("record") TdViewVirtualArch record, @Param("example") TdViewVirtualArchCriteria example);

    int updateByExample(@Param("record") TdViewVirtualArch record, @Param("example") TdViewVirtualArchCriteria example);

    int updateByPrimaryKeySelective(TdViewVirtualArch record);

    int updateByPrimaryKey(TdViewVirtualArch record);
}