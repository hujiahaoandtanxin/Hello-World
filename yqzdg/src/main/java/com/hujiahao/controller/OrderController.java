package com.hujiahao.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hujiahao.model.BusinessType;
import com.hujiahao.model.Msg;
import com.hujiahao.model.Order;
import com.hujiahao.service.BusinessTypeService;
import com.hujiahao.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	BusinessTypeService businessTypeService;

	/**
	 * 将客户发起的订单信息（订单号，服务类型，地址，纬度，经度，电话号码）保存到数据库
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/saveOrder", method = RequestMethod.GET)
	@ResponseBody
	public Msg addOrder(Order record) {

		// 订单号出来
		SimpleDateFormat simpleDateFormat;
		simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String str = simpleDateFormat.format(date);
		int newDate = Integer.parseInt(str);
		Random random = new Random();
		int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
		record.setOrderId(newDate + rannum);

		// 添加数据
		orderService.saveOrder(record);

		// 订单的总处理
		Gson gson = new Gson();
		String json = gson.toJson(record);
		System.out.println("插入成功" + json);
		return Msg.success();
	}

	/**
	 * 显示订单
	 * 一对一查询
	 * 查询order表，business_type表，
	 * @return
	 */
	@RequestMapping(value = "/showOrder", method = RequestMethod.GET)
	@ResponseBody//默认把对象返回---变成json字符串
	public Map<String,Object> selectOrder() {
			//重新包装订单信息
			Map  map = new HashMap();
			List<Order> list0 = orderService.selectAll(0);		
			List<Order> list1 = orderService.selectAll(1);
			List<Order> list2 = orderService.selectAll(2);	
			map.put("未接单", list0);
			map.put("未完成", list1);
			map.put("已完成", list2);
			return map;
	}
	
	/**
	 * 更新订单信息---把订单状态：未完成1----已完成2
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/updateOrderToFinish", method = RequestMethod.GET)
	@ResponseBody//默认把对象返回---变成json字符串
	public Msg updateOrderToFinish(@RequestParam("orderId") Integer orderId , Integer changedStatus) {
		Integer result = orderService.updateToFinish(orderId ,2);
		System.out.println(result);
		return Msg.success();	
	}
	
	@RequestMapping(value = "/deleteOrder", method = RequestMethod.GET)
	@ResponseBody//默认把对象返回---变成json字符串
	public Msg deleteOderInfo(@RequestParam("orderId") Integer orderId) {
		Integer result = orderService.deleteOrderInfo(orderId);
		return Msg.success();
	}
	
	/**
	 * 显示订单到电工端首页
	 * 一对一查询
	 * 查询order表，business_type表，
	 * @return
	 */
	@RequestMapping(value = "/selectOrderToWireman", method = RequestMethod.GET)
	@ResponseBody//默认把对象返回---变成json字符串
	public List<Order>  selectOrderToWireman() {
		List<Order> orderList = orderService.selectLimit(0);
			return orderList;
	}
	
	/**
	 * 更新订单信息---把订单状态：未匹配0----未完成1 ,更新订单的电工id
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/updateToUnFinish", method = RequestMethod.GET)
	@ResponseBody//默认把对象返回---变成json字符串
	public Msg updateToUnFinish(@RequestParam("orderId") Integer orderId , Integer changedStatus,Integer wiremanId) {
		Integer result = orderService.updateToUnFinish(orderId ,1,wiremanId);
		System.out.println(result);
		return Msg.success();	
	}
	
	/**
	 * 更新订单信息---把订单状态：未匹配1----未完成2 ,更新订单的电工id
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/updateOrderToMatched", method = RequestMethod.GET)
	@ResponseBody//默认把对象返回---变成json字符串
	public Msg updateOrderToMatched(@RequestParam("orderId") Integer orderId , Integer changedStatus) {
		Integer result = orderService.updateToFinish(orderId ,1);
		System.out.println(result);
		return Msg.success();	
	}
	
	/**
	 * 用户评价页面的更新
	 * @param orderId
	 * @param remark
	 * @return
	 */
	@RequestMapping("/updateOrderRemarkByOrderId")
	@ResponseBody
	public Msg updateOrderRemarkByOrderId(@RequestParam("orderId") Integer orderId ,String remark) {
		int result = orderService.updateOrderRemarkByOrderId(remark, orderId);
		System.out.println(result);
		return Msg.success();
		
	}
}
