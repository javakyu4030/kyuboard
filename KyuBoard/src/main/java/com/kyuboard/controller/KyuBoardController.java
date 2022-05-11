package com.kyuboard.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyuboard.domain.KyuBoardVO;
import com.kyuboard.domain.KyuReplyVO;
import com.kyuboard.domain.Page;
import com.kyuboard.service.KyuBoardService;
import com.kyuboard.service.KyuReplyService;

@Controller
@RequestMapping("/board/*")
public class KyuBoardController {
private static final Logger logger  = LoggerFactory.getLogger(KyuBoardController.class);

	@Inject
	private KyuBoardService service;
	
	@Inject
	private KyuReplyService replyService;
	
	//게시물 목록
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void getList(Model model) throws Exception {
		
		List<KyuBoardVO> list = null;
		list = service.list();
		
		model.addAttribute("list", list);
	}
	
	//게시물 작성(GET)
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWrite(HttpSession session, Model model) throws Exception {
		logger.info("get write");
			
		
		Object loginInfo = session.getAttribute("member");
		
		if(loginInfo == null) {
			model.addAttribute("msg", false);
		}
		
	}
	
	//게시물 작성(POST)
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWrite(KyuBoardVO vo) throws Exception {
		logger.info("post write");
		service.write(vo);
		
		return "redirect:/board/list";
	}
	
	//게시물 조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("bno") int bno, Model model) throws Exception {
		
		KyuBoardVO vo = service.view(bno); 
		
		model.addAttribute("view", vo);
		
	//댓글 조회
	List<KyuReplyVO> reply = null;
	reply = replyService.list(bno);
	model.addAttribute("reply", reply);
		
	}
	
	//게시물 수정(GET)
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getModify(@RequestParam("bno") int bno, Model model) throws Exception {
		
		KyuBoardVO vo = service.view(bno); 
		
		model.addAttribute("view", vo);
	}
	
	//게시물 수정(POST)
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postModify(KyuBoardVO vo) throws Exception {
		
		service.modify(vo);
		
		return "redirect:/board/view?bno=" + vo.getBno();
	
	}
	
	//게시물 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("bno")int bno) throws Exception {
		
		service.delete(bno);
		
		return "redirect:/board/list";
		
	}
	
	
	//게시물 목록 + 페이징 추가
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public void getListPage(Model model, @RequestParam("num") int num) throws Exception {
		
		Page page = new Page();
		
		page.setNum(num);
		page.setCount(service.count());
		
		List<KyuBoardVO> list = null;
		list = service.listPage(page.getDisplayPost(), page.getPostNum());
		
		model.addAttribute("list", list);
		/*
		model.addAttribute("pageNum", page.getPageNum());
		
		model.addAttribute("startPageNum", page.getStartPageNum());
		model.addAttribute("endPageNum", page.getEndPageNum());
		
		model.addAttribute("prev", page.getPrev());
		model.addAttribute("next", page.getPrev());
		 */
		
		model.addAttribute("page", page);
		model.addAttribute("select", num);
		
		
		/*
		//게시물 총 갯수
		int count = service.count();
		
		//한페이지에 출력할 게시물 갯수
		int postNum = 10;
		
		//하단 페이징 번호 ([게시물 총 갯수 / 한 페이지에 출력할 갯수]의 올림)
		int pageNum = (int)Math.ceil((double)count/postNum);
		
		//출력할 게시물
		int displayPost = (num - 1) * postNum;
		
		
		//한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 10;
		
		//표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt);
		
		//표시되는 페이지 번호 중 첫번쨰 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		
		//마지막 번호 재계산   (why?->[ ((올림)(11 / 10)) * 10 => (올림)1.1 * 10 => 2 * 10 = 20 ] 이 됨 즉, 13 ~ 20까지 없어야할 페이지 번호가 출력
		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNum_cnt));		//count ->게시물 총 갯수
		
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= count ? false : true;
		
		List<KyuBoardVO> list = null;
		list = service.listPage(displayPost, postNum);
		model.addAttribute("list", list);
		model.addAttribute("pageNum", pageNum);
		
		//시작 및 끝 번호
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		
		// 이전 및 다음
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		
		//현재 페이지
		model.addAttribute("select", num);
		*/
		
		//memo
		// 매개변수로 num 은 페이지 번호
		//1. 게시물의 총 갯수를 구하고
		//한 페이지당 출력할 게시물 갯수를 정하고(10개)
		//하단에 표시할 페이징 번호의 갯수를 구하고(소수점은 올림)
		//현재 페이지를 기준으로 10개의 데이터를 출력
		
	}
	
	// 게시물 목록 + 페이징 추가 + 검색
	@RequestMapping(value = "/listPageSearch", method = RequestMethod.GET)
	public void getListPageSearch(Model model, @RequestParam("num") int num, 
			@RequestParam(value = "searchType", required = false, defaultValue = "title") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword
			) throws Exception {
		
		
		Page page = new Page();
		
		page.setNum(num);
		//page.setCount(service.count());  
		page.setCount(service.searchCount(searchType, keyword));
		
		//검색 타입과 검색어
		//page.setSearchTypeKeyword(searchType, keyword);
		page.setSearchType(searchType);
		page.setKeyword(keyword);
		
		List<KyuBoardVO> list = null; 
		//list = service.listPage(page.getDisplayPost(), page.getPostNum());
		list = service.listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("select", num);
		
		//model.addAttribute("searchType", searchType);
		//model.addAttribute("keyword", keyword);
	}
	
}
