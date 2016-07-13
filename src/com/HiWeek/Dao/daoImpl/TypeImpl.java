package com.HiWeek.Dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.HiWeek.Bean.Type;
import com.HiWeek.Bean.User;
import com.HiWeek.Dao.daoInterface.TypeDao;
import com.HiWeek.Utils.DBConn;

public class TypeImpl implements TypeDao {

	@Override
	public int insertType(Type type) {
		// sql
		String sql = "insert into type(t_name,t_sign) values(?,?)";

		// 获取连接
		DBConn dbConn = DBConn.getInstance();
		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, type.getT_name());
			ps.setInt(2, type.getT_sign());

			int i = ps.executeUpdate();
			if (i > 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					type.setT_id(id);
					return id;
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
	public int deleteType(String sqlstr) {
		// sql
		String sql = "delete from type " + sqlstr;
		// 获取连接
		DBConn dbConn = DBConn.getInstance();
		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);

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
	public int updateType(Type type) {
		// sql
		String sql = "update type set t_name = ? ,t_sign = ? where t_id = ? ";
		// 获取连接
		DBConn dbConn = DBConn.getInstance();
		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(3, type.getT_id());
			ps.setString(1, type.getT_name());
			ps.setInt(2, type.getT_sign());

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
	public ArrayList<Type> selectTypes(String sqlstr) {
		// sql
		String sql = "select * from type " + sqlstr;
		// 获取连接
		DBConn dbConn = DBConn.getInstance();
		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Type> typelist = null;
		try {
			typelist = new ArrayList<>();
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				Type type = new Type(rs.getInt("t_id"), rs.getString("t_name"),
						rs.getInt("t_sign"));
				typelist.add(type);
			}
			return typelist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConn.CloseConn(rs, ps, conn);
		}
		return null;
	}

}
