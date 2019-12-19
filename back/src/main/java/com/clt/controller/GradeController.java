package com.clt.controller;

import com.clt.domain.Grade;
import com.clt.domain.Grade_teacher;
import com.clt.service.GradeService;
import com.clt.service.Student_teacher;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
// df56_chengji 改了字段 去掉了下划线
@Controller
public class GradeController {
    @Resource
    private GradeService gradeService;
//    @Resource
//    private Student_teacher student_teacher;
    @RequestMapping(value = "selectgradebyid", method= RequestMethod.GET)
    @ResponseBody
    public String getAllStudentHomeData(HttpServletRequest request, HttpServletResponse response, HttpSession session,String id,String project)  {
        System.out.println(id+project);
        List<Grade_teacher> grades = gradeService.selectGradebyid(id);
        List<Grade_teacher> gradespro=new ArrayList<>();
        for (Grade_teacher gra: grades
             ) {
            if(gra.getMesSubName().equals(project))
                gradespro.add(gra);
            
        }

        JsonArray jsonArray = new Gson().toJsonTree(gradespro, new TypeToken<List<Grade>>() {}.getType()).getAsJsonArray();
        return jsonArray.toString();
    }
}
//http://localhost:8080/selectgradebyid.action?id=14454&project=英语
// 方法一：修改tomcat配置文件添加编码与工程编码一致，如下：
//
//<Connector URIEncoding="utf-8" connectionTimeout="20000"port="8080" protocol="HTTP/1.1"redirectPort="8443"/>
