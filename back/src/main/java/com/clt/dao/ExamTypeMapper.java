package com.clt.dao;

import com.clt.domain.ExamType;

public interface ExamTypeMapper {
    int deleteByPrimaryKey(String examKindId);

    int insert(ExamType record);

    int insertSelective(ExamType record);

    ExamType selectByPrimaryKey(String examKindId);

    int updateByPrimaryKeySelective(ExamType record);

    int updateByPrimaryKey(ExamType record);
}