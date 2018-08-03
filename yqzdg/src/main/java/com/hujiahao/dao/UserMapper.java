package com.hujiahao.dao;

import java.util.List;

import com.hujiahao.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	List<User> selectByOpenid(String openId);
	
	int updateByOpenIdSelective(User record);
}