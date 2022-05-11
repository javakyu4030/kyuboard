package com.kyuboard.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kyuboard.dao.KyuMemberDAO;
import com.kyuboard.domain.KyuMemberVO;

@Service
public class KyuMemberServiceImpl implements KyuMemberService {
	
	@Inject
	private KyuMemberDAO dao;
	
	//회원가입
	@Override
	public void register(KyuMemberVO vo) throws Exception {
		dao.register(vo);
		
	}

	//로그인
	@Override
	public KyuMemberVO login(KyuMemberVO vo) throws Exception {
		return dao.login(vo);
	}

	//회원정보 수정
	@Override
	public void modify(KyuMemberVO vo) throws Exception {
		dao.modify(vo);
	}

	//회원탈퇴
	@Override
	public void withdrawal(KyuMemberVO vo) throws Exception {
		dao.withdrawal(vo);
	}

	//아이디 확인
	@Override
	public KyuMemberVO idCheck(String userId) throws Exception {
		return dao.idCheck(userId);
	}

}
