package com.clt.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.clt.common.Const;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.clt.dao.UserMapper;
import com.clt.domain.UserLoginBean;


@Service
@Scope
public class UserService {
	@Resource
	private UserMapper userMapper;

	public UserLoginBean userLogin(HttpSession session, UserLoginBean userlogin) throws Exception {
		UserLoginBean user;
		try {
			user = userMapper.selectBy(userlogin);
			session.setAttribute(Const.CUR_USER, user);
			System.out.println(userlogin);
		} catch (Exception e) {
			throw new Exception(e);
		}

		if (user == null) {
			throw new Exception("error username or password");

		}
		return user;
	}

}
