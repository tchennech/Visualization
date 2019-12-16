package com.clt.dao;

import com.clt.domain.StudentTeacher;
import org.apache.ibatis.annotations.Param;

public interface StudentTeacherMapper {
    int deleteByPrimaryKey(String id);

    int insert(StudentTeacher record);

    int insertSelective(StudentTeacher record);

    StudentTeacher selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StudentTeacher record);

    int updateByPrimaryKey(StudentTeacher record);
    public String selectteachernamebyid(@Param("id")String id, @Param("project")String project);
}