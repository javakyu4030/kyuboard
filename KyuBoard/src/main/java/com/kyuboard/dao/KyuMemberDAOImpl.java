package com.kyuboard.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.kyuboard.domain.KyuMemberVO;

@Service
public class KyuMemberDAOImpl implements KyuMemberDAO {

	//마이바티스
	@Inject
	private SqlSession sql;
	
	//매퍼
	private static String namespace = "com.kyuboard.mappers.KyuMemberMapper";
	
	//회원가입
	@Override
	public void register(KyuMemberVO vo) throws Exception {
		sql.insert(namespace + ".register", vo);
	}

	//로그인
	@Override
	public KyuMemberVO login(KyuMemberVO vo) throws Exception {
		//return sql.selectOne(namespace + ".login", vo);
		return sql.selectOne(namespace + ".loginBcrypt", vo);
	}

	//회원정보 수정
	@Override
	public void modify(KyuMemberVO vo) throws Exception {
		sql.update(namespace + ".modify", vo);
	}

	//회원 탈퇴
	@Override
	public void withdrawal(KyuMemberVO vo) throws Exception {
		sql.delete(namespace + ".withdrawal", vo);
	}

	//아이디 확인
	@Override
	public KyuMemberVO idCheck(String userId) throws Exception {
		return sql.selectOne(namespace + ".idCheck", userId);
	}

}
