package com.clt.dao;

import com.clt.domain.Grade2;

public interface Grade2Mapper {
    int deleteByPrimaryKey(String id);

    int insert(Grade2 record);

    int insertSelective(Grade2 record);

    Grade2 selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Grade2 record);

    int updateByPrimaryKey(Grade2 record);
}