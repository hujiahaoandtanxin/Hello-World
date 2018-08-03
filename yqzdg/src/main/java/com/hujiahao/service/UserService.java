package com.hujiahao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hujiahao.dao.UserMapper;
import com.hujiahao.model.User;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	public List<User> selectUserByOpenid(String openid) {
		// TODO Auto-generated method stub
		List<User> list = userMapper.selectByOpenid(openid);
		return list;
	}

	
	public Integer updateByOpenIdSelective(User record) {
		int result = userMapper.updateByOpenIdSelective(record);
		return result;
	}
}
