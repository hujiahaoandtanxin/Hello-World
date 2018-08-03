package com.hujiahao.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hujiahao.model.Msg;
import com.hujiahao.model.User;
import com.hujiahao.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	/**
	 * 通过小程序拿到的openid来获取用户信息
	 * @param openid
	 * @return
	 */
	@RequestMapping(value = "/selectUserByOpenid", method = RequestMethod.GET)
	@ResponseBody//默认把对象返回---变成json字符串
	public List<User> selectUserByOpenid(String openid) {
		List<User> userList = userService.selectUserByOpenid(openid);		
		Gson gson = new Gson();
		String json = gson.toJson(userList);
		System.out.println(json);
		return userList;
		
	}
	
	/**
	 * 通过小程序拿到的openid来更新用户信息
	 * @param openid
	 * @return
	 */
	@RequestMapping(value = "/updateUserByOpenid", method = RequestMethod.GET)
	@ResponseBody//默认把对象返回---变成json字符串
	public Msg updateUserByOpenid(String username,@RequestParam("openid") String openid,User user) {
		user.setOpenId(openid);
		user.setUsername(username);
		int result = userService.updateByOpenIdSelective(user);
		System.out.println(result);
		return Msg.success();
	}
	/**
	 * 通过小程序拿到的openid来更新用户信息
	 * @param openid
	 * @return
	 */
	@RequestMapping(value = "/updatePasswordByOpenid", method = RequestMethod.GET)
	@ResponseBody//默认把对象返回---变成json字符串
	public Msg updatePasswordByOpenid(String password,@RequestParam("openid") String openid,User user) {
		user.setOpenId(openid);
		user.setPassword(password);
		int result = userService.updateByOpenIdSelective(user);
		System.out.println(result);
		return Msg.success();
	}
	/**
	 * 通过小程序拿到的openid来更新用户信息
	 * @param openid
	 * @return
	 */
	@RequestMapping(value = "/updateSexByOpenid", method = RequestMethod.GET)
	@ResponseBody//默认把对象返回---变成json字符串
	public Msg updateSexByOpenid(String sex,@RequestParam("openid") String openid,User user) {
		user.setOpenId(openid);
		user.setSex(sex);
		int result = userService.updateByOpenIdSelective(user);
		System.out.println(result);
		return Msg.success();
	}
	/**
	 * 通过小程序拿到的openid来更新用户信息
	 * @param openid
	 * @return
	 */
	@RequestMapping(value = "/updatePhoneByOpenid", method = RequestMethod.GET)
	@ResponseBody//默认把对象返回---变成json字符串
	public Msg updatePhoneByOpenid(String phone,@RequestParam("openid") String openid,User user) {
		user.setOpenId(openid);
		user.setMobilePhone(phone);
		int result = userService.updateByOpenIdSelective(user);
		System.out.println(result);
		return Msg.success();
	}
	
	
}
