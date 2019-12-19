package com.clt.service;

import com.clt.dao.ConnectTeacherMapper;
import com.clt.domain.ConnectTeacher;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Scope
public class ConnectTeacherService {
    @Resource
    private ConnectTeacherMapper connectTeacherMapper;
    public List<ConnectTeacher> selectTeacher_sub(String classname){
        return connectTeacherMapper.selectTeacher_sub(classname);
    }
}
