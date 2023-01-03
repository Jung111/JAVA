package com.poseidon.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JjokjiDAO {

	@Autowired
	private SqlSession sqlSession;

	public List<HashMap<String, Object>> jjokjiList(String string) {
		return sqlSession.selectList("jjokji.list", string);
	}

	public HashMap<String, Object> detail(String string) {
		HashMap<String, Object> detail = sqlSession.selectOne("jjokji.readCheck", string);
		if (detail.get("suchk").toString().equals("N")) {
			return sqlSession.selectOne("jjokji.detail", string);
		}
		return detail;
	}

	public void delete(String string) {
		sqlSession.delete("jjokji.delete", string);
	}

	public void sendMsg(HashMap<String, Object> map2) {
		sqlSession.insert("jjokji.sendMsg",map2);
		
	}

}
