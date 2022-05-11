package com.kyuboard.dao;

import java.util.List;

import com.kyuboard.domain.KyuReplyVO;

public interface KyuReplyDAO {

	// 댓글 조회
	public List<KyuReplyVO> list(int bno) throws Exception;

	// 댓글 작성
	public void write(KyuReplyVO vo) throws Exception;

	// 댓글 수정
	public void modify(KyuReplyVO vo) throws Exception;

	// 댓글 삭제
	public void delete(KyuReplyVO vo) throws Exception;
}
