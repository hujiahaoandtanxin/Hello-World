package com.hujiahao.dao;

import com.hujiahao.model.wireman;

public interface wiremanMapper {
    int deleteByPrimaryKey(Integer wiremanId);

    int insert(wireman record);

    int insertSelective(wireman record);

    wireman selectByPrimaryKey(Integer wiremanId);

    int updateByPrimaryKeySelective(wireman record);

    int updateByPrimaryKey(wireman record);
}