package com.clt.dao;

import com.clt.domain.WordCloud;

public interface WordCloudMapper {
    int deleteByPrimaryKey(String id);

    int insert(WordCloud record);

    int insertSelective(WordCloud record);

    WordCloud selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WordCloud record);

    int updateByPrimaryKey(WordCloud record);
}