package com.clt.dao;

import com.clt.domain.StudentInfo;

public interface StudentInfoMapper {
    int deleteByPrimaryKey(String bfStudentid);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    StudentInfo selectByPrimaryKey(String bfStudentid);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);
}