package com.clt.dao;

import com.clt.domain.Grade;
import com.clt.domain.Grade_teacher;

import java.util.List;

public interface GradeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);

    List<Grade_teacher> selectGradebyid(String id);
}