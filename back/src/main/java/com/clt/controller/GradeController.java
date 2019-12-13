package com.clt.controller;

import com.clt.domain.Grade;
import com.clt.service.GradeService;
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
import java.util.List;
// df56_chengji 改了字段 去掉了下划线
@Controller
public class GradeController {
    @Resource
    private GradeService gradeService;
    @RequestMapping(value = "selectgradebyid", method= RequestMethod.GET)
    @ResponseBody
    public String getAllStudentHomeData(HttpServletRequest request, HttpServletResponse response, HttpSession session,String id) {
        System.out.println(id);
        List<Grade> grades = gradeService.selectGradebyid(id);
        System.out.println(grades.get(0).toString());

        JsonArray jsonArray = new Gson().toJsonTree(grades, new TypeToken<List<Grade>>() {}.getType()).getAsJsonArray();
        return jsonArray.toString();
    }
}
//http://localhost:8080/selectgradebyid.action?id=14454
