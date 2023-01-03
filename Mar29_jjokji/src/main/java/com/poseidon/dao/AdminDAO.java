package com.poseidon.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<HashMap<String, Object>> logList(Map<String, Object> map) {
		return sqlSession.selectList("log.logList", map);
	}

	public int logListCount() {
		return sqlSession.selectOne("log.logListCount");
	}

	public List<HashMap<String, Object>> select01() {
		return sqlSession.selectList("log.select01");
	}

	public List<HashMap<String, Object>> tonggye() {

		return sqlSession.selectList("log.tonggye");
	
	}

	
}
