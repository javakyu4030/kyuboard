package com.kyuboard.domain;

import java.util.Date;

public class KyuBoardVO {

	/*
	 CREATE TABLE tbl_board(
	bno 		INT	 			NOT NULL auto_increment,
	title 	VARCHAR(50)		NOT NULL ,
	content 	TEXT				NOT NULL ,
	writer 	VARCHAR(30)		NOT NULL ,
	regDate 	TIMESTAMP		DEFAULT NOW(),
	viewCnt 	INT				DEFAULT 0 ,
	PRIMARY KEY(bno)
	
	# 칼럼역할
#	bno 각 게시물을 구분할 고유번호
#	title 게시물의 제목
#	content 	게시물 내용
#	writer 	작성자
#	regDate 작성일
#	viewCnt 	조회수
	 */
	
	private int bno; 		
	private String title; 
	private String content; 	
	private String writer; 	
	private Date regDate; 	
	private int viewCnt;
	
	//----------------getter setter----------------------
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	} 
	
	
}
