package com.springlab.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springlab.biz.common.JDBCUtil;
import com.springlab.biz.user.UserDAO;
import com.springlab.biz.user.UserVO;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String USER_INSERT = "insert into users(id, password, name, role) values (?, ?, ?, ?)";
	private final String USER_UPDATE = "update users set password = ?, name = ?, role = ? where id = ?";
	private final String USER_DELETE = "delete users where id = ?";
	private final String USER_GET = "select * from users where id = ?";
	private final String USER_LIST = "select * from users order by id asc";

	@Override
	public void insertUser(UserVO user) {
		System.out.println(">>> insert a record into USERS by JDBC...");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, user.getId());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getRole());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	@Override
	public void updateUser(UserVO user) {
		System.out.println(">>> update a record on USERS by JDBC...");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getRole());
			stmt.setString(4, user.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	@Override
	public void deleteUser(UserVO user) {
		System.out.println(">>> delete a record on USERS by JDBC...");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_DELETE);
			stmt.setString(1, user.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	@Override
	public UserVO getUser(UserVO user) {
		System.out.println(">>> get a record from USERS by JDBC...");
		UserVO vo = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, user.getId());
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo = new UserVO();
				vo.setId(rs.getString("ID"));
				vo.setPassword(rs.getString("PASSWORD"));
				vo.setName(rs.getString("NAME"));
				vo.setRole(rs.getString("ROLE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return vo;
	}

	@Override
	public List<UserVO> listUser() {
		System.out.println(">>> get record list from USERS by JDBC...");
		List<UserVO> list = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();
			if (rs.isBeforeFirst()) {
				list = new ArrayList<UserVO>();
				while (rs.next()) {
					UserVO user = new UserVO();
					user.setId(rs.getString("ID"));
					user.setPassword(rs.getString("PASSWORD"));
					user.setName(rs.getString("NAME"));
					user.setRole(rs.getString("ROLE"));
					list.add(user);
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
