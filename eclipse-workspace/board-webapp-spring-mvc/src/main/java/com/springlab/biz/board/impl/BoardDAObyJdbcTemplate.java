package com.springlab.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springlab.biz.board.BoardDAO;
import com.springlab.biz.board.BoardVO;

@Repository("boardDAObyJdbcTemplate")
public class BoardDAObyJdbcTemplate implements BoardDAO {

	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values ((select nvl(max(seq), 0)+1 from board), ?, ?, ?)";
	private final String BOARD_UPDATE = "update board set title=?, content=?, cnt=? where seq = ?";
	private final String BOARD_DELETE = "delete board where seq = ?";
	private final String BOARD_GET = "select * from board where seq = ?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	@Autowired
	private RowMapper<BoardVO> boardRowMapper;
	
	private JdbcTemplate jdbcTemplate;
	
	public BoardDAObyJdbcTemplate() {
	} 

	@Autowired
	public BoardDAObyJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	} 
	
	@Override
	public void insertBoard(BoardVO vo) {
		System.out.println("Execute insertBoard() in DAO using Spring JDBC...");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
//		try {
//			jdbcTemplate.update("insert into board(seq, title, writer, content) values (?, ?, ?, ?)", 
//					vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
//		} catch(DataAccessException ex) {
//			
//		}
	}

	@Override
	public void updateBoard(BoardVO vo) {
		System.out.println("Execute updateBoard() in DAO using Spring JDBC...");
		Object[] args = { vo.getTitle(), vo.getContent(), vo.getCnt(), vo.getSeq() };
		jdbcTemplate.update(BOARD_UPDATE, args);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		System.out.println("Execute deleteBoard() in DAO using Spring JDBC...");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("Execute getBoard() in DAO using Spring JDBC...");
//		Object[] args = {  vo.getSeq() };
//		return (BoardVO) this.getJdbcTemplate().queryForObject(BOARD_GET, args, boardRowMapper);
		return (BoardVO) jdbcTemplate.queryForObject(BOARD_GET, boardRowMapper, vo.getSeq());
	}

	@Override
	public List<BoardVO> listBoard() {
		System.out.println("Execute listBoard() in DAO using Spring JDBC...");
		return (List<BoardVO>) jdbcTemplate.query(BOARD_LIST, boardRowMapper);
	}

}
