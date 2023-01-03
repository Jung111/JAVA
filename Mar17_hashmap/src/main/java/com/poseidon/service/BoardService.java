package com.poseidon.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.dao.BoardDAO;
import com.poseidon.dto.BoardDTO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	public ArrayList<BoardDTO> list() {
		return (ArrayList<BoardDTO>)boardDAO.list();
	}

	public ArrayList<HashMap<String, Object>> listh() {
		return (ArrayList<HashMap<String, Object>>)boardDAO.listh();
	}

	public BoardDTO detail(int no) {
		return boardDAO.detail(no);
	}

	public BoardDTO detail(BoardDTO dto) {
		
		return boardDAO.detail(dto);
	}
	
	public void write(BoardDTO dto) {
	  boardDAO.write(dto);
		
	}

	public void write2(Map<String, Object> map) {
		boardDAO.write2(map);
		
	}

	

}
