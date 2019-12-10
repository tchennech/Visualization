package com.clt.dao;

import com.clt.domain.StudentTeacher;

public interface StudentTeacherMapper {
    int deleteByPrimaryKey(String id);

    int insert(StudentTeacher record);

    int insertSelective(StudentTeacher record);

    StudentTeacher selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StudentTeacher record);

    int updateByPrimaryKey(StudentTeacher record);
}