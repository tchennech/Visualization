package com.clt.service;

import com.clt.dao.GradeMapper;
import com.clt.domain.Grade;
import com.clt.domain.Grade_teacher;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Scope
public class GradeService {
    @Resource
    private GradeMapper gradeMapper;
    public List<Grade_teacher> selectGradebyid(String id){
        return gradeMapper.selectGradebyid(id);
    }
}
