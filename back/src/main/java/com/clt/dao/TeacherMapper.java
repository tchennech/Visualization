package com.clt.dao;

import com.clt.domain.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(String tId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String tId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}