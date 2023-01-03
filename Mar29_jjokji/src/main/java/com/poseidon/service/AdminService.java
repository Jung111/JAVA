package com.poseidon.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.dao.AdminDAO;
import com.poseidon.util.MapRemove;

@Service
public class AdminService {

	@Autowired
	private AdminDAO adminDAO;

	@Autowired
	private MapRemove mapRemove;

	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String, Object>> logList(Map<String, Object> map) {
		// 여기서 맵을 정리합니다.
		// map = (Map<String, Object>) mapRemove.remove(map);
		map.putAll((Map<? extends String, ? extends Object>) mapRemove.remove(map));
		System.out.println("맵 정리 후 : " + map);
		return (ArrayList<HashMap<String, Object>>) adminDAO.logList(map);
	}

	public int logListCount() {
		return adminDAO.logListCount();
	}

	public ArrayList<HashMap<String, Object>> select01() {
		return (ArrayList<HashMap<String, Object>>) adminDAO.select01();
	}

	public ArrayList<HashMap<String, Object>> tonggye() {
	
		return (ArrayList<HashMap<String, Object>>)adminDAO.tonggye();
	}

}
