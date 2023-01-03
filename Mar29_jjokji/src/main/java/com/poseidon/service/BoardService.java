package com.poseidon.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.dao.BoardDAO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	public ArrayList<HashMap<String, Object>> list(Map<String, Object> map) {
		return (ArrayList<HashMap<String, Object>>) boardDAO.list(map);
	}

	public ArrayList<HashMap<String, Object>> boardList(Map<String, Object> map) {
		return (ArrayList<HashMap<String, Object>>) boardDAO.boardList(map);
	}

	public int boardListCount() {
		return boardDAO.boardListCount();
	}

	public int jjokjiCount(Object attribute) {
		return boardDAO.jjokjiCount((Integer)attribute);
	}

	public void logWrite(HashMap<String, Object> log) {
		boardDAO.logWrite();
		
	}
}
