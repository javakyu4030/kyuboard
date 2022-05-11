package com.kyuboard.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kyuboard.domain.KyuReplyVO;
import com.kyuboard.service.KyuReplyService;

@Controller
@RequestMapping("/reply/*")
public class KyuReplyController {

	@Inject
	private KyuReplyService KyuReplyService;
	
	//댓글 조회
	
	//댓글 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWrite(KyuReplyVO vo) throws Exception {
		
		KyuReplyService.write(vo);
		
		return "redirect:/board/view?bno=" + vo.getBno();
	}

	//댓글 수정

	//댓글 삭제

}
