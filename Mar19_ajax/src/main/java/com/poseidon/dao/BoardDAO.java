package com.poseidon.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poseidon.dto.BoardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardDTO> list(){
		return sqlSession.selectList("board.list");
	}

	public List<HashMap<String, Object>> listh() {
		return sqlSession.selectList("board.listh");
	}

	public BoardDTO detail(int no) {
		return sqlSession.selectOne("board.detail", no);
	}
	
	public BoardDTO detail(BoardDTO dto) {
		return sqlSession.selectOne("board.update", dto);
	}
	

	public void write(BoardDTO dto) {
		sqlSession.insert("board.write", dto);
	}

	public void write2(Map<String, Object> map) {
		sqlSession.insert("board.write2", map);
		
	}

	public void update(Map<String, Object> map) {
		sqlSession.update("board.update2", map);
	}

	public void delete(Map<String, Object> map) {
		sqlSession.delete("board.delete", map);
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, Object> comments(int no) {
		return (HashMap<String, Object>) sqlSession.selectList("board.comments",no);
	}


	
}
