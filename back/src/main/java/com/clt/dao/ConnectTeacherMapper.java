package com.clt.dao;

import com.clt.domain.ConnectTeacher;

import java.util.List;

public interface ConnectTeacherMapper {
    int deleteByPrimaryKey(String id);

    int insert(ConnectTeacher record);

    int insertSelective(ConnectTeacher record);

    ConnectTeacher selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ConnectTeacher record);

    int updateByPrimaryKey(ConnectTeacher record);

     List<ConnectTeacher> selectTeacher_sub(String classname);

}