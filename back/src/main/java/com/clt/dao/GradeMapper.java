package com.clt.dao;

import com.clt.domain.Grade;

public interface GradeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
}