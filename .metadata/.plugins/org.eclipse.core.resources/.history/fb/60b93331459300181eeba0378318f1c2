package com.hujiahao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hujiahao.model.BusinessType;

public interface BusinessTypeMapper {
    int deleteByPrimaryKey(Integer businessTypeId);

    int insert(BusinessType record);

    int insertSelective(BusinessType record);

    BusinessType selectByPrimaryKey(Integer businessTypeId);

    int updateByPrimaryKeySelective(BusinessType record);

    int updateByPrimaryKey(BusinessType record);
    
    Integer selectBusinessTypeId(@Param("typeName")String typeName);
    
    //查询项目信息
    List<BusinessType> selectBusinessAll();
    
    //分页查询项目信息
    List<BusinessType> selectBusinessPage(@Param("currentPage") Integer currentPage,@Param("sumPage") Integer sumPage);
    
    //查询总页数
    Double  selectSumPages();

    //查询订单+项目
	List<BusinessType> selectOrderByBusinessType(String typeName);
}