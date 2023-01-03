package com.poseidon.web;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.service.BoardService;
import com.poseidon.util.CommandMap;
import com.poseidon.util.IpGet;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class BoardCotroller {

	@Autowired
	private IpGet IpGet;
	
	
	@Autowired
	private BoardService boardService;

	@GetMapping(value = "/main")
	public ModelAndView list(CommandMap map, HttpServletRequest request) {
		int page = 1;
		if (map.containsKey("page")) {
			page = Integer.parseInt((String) map.get("page"));
		}
		map.put("page", (page - 1) * 10);

		ModelAndView mv = new ModelAndView("main");
		ArrayList<HashMap<String, Object>> list = boardService.list(map.getMap());
		mv.addObject("list", list);
		mv.addObject("totalCount", list.get(0).get("count"));
		mv.addObject("page", page);
		
		HttpSession session = request.getSession();
		if(session.getAttribute("name") != null 
				&& session.getAttribute("no") != null) {
			
			//쪽지가 등장한다면?
			//int jjokjiCount = loginService.jjokjiCount(session.getAttribute("no"));
			int jjokjiCount = boardService.jjokjiCount(session.getAttribute("no"));
			
			if(jjokjiCount > 0) {
				mv.addObject("jjokjiCount", jjokjiCount);
			}
		}
		
		//아이피 찍어보기
		/*
		 * System.out.println(" YOUR IP ▼ ");
		 * System.out.println(IpGet.getUserIP(request));
		 */
		HashMap<String, Object> log = new HashMap<String, Object>();
		//String ip = IpGet.getUserIP(request);
		log.put("ip", IpGet.getUserIP(request));
		if (session.getAttribute("no") != null ) {
			log.put("lname", session.getAttribute("no"));
		}
		log.put("lcate","[출력]main 접근");
		boardService.logWrite(log);
		return mv;
	}

	@GetMapping(value = "main2")
	public ModelAndView main2(CommandMap map, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("main2");

		PaginationInfo paginationInfo = new PaginationInfo();
		// 현재 페이지 번호
		int pageNo = 1;
		// 한 페이지에 나올 글 수
		int listScale = 10;
		// 페이지 수
		int pageScale = 5;

		if (map.getMap().size() > 0) {
			pageNo = Integer.parseInt((String) map.get("pageNo"));
		}

		paginationInfo.setCurrentPageNo(pageNo);
		paginationInfo.setRecordCountPerPage(listScale);
		paginationInfo.setPageSize(pageScale);

		int startPage = paginationInfo.getFirstRecordIndex();
		int lastPage = paginationInfo.getRecordCountPerPage();

		map.put("startPage", startPage);
		map.put("lastPage", lastPage);

		// 전체 글 수 boardList
		ArrayList<HashMap<String, Object>> boardList 
							= boardService.boardList(map.getMap());
		// 전체 게시물 수
		int totalList = boardService.boardListCount();
		paginationInfo.setTotalRecordCount(totalList);
		
		mv.addObject("pageNo", pageNo);
		mv.addObject("boardList", boardList);
		mv.addObject("totalList", totalList);
		mv.addObject("paginationInfo", paginationInfo);

		
		
		return mv;
	}
	
	//mainAjax
	@PostMapping(value = "/mainAjax", produces = "text/plain;charset=utf-8")
	public @ResponseBody String mainAjax(CommandMap map) {
		PaginationInfo paginationInfo = new PaginationInfo();
		int pageNo = 1;
		int listScale = 10;
		int pageScale = 5;

		if (map.getMap().size() > 0) {
			pageNo = Integer.parseInt((String) map.get("pageNo"));
		}

		paginationInfo.setCurrentPageNo(pageNo);
		paginationInfo.setRecordCountPerPage(listScale);
		paginationInfo.setPageSize(pageScale);

		int startPage = paginationInfo.getFirstRecordIndex();
		int lastPage = paginationInfo.getRecordCountPerPage();

		map.put("startPage", startPage);
		map.put("lastPage", lastPage);

		ArrayList<HashMap<String, Object>> boardList 
							= boardService.boardList(map.getMap());
		int totalList = boardService.boardListCount();
		paginationInfo.setTotalRecordCount(totalList);
		
		//mv.addObject("boardList", boardList);
		//mv.addObject("paginationInfo", paginationInfo);
		
		StringBuffer sb = new StringBuffer();
		sb.append("{\"pageNo\":" +pageNo);
		sb.append(", \"totalList\" :"+totalList);
		sb.append(", \"boardList\" : [");
		
		for (int i = 0; i < boardList.size(); i++) {
			sb.append("{\"board_no\" : " + boardList.get(i).get("board_no"));
			sb.append(", \"board_title\" : \"" + boardList.get(i).get("board_title") + "\"");
			sb.append(", \"comments\" : \"" + boardList.get(i).get("comments") + "\"");
			sb.append(", \"board_date\" : \"" + boardList.get(i).get("board_date") + "\"");
			sb.append(", \"member_name\" : \"" + boardList.get(i).get("member_name") + "\"");
			sb.append(", \"board_views\" : \"" + boardList.get(i).get("board_views") + "\"");
			sb.append("}");
			if(i != (boardList.size() -1)) {
				sb.append(",");
			}
		}
		sb.append("]}");
		
		System.out.println(sb.toString());

		
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	
	
	

}
/*
 {"pageNo":1, "totalList" :214,
  "boardList" : [
  		{"board_no" : 266, "board_title" : "그림 올리기", "comments" : "0", "board_date" : "2021-03-25", "member_name" : "포세이돈", "board_views" : "0"}
  		,{"board_no" : 264, "board_title" : "2021-03-19일 수업", "comments" : "12", "board_date" : "2021-03-19", "member_name" : "포세이돈", "board_views" : "0"}
  		,{"board_no" : 261, "board_title" : "map이 동작하나요?", "comments" : "2", "board_date" : "2021-03-17", "member_name" : "포세이돈", "board_views" : "0"}
  		,{"board_no" : 260, "board_title" : "map이 동작하나요?", "comments" : "1", "board_date" : "2021-03-17", "member_name" : "포세이돈", "board_views" : "0"}
  		,{"board_no" : 259, "board_title" : "1111111111", "comments" : "1", "board_date" : "2021-03-17", "member_name" : "포세이돈", "board_views" : "0"}
  		,{"board_no" : 258, "board_title" : "eeeeeeeeeeeeeeee", "comments" : "4", "board_date" : "2021-03-17", "member_name" : "포세이돈", "board_views" : "0"}
  		,{"board_no" : 257, "board_title" : "dddddddddddd", "comments" : "4", "board_date" : "2021-03-17", "member_name" : "포세이돈", "board_views" : "0"}
  		,{"board_no" : 256, "board_title" : "asdfasdf", "comments" : "2", "board_date" : "2021-03-17", "member_name" : "포세이돈", "board_views" : "0"}
  		,{"board_no" : 255, "board_title" : "오늘 할일", "comments" : "0", "board_date" : "2021-03-17", "member_name" : "포세이돈", "board_views" : "0"}
  		,{"board_no" : 253, "board_title" : "100개 만들기 프로젝트", "comments" : "0", "board_date" : "2021-01-29", "member_name" : "관리자2", "board_views" : "0"}
  		]
  }
  
 
 */














