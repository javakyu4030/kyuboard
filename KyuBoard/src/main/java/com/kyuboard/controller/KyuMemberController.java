package com.kyuboard.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kyuboard.domain.KyuMemberVO;
import com.kyuboard.service.KyuMemberService;

@Controller
@RequestMapping("/member/*")
public class KyuMemberController {

	private static final Logger Logger = LoggerFactory.getLogger(KyuMemberController.class);

	@Inject
	KyuMemberService service;

	
	 @Autowired BCryptPasswordEncoder passEncoder;
	 

	// 회원가입 GET
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getRegister() throws Exception {
		Logger.info("get register");
	}

	// 회원가입 POST
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(KyuMemberVO vo) throws Exception {
		Logger.info("get register");

		String inputPass = vo.getUserPass();
		String pass = passEncoder.encode(inputPass);
		vo.setUserPass(pass);

		service.register(vo);

		return "redirect:/";
	}

	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(KyuMemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		Logger.info("post login");

		HttpSession session = req.getSession();
		KyuMemberVO login = service.login(vo);
		// System.out.println(login.toString()); //오류 탐색용 탐침봉
		
		boolean passMatch = passEncoder.matches(vo.getUserPass(), login.getUserPass());
	
		if (login != null && passMatch) {
			
			session.setAttribute("member", login);
			
		} else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		}

		/*
		if (login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		} else {
			session.setAttribute("member", login);
		}*/


		return "redirect:/";
	}

	// 회원정보 수정 GET
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getModify() throws Exception {
		Logger.info("get modify");
	}

	// 회원정보 수정 POST
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postModify(HttpSession session, KyuMemberVO vo) throws Exception {
		Logger.info("post modify");

		service.modify(vo);

		session.invalidate();

		return "redirect:/";

	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		Logger.info("get logout");

		session.invalidate();

		return "redirect:/";
	}

	// 회원탈퇴 GET
	@RequestMapping(value = "/withdrawal", method = RequestMethod.GET)
	public void getWithdrawal() throws Exception {
		Logger.info("get withdrawal");
	}

	// 회원탈퇴 POST
	@RequestMapping(value = "/withdrawal", method = RequestMethod.POST)
	public String postWithdrawal(HttpSession session, KyuMemberVO vo, RedirectAttributes rttr) throws Exception {
		Logger.info("post withdrawal");

		System.out.println("========================0"); // 오류 탐색용 탐침봉
		KyuMemberVO member = (KyuMemberVO) session.getAttribute("member");

		System.out.println(member.toString()); // 오류 탐색용 탐침봉
		System.out.println("========================1"); // 오류 탐색용 탐침봉

		String oldPass = member.getUserPass();
		System.out.println("========================2"); // 오류 탐색용 탐침봉
		String newPass = vo.getUserPass();

		System.out.println("========================3");// 오류 탐색용 탐침봉

		if (!(oldPass.equals(newPass))) {
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/withdrawal";
		}

		service.withdrawal(vo);

		session.invalidate();

		return "redirect:/";
	}

	// 회원 확인
	@ResponseBody
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public int postIdCheck(HttpServletRequest req) throws Exception {
		Logger.info("post idCheck");

		System.out.println("----------------------------0");

		String userId = req.getParameter("userId"); // 사용자가 입력한 데이터값을 userId에 넣는 작업
		System.out.println("----------------------------1");
		System.out.println(userId.toString());

		KyuMemberVO idCheck = service.idCheck(userId); // 문제의 위치

		System.out.println("----------------------------2");

		int result = 0;

		if (idCheck != null) {
			result = 1;
		}
		return result;
	}
}
