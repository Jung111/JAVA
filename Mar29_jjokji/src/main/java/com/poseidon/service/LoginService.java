package com.poseidon.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.dao.LoginDAO;
import com.poseidon.dto.LoginDTO;

@Service
public class LoginService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	public LoginDTO login(LoginDTO dto) {
		return loginDAO.login(dto);
	}

	public int jjokjiCount(Object attribute) {
		return loginDAO.jjokjiCount((Integer)attribute);
	}


	public void logWrite(HashMap<String, Object> log) {
	 loginDAO.logWrite(log);
		
	}

	
}
