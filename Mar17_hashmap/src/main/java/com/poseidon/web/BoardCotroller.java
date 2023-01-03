package com.poseidon.web;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.dto.BoardDTO;
import com.poseidon.service.BoardService;
import com.poseidon.util.CommandMap;

//어려운거 잘 해주시고 계십니다. 
//능력단위명 통합구연

@Controller
public class BoardCotroller {

	@Autowired
	private BoardService boardService;
	// 데이터 붙이기 = 게시판
	// 1. 컨트롤러 만들기
	// 2. 이 맵핑 이동해주세요.
	// 3. 서비스, dao,만들어주세요

	//HashMap을 이용해서 전송받았습니다.
	//DTO가 없어도 됩니다 
	@GetMapping(value = "/mainh")
	public ModelAndView listH() {
		ModelAndView mv = new ModelAndView("main");
		ArrayList<HashMap<String, Object>> list = boardService.listh();
		mv.addObject("list", list);
		return mv;
	}
	
	// 데이터 붙이기 = 게시판
	// 1. 컨트롤러 만들기
	// 2. 이 맵핑 이동해주세요.
	// 3. 서비스, dao,만들어주세요
	
	//DTO를 활용해서 리스트 전송받았습니다.
	@GetMapping(value = "/main")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("main");
		ArrayList<BoardDTO> list = boardService.list();
		mv.addObject("list", list);
		return mv;
	}

	@GetMapping(value = "detail")
	public ModelAndView detail(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("detail");
		//값
		int no = Integer.parseInt(request.getParameter("no"));
		//System.out.println(no);
		BoardDTO dto = boardService.detail(no);
		mv.addObject("dto", dto);
		return mv; 
	}
	//, method = {RequestMethod.GET, RequestMethod.POST}
	@RequestMapping(value = "write")
	public String write(CommandMap map, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("name") != null 
				&& session.getAttribute("no") != null) {
			if(request.getParameter("title") != null
					&& request.getParameter("content") != null) {
				//글쓰기 = 데이터베이스로
				BoardDTO dto = new BoardDTO();
				dto.setBoard_title(request.getParameter("title"));
				dto.setBoard_content(request.getParameter("content"));
				//세션도 넣어주세요.
				dto.setMember_no((Integer) session.getAttribute("no"));
				
				boardService.write(dto);
				
				//hashmap으로 만들기
				//HashMap<String, Object> map = new HashMap<String, Object>();
				//map.put("board_title", request.getParameter("title"));
				//map.put("board_content", request.getParameter("content"));
				//map.put("member_no", session.getAttribute("no"));
				
				//commandMap활용하기
				System.out.println(map.get("title"));
				System.out.println(map.get("content"));
				System.out.println(map);
				
				//boardService.write2(map);
				
				
				
				
				
				
				
				return "redirect:/main";
			} else {
				//write.jsp파일 보여주기
				return "write";
			}
		} else {
			return "redirect:/login?error=login";
		}
	}
	
	@GetMapping(value = "write2")
	public String write__(HttpServletRequest request) {
		//세션
		HttpSession session = request.getSession();
		if(session.getAttribute("name") != null &&
				session.getAttribute("no") != null	) {
			return "write";			
		}else {
			return "redirect:/login?error=login";
		}
	}
	
	@PostMapping(value = "write2")
	public String writeA__(CommandMap map, HttpServletRequest request) {
		//여기다가 오는 값 찍어주세요.
		//System.out.println(request.getParameter("title"));
		//System.out.println(request.getParameter("content"));

		//로그인 되어있는 사람, title, content값이 있어야 됩니다.
		HttpSession session = request.getSession();
		
		//서비스 - DAO - mybatis - maria
		if(session.getAttribute("no") != null 
				&& session.getAttribute("name") != null
				&& request.getParameter("title") != ""
				&& request.getParameter("content") != "") {
			BoardDTO dto = new BoardDTO();
			dto.setBoard_title(request.getParameter("title"));
			dto.setBoard_content(request.getParameter("content"));//만들어주세요
			//세션도 넣어주세요.
			dto.setMember_no((Integer) session.getAttribute("no"));
			
			//boardService.write(dto);
			System.out.println(map.get("title"));
			System.out.println(map.get("content"));
			//System.out.println(map);
			//dto없이 데이터를 전송시킬 수 있습니다.
			//코드가 간단.
			
			//정해진 값 이외의 값이 들어올 수 있습니다.
			map.put("member_no", session.getAttribute("no"));
			
			boardService.write2(map.getMap());
			
			
			return "redirect:/main";
		}else {
			return "redirect:/login?error=login";
		}
		
		
	}
	
	//수정하기
	@GetMapping(value = "/update")
	public ModelAndView update(
			BoardDTO dto, CommandMap map, HttpServletRequest request) {
		System.out.println("들어온 bno값은? " + dto.getBno());
		System.out.println("commendMap " + map.get("bno"));
		System.out.println(request.getParameter("bno"));
		
		ModelAndView mv = new ModelAndView("update");
		HttpSession session = request.getSession();
		dto.setMember_no((Integer) session.getAttribute("no"));
 		dto = boardService.detail(dto);
 		
		mv.addObject("dto", dto);
		return mv;
	}
	
	
	
}
