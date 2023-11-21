package com.springlab.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Repository;

import com.springlab.biz.board.BoardDAO;
import com.springlab.biz.board.BoardVO;
import com.springlab.biz.common.JDBCUtil;

@Repository("boardDAO")
public class BoardSpringJdbcDAO implements BoardDAO {

	
	// private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values ((select nvl(max(seq), 0)+1 from board), ?, ?, ?)";
	
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values (?,?, ?, ?)";
	private final String BOARD_UPDATE = "update board set title=?, content=?, cnt=? where seq = ?";
	private final String BOARD_DELETE = "delete board where seq = ?";
	private final String BOARD_GET = "select * from board where seq = ?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	@Autowired
	@Qualifier("jdbcTemplate")
	JdbcTemplate jdbcTemplate;
	

	@Override
	public void insertBoard(BoardVO vo) {
		System.out.println(">>> insert a record into BOARD by JDBC...");
		
		jdbcTemplate.update(Board_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
		
		
		
	}
	
	@Override
	public void updateBoard(BoardVO vo) {
		System.out.println(">>> update a record on BOARD by JDBC...");
		jdbcTemplate.update(Board_UPDATE, 
				vo.getTitle(),vo.getWriter(),vo.getCnt(), vo.getSeq());
		
	}
	
	@Override
	public void deleteBoard(BoardVO vo) {
		System.out.println(">>> delete a record from BOARD by JDBC...");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	
	@Override
	public BoardVO getBoard(BoardVO vo) {
		System.out.println(">>> get a record from BOARD by JDBC...");
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			if (rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return board;
	}
	
	
	@Override
	public List<BoardVO> listBoard() {
		System.out.println(">>> get record list from BOARD by JDBC...");
		List<BoardVO> list = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			if (rs.isBeforeFirst()) {
				list = new ArrayList<BoardVO>();
				while (rs.next()) {
					BoardVO board = new BoardVO();
					board.setSeq(rs.getInt("SEQ"));
					board.setTitle(rs.getString("TITLE"));
					board.setWriter(rs.getString("WRITER"));
					board.setContent(rs.getString("CONTENT"));
					board.setRegDate(rs.getDate("REGDATE"));
					board.setCnt(rs.getInt("CNT"));
					list.add(board);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return list;
	}
}
