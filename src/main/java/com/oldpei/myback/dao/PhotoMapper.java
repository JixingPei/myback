package com.oldpei.myback.dao;

import com.oldpei.myback.model.Photo;
import java.util.List;

public interface PhotoMapper {
    int deleteByPrimaryKey(Integer uniqueId);

    int insert(Photo record);

    Photo selectByPrimaryKey(Integer uniqueId);

    List<Photo> selectAll();

    int updateByPrimaryKey(Photo record);
}