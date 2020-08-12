package com.oldpei.myback.dao;

import com.oldpei.myback.model.PhotoType;
import java.util.List;

public interface PhotoTypeMapper {
    int deleteByPrimaryKey(Integer uniqueId);

    int insert(PhotoType record);

    PhotoType selectByPrimaryKey(Integer uniqueId);

    List<PhotoType> selectAll();

    int updateByPrimaryKey(PhotoType record);
}