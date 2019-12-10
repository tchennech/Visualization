package com.clt.dao;

import com.clt.domain.KaoqinType;

public interface KaoqinTypeMapper {
    int deleteByPrimaryKey(String controlerId);

    int insert(KaoqinType record);

    int insertSelective(KaoqinType record);

    KaoqinType selectByPrimaryKey(String controlerId);

    int updateByPrimaryKeySelective(KaoqinType record);

    int updateByPrimaryKey(KaoqinType record);
}