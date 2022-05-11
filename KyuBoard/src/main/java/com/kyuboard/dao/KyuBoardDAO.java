package com.kyuboard.dao;

import java.util.List;

import com.kyuboard.domain.KyuBoardVO;

public interface KyuBoardDAO {
	
	//게시물 목록
	public List<KyuBoardVO> list() throws Exception;
	
	//게시물 작성
	public void write(KyuBoardVO vo) throws Exception;
	
	//게시물 조회
	public KyuBoardVO view(int bno) throws Exception;
	
	//게시물 수정
	public void modify(KyuBoardVO vo) throws Exception;
	
	//게시물 삭제
	public void delete(int bno) throws Exception;
	
	//게시물 총 갯수
	public int count() throws Exception;
	
	//게시물 목록 + 페이징
	public List<KyuBoardVO> listPage(int displayPost, int postNum) throws Exception;
	
	// 게시물 목록 + 페이징 + 검색
	 public List<KyuBoardVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception;
	
	 //게시물 총 갯수 + 검색적용
	 public int searchCount(String searchType, String keyword) throws Exception;
	 
}
