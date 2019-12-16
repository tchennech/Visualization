package com.clt.service;

import com.clt.dao.StudentTeacherMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Student_teacher {
    @Resource
    StudentTeacherMapper studentTeacherMapper;
    public String selectteachernamebyid(String id,String prohect){
        return studentTeacherMapper.selectteachernamebyid(id,prohect);
    }
}
