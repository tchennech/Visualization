package com.clt.dao;

import com.clt.domain.StudentInfo;

import java.util.List;

public interface StudentInfoMapper {
    int deleteByPrimaryKey(String bfStudentid);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    StudentInfo selectByPrimaryKey(String bfStudentid);

    List<StudentInfo> selectAll();

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);
    String selectStunamebyid(String id);
}