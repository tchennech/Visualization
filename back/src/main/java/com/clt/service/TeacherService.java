package com.clt.service;

import com.clt.dao.TeacherMapper;
import com.clt.domain.ClassTeacherNum;
import com.clt.domain.Teacher;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
@Scope
public class TeacherService {
	@Resource
	private TeacherMapper teacherMapper;

	public ClassTeacherNum getAllTeacher() throws Exception {
		List<Teacher> tea;
		ClassTeacherNum result;
		try {
			tea = teacherMapper.selectAll();
			result = new ClassTeacherNum(tea);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return result;
	}

}
