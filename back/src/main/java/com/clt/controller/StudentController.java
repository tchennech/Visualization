package com.clt.controller;

import com.clt.domain.ClassStus;
import com.clt.domain.StudentInfo;
import com.clt.domain.StudentInfoResult;
import com.clt.exclusive_to_Zero.Classdetail;
import com.clt.service.GradeService;
import com.clt.service.StudentService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@RequestMapping(value="selectStubyClassname", method=RequestMethod.GET)
	@ResponseBody
	public String selectStubyClassname(HttpServletRequest request, HttpServletResponse response, HttpSession session, String classname) {

		List<StudentInfo>  stus= studentService.selectStubyClassname(classname);
		Classdetail cd= new Classdetail();
		Map<String,Integer> name = new HashMap<>();
		Map<String,Integer> location = new HashMap<>();
		location.put("宁波",0);
		location.put("其他",0);
		Map<String,Integer> birth_year = new HashMap<>();

		for (int i = 0; i < stus.size(); i++) {
			StudentInfo studentInfo =  stus.get(i);
			if(studentInfo.getBfSex().equals("male"))//性别
				cd.setMale(cd.getMale()+1);
			else if(studentInfo.getBfSex().equals("famale"))//性别
				cd.setFamale(cd.getFamale()+1);
			String FistName=studentInfo.getBfName().substring(0,1);
			if(name.get(FistName)==null)//如果姓氏数量为0
			{
				name.put(FistName,1);
			}else{
				name.put(FistName,name.get(FistName)+1);
			}

			String birthyear=studentInfo.getBfBorndate();//名字
			try{
				if(birthyear.equals(""))
				{
					birth_year.put("2000",birth_year.get("2000")+1);
				}
				else if(birth_year.get(birthyear)==null)//如果姓氏数量为0
				{
					birth_year.put(birthyear,1);
				}else{
					birth_year.put(birthyear,birth_year.get(birthyear)+1);
				}//给不同年份出生的人
			}catch (Exception e){
				birth_year.put("2000",birth_year.get("2000")+1);
			}
			String bfNativeplace = studentInfo.getBfNativeplace();//获取出生地名
			try{
				if(bfNativeplace.equals("")){
					location.put("其他",location.get("其他")+1);
				}
				else if(bfNativeplace.indexOf("宁波")!=-1)
					location.put("宁波",location.get("宁波")+1);
				else
					location.put("其他",location.get("其他")+1);
			}catch (Exception e)
			{
				location.put("其他",location.get("其他")+1);
			}
		}
		cd.setBrith_year(birth_year);
		cd.setLocation(location);
		cd.setName(name);
		JsonObject jsonMsg = new JsonObject();
		jsonMsg.addProperty("data", (new Gson()).toJson(cd).toString());

		return jsonMsg.toString();
	}
	// http://localhost:8080/selectStubyClassname.action?classname=高三(10)

	@RequestMapping(value="selectClassStu", method=RequestMethod.GET)
	@ResponseBody
	public String studentService(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		List<ClassStus> classStuses = studentService.selectClassStu();
		System.out.println(classStuses.size());
		JsonArray jsonArray = new Gson().toJsonTree(classStuses, new TypeToken<List<ClassStus>>() {}.getType()).getAsJsonArray();
		return  jsonArray.toString();
	}

}
// 返回班级学生的性别，姓氏，地域,出生年份的扇形图
// s