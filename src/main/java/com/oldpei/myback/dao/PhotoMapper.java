package com.oldpei.myback.dao;

import com.oldpei.myback.model.Photo;

public interface PhotoMapper {
    int deleteByPrimaryKey(Integer uniqueId);

    int insert(Photo record);

    int insertSelective(Photo record);

    Photo selectByPrimaryKey(Integer uniqueId);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);
}