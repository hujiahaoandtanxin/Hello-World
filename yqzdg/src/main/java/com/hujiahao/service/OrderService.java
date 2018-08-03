package com.hujiahao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hujiahao.dao.OrderMapper;
import com.hujiahao.model.Order;


@Service
public class OrderService {
	@Autowired
	OrderMapper orderMapper;
	 
	public void saveOrder(Order record) {
		orderMapper.insertSelective(record);
	}

	public Order select(Integer orderId) {
		// TODO Auto-generated method stub
		Order order = orderMapper.selectByPrimaryKey(orderId);
		return order;
	}

	public List<Order> selectAll(Integer orderStatus) {
		List<Order> orderList = orderMapper.selectOrderAndBusinessType(orderStatus);
		return orderList;
	}
	
	//订单 0-1  + 电工id更新
	public Integer updateToUnFinish(Integer orderId,Integer changedStatus,Integer wiremanId) {
		int result = orderMapper.updateToUnFinish(orderId,changedStatus,wiremanId);
		return result;	
	}
	
	//订单1-2 
	public Integer updateToFinish(Integer orderId,Integer changedStatus) {
		int result = orderMapper.updateToFinish(orderId,changedStatus);
		return result;	
	}

	public Integer deleteOrderInfo(Integer orderId) {
		Integer result = orderMapper.deletOrderInfo(orderId);
		return result;
	}
	
	//只查询三条
	public List<Order> selectLimit(Integer orderStatus){
		List<Order> orderList = orderMapper.selectOrderToLimit(orderStatus);
		return orderList;
	}
	
	//用户评价更新
	public int updateOrderRemarkByOrderId(String remark , Integer orderId) {
		int result = orderMapper.updateOrderRemarkByOrderId(remark, orderId);
		return result;
		
	}
}
