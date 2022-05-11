package com.kyuboard.service;

import com.kyuboard.domain.KyuMemberVO;

public interface KyuMemberService {
	
	//회원가입
	public void register(KyuMemberVO vo) throws Exception;
	
	//로그인
	public KyuMemberVO login(KyuMemberVO vo) throws Exception;
	
	//회원정보 수정
	public void modify(KyuMemberVO vo) throws Exception;

	//회원탈퇴
	public void withdrawal(KyuMemberVO vo) throws Exception;

	//아이디 확인
	public KyuMemberVO idCheck(String userId) throws Exception;
}
