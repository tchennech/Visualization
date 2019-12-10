package com.clt.dao;

import com.clt.domain.PredictGrade;

public interface PredictGradeMapper {
    int deleteByPrimaryKey(String id);

    int insert(PredictGrade record);

    int insertSelective(PredictGrade record);

    PredictGrade selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PredictGrade record);

    int updateByPrimaryKey(PredictGrade record);
}