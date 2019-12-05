package com.clt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clt.domain.UserLoginBean;

public interface UserMapper {
	
	public UserLoginBean selectBy(UserLoginBean user);

}
