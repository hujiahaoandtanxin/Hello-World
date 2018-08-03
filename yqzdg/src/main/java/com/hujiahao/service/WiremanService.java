package com.hujiahao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hujiahao.dao.WiremanMapper;
import com.hujiahao.model.Order;
import com.hujiahao.model.Wireman;

@Service
public class WiremanService {
	
	@Autowired
	WiremanMapper wiremanMapper;
	
	//电工订单显示表
	public List<Wireman>  selectWiremanAllByOpenid(String openid,String orderStatus){
		List<Wireman> wiremanList = wiremanMapper.selectWiremanAllByOpenid(openid ,orderStatus);
		return wiremanList;
		
	}

	public int updateByOpenIdSelective(Wireman wireman) {
		int result = wiremanMapper.updateByOpenIdSelective(wireman);
		return result;
	}

	//电工个人信息表
	public List<Wireman>  selectWiremanByOpenid(String openid){
		List<Wireman> wiremanList = wiremanMapper.selectWiremanByOpenid(openid );
		return wiremanList;
		
	}

	
}
