package com.kyuboard.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kyuboard.dao.KyuReplyDAO;
import com.kyuboard.domain.KyuReplyVO;


@Service
public class KyuReplyServiceImpl implements KyuReplyService {

	@Inject
	private KyuReplyDAO dao;
	
	//댓글 조회
	@Override
	public List<KyuReplyVO> list(int bno) throws Exception {
		return dao.list(bno);
	}

	//댓글 작성
	@Override
	public void write(KyuReplyVO vo) throws Exception {
		dao.write(vo);
		
	}

	//댓글 수정
	@Override
	public void modify(KyuReplyVO vo) throws Exception {
		dao.modify(vo);
		
	}

	//댓글 삭제
	@Override
	public void delete(KyuReplyVO vo) throws Exception {
		dao.delete(vo);
		
	}

}
