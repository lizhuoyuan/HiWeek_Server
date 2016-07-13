package com.HiWeek.Dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.HiWeek.Bean.Collect;
import com.HiWeek.Dao.daoInterface.CollectDao;
import com.HiWeek.Utils.DBConn;

/**
 * @author 李卓原 创建时间：2015-10-27 下午7:09:18
 * 
 */
public class CollectImpl implements CollectDao {

	@Override
	public int deleteCollect(int a_id, int u_id) {
		// sql
		String sql = "delete from collect where a_id = ? and u_id=?";
		// 获取连接
		DBConn dbConn = DBConn.getInstance();
		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, a_id);
			ps.setInt(2, u_id);
			System.out.println(sql);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConn.CloseConn(ps, conn);
		}
		return -1;
	}

	@Override
	public int insertCollect(int a_id, String ce_time, String a_itemname,
			int u_id) {
		// sql
		String sql = "insert into collect (a_id,ce_time,a_itemname,u_id) values(?,?,?,?)";
		System.out.println(sql);
		// 获取连接
		DBConn dbConn = DBConn.getInstance();
		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, a_id);
			ps.setString(2, ce_time);
			ps.setString(3, a_itemname);
			ps.setInt(4, u_id);
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

	@Override
	public ArrayList<Collect> findCollect(int u_id) {
		// sql
		String sql = "select * from collect where u_id=?";

		// 获取连接
		DBConn dbConn = DBConn.getInstance();
		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Collect> collects = new ArrayList<Collect>();
		try {
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, u_id);
			rs = ps.executeQuery();
			System.out.println(sql);
			while (rs.next()) {
				int ce_id = rs.getInt("ce_id");
				int a_id = rs.getInt("a_id");
				String a_itemname = rs.getString("a_itemname");
				String ce_time = rs.getString("ce_time");
				Collect collect = new Collect(ce_id, a_id, ce_time, a_itemname,
						u_id);
				collects.add(collect);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return collects;
	}

	@Override
	public int FindCollect(int u_id, int a_id) {
		String sql = "select * from collect where u_id=? and a_id = ?";
		// 获取连接
		DBConn dbConn = DBConn.getInstance();
		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u_id);
			ps.setInt(2, a_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return 1;
			} else {
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
