package com.springlab.jdbctest.board;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.springlab.jdbctest.common.JDBCUtil;

@Repository("boardJdbcDAO")
public class BoardJdbcDAO implements BoardDAO {
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String BOARD_INSERT = 
			"insert into BOARD(SEQ, TITLE, WRITER, CONTENT) "
			+ "values((select nvl(max(seq), 0)+1 from board), ?, ?, ?)";
	private final String BOARD_UPDATE = 
			"update BOARD set TITLE=?, CONTENT=?, CNT=? where SEQ=?";
	private final String BOARD_DELETE = 
			"delete BOARD set TITLE=?, CONTENT=? where SEQ=?";
	private final String BOARD_GET = 
			"select * from BOARD where SEQ=?";
	private final String BOARD_LIST = 
			"select * from BOARD order by SEQ desc";




	@Override
	public void insertBoard(BoardDO board) {
		System.out.println(">>> execute insertBoard() using JDBC");
	
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setNString(1, board.getTitle());
			stmt.setNString(2, board.getWriter());
			stmt.setNString(3, board.getContent());
			stmt.executeUpdate();
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}

	}

	@Override
	public void updateBoard(BoardDO board) {
		System.out.println(">>> execute updateBoard() using JDBC");
		
		try {
		conn = JDBCUtil.getConnection();
		
		stmt = conn.prepareStatement(BOARD_UPDATE);
		stmt.setNString(1, board.getTitle());
		stmt.setNString(2, board.getWriter());
		stmt.setInt(3, board.getCnt());
		stmt.setInt(4, board.getSeq());
		
		
		stmt.executeUpdate();
		
		
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}

	}

	@Override
	public void deleteBoard(BoardDO board) {
		System.out.println(">>> execute deleteBoard() using JDBC");
		
		try {
		conn = JDBCUtil.getConnection();
		stmt = conn.prepareStatement(BOARD_DELETE);
		stmt.setInt(1, board.getSeq());
		
		
		stmt.executeUpdate();
		
		
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}

	}

	@Override
	public BoardDO getBoard(BoardDO board) {
		System.out.println(">>> execute getBoard() using JDBC");
		
		try {
		conn = JDBCUtil.getConnection();
		stmt = conn.prepareStatement(BOARD_GET);
		stmt.setInt(1, board.getSeq());
		
		
		rs = stmt.executeQuery();
		if (rs.next())
		{
			board = new BoardDO();
			board.setSeq(rs.getInt("SEQ"));
			board.setTitle(rs.getString("TITLE"));
			board.setWriter(rs.getString("WRITER"));
			board.setContent(rs.getString("CONTENT"));
			board.setRegDate(rs.getDate("REGDATE"));
			board.setCnt(rs.getInt("CNT"));
			
		}else {
			board = null;
		}
		
		
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
		return board;
	}

	@Override
	public List<BoardDO> listBoard() {
		System.out.println(">>> execute listBoard() using JDBC");
		
		List<BoardDO> list = null;
		
		try {
		conn = JDBCUtil.getConnection();
		
		stmt = conn.prepareStatement(BOARD_LIST);
		
		rs = stmt.executeQuery();
		
		if(rs.isBeforeFirst()) {
			list = new ArrayList<BoardDO>();
		
		while (rs.next())
		{
			BoardDO board = new BoardDO();
			board.setSeq(rs.getInt("SEQ"));
			board.setTitle(rs.getString("TITLE"));
			board.setWriter(rs.getString("WRITER"));
			board.setContent(rs.getString("CONTENT"));
			board.setRegDate(rs.getDate("REGDATE"));
			board.setCnt(rs.getInt("CNT"));
			
			list.add(board);
			
		}
		
		}
		
		
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
		return list;
	}

}
