package com.clt.controller;

import com.clt.domain.ConnectTeacher;
import com.clt.domain.Grade;
import com.clt.service.ConnectTeacherService;
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

@Controller
public class ConnectTeacherController {
    @Resource
    private ConnectTeacherService connectTeacherService;
    @RequestMapping(value = "selectTeacher_sub", method= RequestMethod.GET)
    @ResponseBody
    public String selectTeacher_sub(HttpServletRequest request, HttpServletResponse response, HttpSession session,  String classname) {

        List<ConnectTeacher> teachers= connectTeacherService.selectTeacher_sub(classname);
        System.out.println(classname);

        JsonArray jsonArray = new Gson().toJsonTree(teachers, new TypeToken<List<ConnectTeacher>>() {}.getType()).getAsJsonArray();
        System.out.println(jsonArray.toString());
        return jsonArray.toString();
    }
// 根据班级找到老师信息和教学科目
}
