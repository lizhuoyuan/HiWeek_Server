package com.HiWeek.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoUtils {
	private static DaoUtils daoUtils = null;

	public DaoUtils() {

	}

	public static DaoUtils getInstance() {
		if (daoUtils == null) {
			daoUtils = new DaoUtils();
		}
		return daoUtils;
	}

	public int insert(String tbName, String sqlstr) {
		// sql
		String sql = "insert into ? ? ";

		// 获取连接
		DBConn dbConn = DBConn.getInstance();
		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, tbName);
			ps.setString(2, sqlstr);
			int i = ps.executeUpdate();
			if (i > 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next()) {
					return rs.getInt(1);
				}
			} else {
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} finally {
			dbConn.CloseConn(rs, ps, conn);
		}
		return -1;
	}

	public int delete(String tbName, String sqlstr) {
		// sql
		String sql = "delete from ? ? ";
		// 获取连接
		DBConn dbConn = DBConn.getInstance();
		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, tbName);
			ps.setString(2, sqlstr);

			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConn.CloseConn(ps, conn);
		}
		return -1;
	}

	public int update(String tbName, String sqlstr) {
		// sql
		String sql = "update ? ? ";
		// 获取连接
		DBConn dbConn = DBConn.getInstance();
		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, tbName);
			ps.setString(2, sqlstr);

			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConn.CloseConn(ps, conn);
		}
		return -1;
	}
}
