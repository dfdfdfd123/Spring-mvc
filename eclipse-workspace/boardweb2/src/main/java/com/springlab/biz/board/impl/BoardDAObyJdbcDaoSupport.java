package com.springlab.biz.board.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springlab.biz.board.BoardDAO;
import com.springlab.biz.board.BoardVO;

@Repository("boardDAObyJdbcDaoSupport")
public class BoardDAObyJdbcDaoSupport extends JdbcDaoSupport implements BoardDAO {

	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values ((select nvl(max(seq), 0)+1 from board), ?, ?, ?)";
	private final String BOARD_UPDATE = "update board set title=?, content=?, cnt=? where seq = ?";
	private final String BOARD_DELETE = "delete board where seq = ?";
	private final String BOARD_GET = "select * from board where seq = ?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	@Autowired
	private RowMapper<BoardVO> boardRowMapper;
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public void insertBoard(BoardVO vo) {
		System.out.println("Execute insertBoard() in DAO using Spring JDBC...");
		this.getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	@Override
	public void updateBoard(BoardVO vo) {
		System.out.println("Execute updateBoard() in DAO using Spring JDBC...");
		Object[] args = { vo.getTitle(), vo.getContent(), vo.getCnt(), vo.getSeq() };
		this.getJdbcTemplate().update(BOARD_UPDATE, args);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		System.out.println("Execute deleteBoard() in DAO using Spring JDBC...");
		this.getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("Execute getBoard() in DAO using Spring JDBC...");
		return (BoardVO) this.getJdbcTemplate().queryForObject(BOARD_GET, boardRowMapper, vo.getSeq());
	}

	@Override
	public List<BoardVO> listBoard() {
		System.out.println("Execute listBoard() in DAO using Spring JDBC...");
		return (List<BoardVO>) this.getJdbcTemplate().query(BOARD_LIST, boardRowMapper);
	}

}
