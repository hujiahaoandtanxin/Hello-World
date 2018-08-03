package com.hujiahao.model;

import java.util.List;

public class Wireman {
    private Integer wiremanId;

    private String username;

    private String password;

    private String openId;

    private String nickName;

    private String headPicUrl;

    private String sex;

    private String mobilePhone;

    private String status;

    private String idcard;

    private String credPicUrl;

    private String credStatus;
    
    private String detail;
    
    private List<Order> orderList;
    
    private User user;
    
    

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getWiremanId() {
        return wiremanId;
    }

    public void setWiremanId(Integer wiremanId) {
        this.wiremanId = wiremanId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getHeadPicUrl() {
        return headPicUrl;
    }

    public void setHeadPicUrl(String headPicUrl) {
        this.headPicUrl = headPicUrl == null ? null : headPicUrl.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getCredPicUrl() {
        return credPicUrl;
    }

    public void setCredPicUrl(String credPicUrl) {
        this.credPicUrl = credPicUrl == null ? null : credPicUrl.trim();
    }

    public String getCredStatus() {
        return credStatus;
    }

    public void setCredStatus(String credStatus) {
        this.credStatus = credStatus == null ? null : credStatus.trim();
    }
}