package com.clt.dao;

import com.clt.domain.Kaoqin;

public interface KaoqinMapper {
    int deleteByPrimaryKey(String kaoqingId);

    int insert(Kaoqin record);

    int insertSelective(Kaoqin record);

    Kaoqin selectByPrimaryKey(String kaoqingId);

    int updateByPrimaryKeySelective(Kaoqin record);

    int updateByPrimaryKey(Kaoqin record);
}