package com.clt.dao;

import com.clt.domain.Consumption;

public interface ConsumptionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Consumption record);

    int insertSelective(Consumption record);

    Consumption selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Consumption record);

    int updateByPrimaryKey(Consumption record);
}