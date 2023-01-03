package com.poseidon.web;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.service.AdminService;
import com.poseidon.util.CommandMap;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping(value = "/admin/log")
	public ModelAndView list(CommandMap map, HttpServletRequest request) {
		System.out.println("정리 전 : " + map.getMap());
		// 빈 값으로 들어오면 지우기 {lip=172.30.1.26, search=, lcate=}
		// util --MapRemove --> remove(map)
		// service에서 처리할게욤.

		ModelAndView mv = new ModelAndView("log");
		PaginationInfo paginationInfo = new PaginationInfo();
		int pageNo = 1;
		int listScale = 20;
		int pageScale = 5;

		if (map.containsKey("pageNo")) {
			pageNo = Integer.parseInt((String) map.get("pageNo"));
		}

		paginationInfo.setCurrentPageNo(pageNo);
		paginationInfo.setRecordCountPerPage(listScale);
		paginationInfo.setPageSize(pageScale);

		int startPage = paginationInfo.getFirstRecordIndex();
		int lastPage = paginationInfo.getRecordCountPerPage();

		map.put("startPage", startPage);
		map.put("lastPage", lastPage);

		ArrayList<HashMap<String, Object>> logList = adminService.logList(map.getMap());

		// int totalList = adminService.logListCount();
		int totalList = 0;
		if (logList.size() > 0) {
			totalList = Integer.parseInt((logList.get(0).get("count").toString()));
		}

		paginationInfo.setTotalRecordCount(totalList);

		mv.addObject("pageNo", pageNo);
		mv.addObject("logList", logList);
		mv.addObject("totalList", totalList);
		mv.addObject("paginationInfo", paginationInfo);

		// select박스에 총 수 표시하기
		ArrayList<HashMap<String, Object>> select01 = adminService.select01();

		mv.addObject("select01", select01);

		return mv;
	}

	@GetMapping(value = "admin/tonggye")
	public ModelAndView tonggye() {
		ModelAndView mv = new ModelAndView("tonggye");
		ArrayList<HashMap<String, Object>> list = adminService.tonggye();
		mv.addObject("tonggye",list);
		return mv;
	}
}
