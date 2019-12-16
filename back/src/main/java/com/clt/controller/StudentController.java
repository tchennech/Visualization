package com.clt.controller;

import com.clt.domain.StudentInfoResult;
import com.clt.service.GradeService;
import com.clt.service.StudentService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
public class StudentController {
	@Resource
	private StudentService studentService;
	@Resource
	private GradeService gradeService;
	private final String SET_ENCODE = "utf-8";
	private final String SET_TEXTURE = "text/plain";
	private final String DATA = "datal";
	private String changeEncode(HttpServletRequest request, HttpServletResponse response, String paraName) throws UnsupportedEncodingException  {
        request.setCharacterEncoding(SET_ENCODE);
        response.setCharacterEncoding(SET_ENCODE);
        response.setContentType(SET_TEXTURE);
        String msg = request.getParameter(paraName).toString();
        return msg;
    }
	
	@RequestMapping(value="getallstudata", method=RequestMethod.POST)
	@ResponseBody
    public String getAllStudentHomeData(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		StudentInfoResult result;
        JsonObject jsonMsg = new JsonObject();
	    try {
        	result = studentService.getAllStudentHomeData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonMsg.addProperty("status", 1);
			jsonMsg.addProperty("msg", e.getMessage());
			return jsonMsg.toString();
		}
               
        jsonMsg.addProperty("status", 0);
        jsonMsg.addProperty("data", (new Gson()).toJson(result).toString());
        System.out.println(jsonMsg.toString());
        return jsonMsg.toString();
	}
	@RequestMapping(value="selectStunamebyid", method=RequestMethod.GET)
	@ResponseBody
	public String selectStunamebyid(HttpServletRequest request, HttpServletResponse response, HttpSession session,String id) {

		return  studentService.selectStunamebyid(id);
	}
}
