package com.clt.dao;

import com.clt.domain.GradeTeacher;

public interface GradeTeacherMapper {
    int deleteByPrimaryKey(String id);

    int insert(GradeTeacher record);

    int insertSelective(GradeTeacher record);

    GradeTeacher selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GradeTeacher record);

    int updateByPrimaryKey(GradeTeacher record);
}