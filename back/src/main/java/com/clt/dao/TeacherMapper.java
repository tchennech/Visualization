package com.clt.dao;

import com.clt.domain.Teacher;

import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(String tId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String tId);

    List<Teacher> selectAll();// 和xml里的方法声明一致

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}