package com.hujiahao.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.hujiahao.dao.BusinessTypeMapper;
import com.hujiahao.model.BusinessType;
import com.hujiahao.model.Wireman;

@Service
public class BusinessTypeService {
	@Autowired
	BusinessTypeMapper businessTypeMapper;
	
	public Integer selectBusinessTypeId(String typeName) {
		Integer selectBusinessTypeId = businessTypeMapper.selectBusinessTypeId(typeName);
		return selectBusinessTypeId;
		
	}

	public List<BusinessType> selectProject() {
		List<BusinessType> projectList = businessTypeMapper.selectBusinessAll();
		return projectList;
	}
	
	public List<BusinessType> selectByPages(Integer currentPage,Integer sumPage){
		List<BusinessType> businessList = businessTypeMapper.selectBusinessPage(currentPage,sumPage);
		return businessList;
		
	}
	
	public Double selectSumPages(){
		Double result = businessTypeMapper.selectSumPages();
		return result;
		
	}

	/**
	 * 项目表关联订单表
	 * @param typeName
	 * @return
	 */
	public List<BusinessType> selectOrderByBusinessType(String typeName) {
		List<BusinessType> orderList = businessTypeMapper.selectOrderByBusinessType(typeName);
		return orderList;
	}
	
	
}
