package com.kyuboard.domain;

import java.util.Date;

public class KyuMemberVO {
	
	/*
	 userId 	CHAR(30) 	not null, 
	 userPss 	CHAR(100)	not null, 
	 userName	CHAR(30) 	not null, 
	 regDate 	DATE		DEFAULT SYSDATE(),
	 */
	
	private String userId;
	private String userPass;
	private String userName;
	private Date regDate;

//-------------------getter setter-----------------------------
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	//-------------------toString-----------------------------	
	@Override
	public String toString() {
		return "KyuMemberVO [userId=" + userId + ", userPass=" + userPass + ", userName=" + userName + ", regDate="
				+ regDate + "]";
	}

}
