package com.example.myfirstxm.mbg.mapper;

import com.example.myfirstxm.mbg.model.PmsProductAttribute;
import com.example.myfirstxm.mbg.model.PmsProductAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductAttributeMapper {
    int countByExample(PmsProductAttributeExample example);

    int deleteByExample(PmsProductAttributeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProductAttribute record);

    int insertSelective(PmsProductAttribute record);

    List<PmsProductAttribute> selectByExample(PmsProductAttributeExample example);

    PmsProductAttribute selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsProductAttribute record, @Param("example") PmsProductAttributeExample example);

    int updateByExample(@Param("record") PmsProductAttribute record, @Param("example") PmsProductAttributeExample example);

    int updateByPrimaryKeySelective(PmsProductAttribute record);

    int updateByPrimaryKey(PmsProductAttribute record);
}