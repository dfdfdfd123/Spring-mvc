package com.example.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.biz.common.JDBCUtil;

//@Repository("boardJdbcDAO")
public class BoardJdbcDAO implements BoardDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private final String BOARD_INSERT = "insert into BOARD(seq, title, writer, content) " + 
										"values((select nvl(max(seq), 0)+1 from BOARD),?,?,?)";
	private final String BOARD_UPDATE = "update BOARD set title=?, content=?, cnt=? where seq=?";
	private final String BOARD_DELETE = "delete BOARD where seq=?";
	private final String BOARD_GET = "select * from BOARD where seq=?";
	private final String BOARD_LIST = "select * from BOARD order by seq desc";
	
	public void insertBoard(BoardDO board) {
		System.out.println(">>> Execute insertBaord() by JDBC");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1,  board.getTitle());
			stmt.setString(2,  board.getWriter());
			stmt.setString(3,  board.getContent());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void updateBoard(BoardDO board) {
		System.out.println(">>> Execute updateBaord() by JDBC");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1,  board.getTitle());
			stmt.setString(2,  board.getContent());
			stmt.setInt(3,  board.getCnt());
			stmt.setInt(4,  board.getSeq());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void deleteBoard(BoardDO board) {
		System.out.println(">>> Execute deleteBaord() by JDBC");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1,  board.getSeq());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public BoardDO getBoard(BoardDO board) {
		System.out.println(">>> Execute getBaord() by JDBC");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1,  board.getSeq());
			rs = stmt.executeQuery();
			if (rs.next()) {
				board = new BoardDO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
			else board = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return board;
	}
	
	public List<BoardDO> listBoard() {
		System.out.println(">>> Execute listBaord() by JDBC");
		
		ArrayList<BoardDO> list = null;
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			if (rs.isBeforeFirst()) {
				list = new ArrayList<BoardDO>();
				while (rs.next()) {
					BoardDO board = new BoardDO();
					board.setSeq(rs.getInt("seq"));
					board.setTitle(rs.getString("title"));
					board.setWriter(rs.getString("writer"));
					board.setContent(rs.getString("content"));
					board.setRegDate(rs.getDate("regdate"));
					board.setCnt(rs.getInt("cnt"));
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

	@Override
	public List<BoardDO> searchBoard(BoardSearchDO searchDO) {
		// TODO Auto-generated method stub
		return null;
	}

}
