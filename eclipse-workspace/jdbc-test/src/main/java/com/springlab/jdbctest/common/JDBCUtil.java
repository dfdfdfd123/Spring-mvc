package com.springlab.jdbctest.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {

	public static Connection getConnection()
	{
		try {
		Class.forName("org.h2.Driver");
		DriverManager.getConnection (
				"jdbc:h2:tcp://localhost/~/test", 
				"sa", "");
		} catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(PreparedStatement stmt, Connection conn)
	{
		if (stmt != null)
		{
			try {
				if(!stmt.isClosed()) stmt.close();
				
			} catch (SQLException e)
			{
				e.printStackTrace();
			} finally 
			{
				stmt = null;
			}
		}
		if(conn != null)
		{
			try {
				if(!conn.isClosed()) conn.close();
				
			} catch (SQLException e)
			{
				e.printStackTrace();
			} finally 
			{
				conn = null;
			}
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn)
	{
		if (rs != null)
		{
			try {
					if (!rs.isClosed()) rs.close();
				} catch (SQLException e){
					e.printStackTrace();
				} finally {
					rs = null;
				}
		}
		if (stmt != null)
		{
			try {
					if (!stmt.isClosed()) stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					stmt = null;
				}
		}
		if (conn != null)
		{
			try {
					if (!conn.isClosed()) conn.close();
				} catch (SQLException e){
					e.printStackTrace(); 
					} finally  {
					conn = null;
				}
		}
	}
	
	
}
