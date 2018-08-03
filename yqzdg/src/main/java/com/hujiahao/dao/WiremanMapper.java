package com.hujiahao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hujiahao.model.Order;
import com.hujiahao.model.Wireman;

public interface WiremanMapper {
    int deleteByPrimaryKey(Integer wiremanId);

    int insert(Wireman record);

    int insertSelective(Wireman record);

    Wireman selectByPrimaryKey(Integer wiremanId);

    int updateByPrimaryKeySelective(Wireman record);

    int updateByPrimaryKey(Wireman record);

    //电工个人订单显示接口
	List<Wireman> selectWiremanAllByOpenid(@Param("openId")String openId ,@Param("orderStatus") String orderStatus);

	int updateByOpenIdSelective(Wireman wireman);

	//电工个人信息显示接口
	List<Wireman> selectWiremanByOpenid(@Param("openId")String openId );
	
}