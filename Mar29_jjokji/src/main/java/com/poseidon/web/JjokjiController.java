package com.poseidon.web;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.dto.BoardDTO;
import com.poseidon.service.JjokjiService;

@Controller
public class JjokjiController {
	@Autowired
	private JjokjiService jjokjiService;

	@RequestMapping(value = "/jjokji", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView jjokji(@RequestParam HashMap<String, Object> map2, HttpServletRequest request) {
		System.out.println(map2);

		ModelAndView mv = new ModelAndView("jjokji");
		HttpSession session = request.getSession();
		if (session.getAttribute("no") != null && session.getAttribute("name") != null) {
			if (!map2.containsKey("key") || map2.get("key").equals("list")) {
				ArrayList<HashMap<String, Object>> list = jjokjiService.jjokjiList(session.getAttribute("no").toString());
				mv.addObject("list", list);
				//mv.addObject("key", map2.get("list"));

			} else if (map2.get("key").equals("write")) {
				mv.addObject("no", map2.get("no"));
				//mv.addObject("key", map2.get("write"));
					
			} else if (map2.get("key").equals("sendMsg")) {
				map2.put("songmno", session.getAttribute("no"));
				map2.put("sumno",map2.get("no"));
				jjokjiService.sendMsg(map2);
				mv.setViewName("redirect:/jjokji?key=list");

			} else if (map2.get("key").equals("detail")) {
				HashMap<String, Object> detail = jjokjiService.detail(map2.get("no").toString());
				mv.addObject("detail", detail);
				//mv.addObject("key", map2.get("key"));

			} else if (map2.get("key").equals("delete")) {
				jjokjiService.delete(map2.get("no").toString());
				mv.setViewName("redirect:/jjokji?key=list");
			}
		}
		return mv;
	}
}