package com.HiWeek.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConn {
	private static DBConn dbConn;
	private String driverName;
	private String url;
	private String name;
	private String pwd;

	public static DBConn getInstance() {
		if (dbConn == null) {
			dbConn = new DBConn();
		}
		return dbConn;
	}

	public DBConn() {
		Properties properties = new Properties();

		InputStream is = DBConn.class.getResourceAsStream("/db.properties");

		try {
			properties.load(is);

			driverName = properties.getProperty("driver");
			url = properties.getProperty("url");
			name = properties.getProperty("userName");
			pwd = properties.getProperty("password");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return 获取的Connection
	 */
	public Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName(driverName);

			conn = DriverManager.getConnection(url, name, pwd);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * 
	 */
	public void CloseConn(ResultSet rs, Statement state, Connection conn) {
		try {

			if (rs != null && !rs.isClosed()) {
				rs.close();
				rs = null;
			}
			if (state != null && !state.isClosed()) {
				state.close();
				state = null;
			}
			if (conn != null && !conn.isClosed()) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {

		}
	}

	public void CloseConn(Statement state, Connection conn) {
		CloseConn(null, state, conn);
	}

//	public static void main(String[] args) {
//		Connection conn = DBConn.getInstance().getConnection();
//		ResultSet rs;
//		try {
//			rs = conn.prepareStatement("select * from user").executeQuery();
//			while(rs.next()){
//				System.out.println("u_sex:"+"".equals(rs.getString("u_sex"))+":");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
