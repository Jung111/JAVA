package com.poseidon.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.dao.JjokjiDAO;

@Service
public class JjokjiService {

	@Autowired
	private JjokjiDAO jjokjiDAO;
	
	public ArrayList<HashMap<String, Object>> jjokjiList(String string) {
		return (ArrayList<HashMap<String, Object>>) jjokjiDAO.jjokjiList(string);
	}

	public HashMap<String, Object> detail(String string) {
	
		return jjokjiDAO.detail(string);
	}

	public void delete(String string) {
		jjokjiDAO.delete(string);
	}

	public void sendMsg(HashMap<String, Object> map2) {
		jjokjiDAO.sendMsg(map2);
		
	}


}
