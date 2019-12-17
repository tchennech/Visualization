package com.clt.dao;

import com.clt.domain.Kaoqin;

import java.util.List;

public interface KaoqinMapper {
    Kaoqin selectByPrimaryKey(String kaoqingId);

    List<Kaoqin> selectAll();
}