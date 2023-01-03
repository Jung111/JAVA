package com.poseidon.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.dto.LoginDTO;
import com.poseidon.service.LoginService;
import com.poseidon.util.IpGet;
//아침에 할 일
/* 1. 프로젝트 새로 만들기
 * 2. xml복사하기
 * 3. 컨트롤러 만들기
 * 4. service, dao, dto만들기
 * 5. 수업시작하기
 * 
 * 
 */
@Controller
public class LoginController {
	@Autowired
	private IpGet IpGet;
	@Autowired
	private LoginService loginService;

	@GetMapping(value = "/index")
	public String i() {
		return "login";
	}
	
	@GetMapping(value = "/test")
	public String test() {
		return "test";
	}
	
	@GetMapping(value = "/")
	public String index() {
		return "login";
	}
	
	//@RequestMapping(value = "", )
	@GetMapping(value = "login")
	public String login() {
		return "login";
	}
	
	@PostMapping(value = "login")
	public ModelAndView join(HttpServletRequest request) {
		//값 오는지 확인하시고 잡아주세요.
		//DTO만들어서 거기다가 넣어주세요.
		//mv.setViewName("/login2");//이건 jsp
		//mv.setViewName("redirect:/login1");//이건 컨트롤러		
		ModelAndView mv = new ModelAndView("redirect:/login?error=error");
		if(request.getParameter("id") != "" &&
				request.getParameter("pw") != "") {
			LoginDTO dto = new LoginDTO();
			dto.setMember_id(request.getParameter("id"));
			dto.setMember_pw(request.getParameter("pw"));
			//데이터베이스
			//서비스 -> dao -> sqlSession -> Mybatis -> DB
			LoginDTO dto2 = loginService.login(dto);
			
			if(dto2 != null) {
				//System.out.println(dto2.getMember_name());
				//System.out.println(dto2.getMember_no());
				//세션만들어주기
				HttpSession session = request.getSession();
				session.setAttribute("name", dto2.getMember_name());
				session.setAttribute("no", dto2.getMember_no());
				
				//log 남기기
				//ip 가져와서 연결하기

				
				mv.setViewName("redirect:/main");
			}
		
		HashMap<String, Object> log = new HashMap<String, Object>();
		//String ip = IpGet.getUserIP(request);
		log.put("ip", IpGet.getUserIP(request));
		log.put("lcate",1);
		log.put("lete","[로그인] " + request.getParameter("id"));
		loginService.logWrite(log);
	}
		return mv;
	}

	
	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("name") != null) {
			session.removeAttribute("name");
		}
		if(session.getAttribute("no") != null) {
			session.removeAttribute("no");
		}
		return "redirect:/login";
	}
	

}
