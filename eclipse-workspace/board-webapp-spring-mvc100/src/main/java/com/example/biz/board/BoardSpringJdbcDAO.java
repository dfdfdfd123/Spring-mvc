package com.example.biz.board;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

//@Repository
public class BoardSpringJdbcDAO extends JdbcDaoSupport implements BoardDAO {
	
	private final String BOARD_INSERT = "insert into BOARD(seq, title, writer, content) " + 
			"values((select nvl(max(seq), 0)+1 from BOARD),?,?,?)";
	private final String BOARD_UPDATE = "update BOARD set title=?, content=?, cnt=? where seq=?";
	private final String BOARD_DELETE = "delete BOARD where seq=?";
	private final String BOARD_GET = "select * from BOARD where seq=?";
	private final String BOARD_LIST = "select * from BOARD order by seq desc";

	@Autowired
	void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void insertBoard(BoardDO board) {
		System.out.println(">>> Execute insertBaord() by JdbcTemplate");
		getJdbcTemplate().update(BOARD_INSERT, 
			board.getTitle(), board.getWriter(), board.getContent());
	}

	@Override
	public void updateBoard(BoardDO board) {
		System.out.println(">>> Execute updateBoard() by JdbcTemplate");
		getJdbcTemplate().update(BOARD_UPDATE, 
			board.getTitle(), board.getWriter(), board.getCnt(), board.getSeq());
	}

	@Override
	public void deleteBoard(BoardDO board) {
		System.out.println(">>> Execute updateBoard() by JdbcTemplate");
		getJdbcTemplate().update(BOARD_DELETE, board.getSeq());
	}

	@Override
	public BoardDO getBoard(BoardDO board) {
		System.out.println(">>> Execute getBoard() by JdbcTemplate");
		return getJdbcTemplate().queryForObject(BOARD_GET, new BoardRowMapper(), board.getSeq());
	}

	@Override
	public List<BoardDO> listBoard() {
		System.out.println(">>> Execute listBoard() by JdbcTemplate");
		return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
	}

	@Override
	public List<BoardDO> searchBoard(BoardSearchDO searchDO) {
		// TODO Auto-generated method stub
		return null;
	}

}
