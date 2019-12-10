package com.clt.dao;

import com.clt.domain.Connect;

public interface ConnectMapper {
    int deleteByPrimaryKey(String bfStudentid);

    int insert(Connect record);

    int insertSelective(Connect record);

    Connect selectByPrimaryKey(String bfStudentid);

    int updateByPrimaryKeySelective(Connect record);

    int updateByPrimaryKey(Connect record);
}