package com.clt.controller;

import com.clt.domain.AttendanceInfo;
import com.clt.service.AttendanceService;
import com.clt.service.Student_teacher;
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
import java.util.List;
import java.util.Map;

@Controller
public class AttendanceController {
	@Resource
	private AttendanceService attendanceService;
	@Resource
	private Student_teacher student_teacher;
	private final String SET_ENCODE = "utf-8";
	private final String SET_TEXTURE = "text/plain";
	private final String DATA = "datal";

	private String changeEncode(HttpServletRequest request, HttpServletResponse response, String paraName) throws UnsupportedEncodingException {
		request.setCharacterEncoding(SET_ENCODE);
		response.setCharacterEncoding(SET_ENCODE);
		response.setContentType(SET_TEXTURE);
		String msg = request.getParameter(paraName).toString();
		return msg;
	}

	@RequestMapping(value = "getallattendance", method = RequestMethod.POST)
	@ResponseBody
	public String getAllAttendanceInfo(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		List<AttendanceInfo> result;
		JsonObject jsonMsg = new JsonObject();
		try {
			result = attendanceService.getAllAttendanceInfo();
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
	@RequestMapping(value = "getUpData", method = RequestMethod.POST)
	@ResponseBody
	public String getUpData(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Map<String, List<List<Integer>>> result;
		JsonObject jsonMsg = new JsonObject();
		try {
			result = attendanceService.getUpData();
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
}