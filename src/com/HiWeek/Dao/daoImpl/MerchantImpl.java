package com.HiWeek.Dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.HiWeek.Bean.Merchant;
import com.HiWeek.Dao.daoInterface.MerchantDao;
import com.HiWeek.Utils.DBConn;

/**
 * 商家dao层的实现
 * 
 * @author XU
 * 
 */
public class MerchantImpl implements MerchantDao {

	@Override
	public int deleteMerchant(String sqlstr) {
		// sql
		String sql = "delete from merchant " + sqlstr;
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
	public ArrayList<Merchant> selectMerchants(String sqlstr) {
		// sql
		String sql = "select * from merchant " + sqlstr;
		// 获取连接
		DBConn dbConn = DBConn.getInstance();
		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Merchant> merchantlist = null;
		try {
			merchantlist = new ArrayList<>();
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				// int mer_id, String mer_name, String mer_tel, String
				// mer_password
				Merchant merchant = new Merchant(rs.getInt("mer_id"),
						rs.getString("mer_name"), rs.getString("mer_tel"),
						rs.getString("mer_password"));
				// 每个字段进行判断，为空则不赋值
				// mer_address mer_introduce
				String mer_address = rs.getString("mer_address");
				String mer_introduce = rs.getString("mer_introduce");
				if (!"".equals(mer_address)) {
					merchant.setMer_address(mer_address);

				}
				if (!"".equals(mer_introduce)) {
					merchant.setMer_introduce(mer_introduce);
				}
				merchantlist.add(merchant);
			}
			return merchantlist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConn.CloseConn(rs, ps, conn);
		}
		return null;
	}

	@Override
	public int insertMerchant(String sqlstr) {
		// sql
		String sql = "insert into merchant " + sqlstr;
		System.out.println(sql);
		// 获取连接
		DBConn dbConn = DBConn.getInstance();
		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);

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
	public int updateMerchant(String sqlstr) {
		// sql
		String sql = "update merchant set " + sqlstr;
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

}
