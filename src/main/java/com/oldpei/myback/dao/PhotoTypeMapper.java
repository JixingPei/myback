package com.oldpei.myback.dao;

import com.oldpei.myback.model.PhotoType;

public interface PhotoTypeMapper {
    int deleteByPrimaryKey(Integer uniqueId);

    int insert(PhotoType record);

    int insertSelective(PhotoType record);

    PhotoType selectByPrimaryKey(Integer uniqueId);

    int updateByPrimaryKeySelective(PhotoType record);

    int updateByPrimaryKey(PhotoType record);
}