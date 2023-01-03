package com.poseidon.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poseidon.dto.LoginDTO;

@Repository
public class LoginDAO {

	@Autowired
	private SqlSession sqlSession;

	public LoginDTO login(LoginDTO dto) {
		return sqlSession.selectOne("login.login", dto);
	}

	public int jjokjiCount(Integer attribute) {
		return sqlSession.selectOne("login.jjokjiCount", attribute);
	}

	public void logWrite(HashMap<String, Object> log) {

		sqlSession.insert("board.logWrite", log);

	}

}
