package com.weixin.dao;

import com.weixin.entity.table.LinShiBiao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LinShiBiaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LinShiBiao record);

    int insertSelective(LinShiBiao record);

    LinShiBiao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LinShiBiao record);

    int updateByPrimaryKey(LinShiBiao record);
}