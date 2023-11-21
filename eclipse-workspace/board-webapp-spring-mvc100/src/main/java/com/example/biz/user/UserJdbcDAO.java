package com.example.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.biz.common.JDBCUtil;

@Repository("userJdbcDAO")
public class UserJdbcDAO implements UserDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private final String USER_INSERT = "insert into USERS(id, password, name, role) values(?,?,?,?)";
	private final String USER_UPDATE = "update USERS set password=?, name=?, role=? where id=?";
	private final String USER_DELETE = "delete USERS where id=?";
	private final String USER_GET = "select * from USERS where id=?";
	private final String USER_LIST = "select * from USERS order by id asc";

	public void insertUser(UserDO user) {
		System.out.println(">>> Execute insertUser() by JDBC");
		
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

	public void updateUser(UserDO user) {
		System.out.println(">>> Execute updateUser() by JDBC");
		
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

	public void deleteUser(UserDO user) {
		System.out.println(">>> Execute deleteUser() by JDBC");
		
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

	public UserDO getUser(UserDO user) {
		System.out.println(">>> Execute getUser() by JDBC");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, user.getId());
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserDO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
			else user = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return user;
	}

	public List<UserDO> listUser() {
		System.out.println(">>> Execute getUser() by JDBC");
		
		List<UserDO> list = null;
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();
			if (rs.isBeforeFirst()) {
				list = new ArrayList<UserDO>();
				while (rs.next()) {
					UserDO user = new UserDO();
					user.setId(rs.getString("id"));
					user.setPassword(rs.getString("password"));
					user.setName(rs.getString("name"));
					user.setRole(rs.getString("role"));
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
