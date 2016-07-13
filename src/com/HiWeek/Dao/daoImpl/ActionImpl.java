package com.HiWeek.Dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.HiWeek.Bean.Action;
import com.HiWeek.Bean.Merchant;
import com.HiWeek.Bean.Type;
import com.HiWeek.Dao.daoHelper.MerchantDaoHelper;
import com.HiWeek.Dao.daoHelper.TypeDaoHelper;
import com.HiWeek.Dao.daoInterface.ActionDao;
import com.HiWeek.Utils.DBConn;

/**
 * 长知识Dao实现
 *
 * @author XU
 *
 */
public class ActionImpl implements ActionDao {
    private MerchantDaoHelper mDaoHelper;
    private TypeDaoHelper tDaoHelper;

    public ActionImpl() {
	mDaoHelper = new MerchantDaoHelper();
	tDaoHelper = new TypeDaoHelper();
    }

    @Override
    public int deleteAction(String sqlstr) {
	// sql
	String sql = "delete from action " + sqlstr;
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
    public ArrayList<Action> selectActions(String sqlstr) {
	// sql
	String sql = "select * from action " + sqlstr;
	// 获取连接
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ArrayList<Action> actionlist = null;
	try {
	    actionlist = new ArrayList<>();
	    ps = conn.prepareStatement(sql);

	    rs = ps.executeQuery();
	    while (rs.next()) {
		Integer a_id = rs.getInt("a_id");
		String a_itemname = rs.getString("a_itemname");
		Double a_price = rs.getDouble("a_price");
		String a_introduce = rs.getString("a_introduce");
		String a_consult = rs.getString("a_consult");
		String a_charge = rs.getString("a_charge");
		String a_stime = rs.getString("a_stime");
		String a_etime = rs.getString("a_etime");
		String a_address = rs.getString("a_address");
		String a_FAQ = rs.getString("a_FAQ");
		String a_joinex = rs.getString("a_joinex");
		String a_photo = rs.getString("a_photo");
		Integer mer_id = rs.getInt("mer_id");
		Integer t_id = rs.getInt("t_id");
		double a_lat = rs.getDouble("a_lat");
		double a_lon = rs.getDouble("a_lon");
		Action actions = new Action(a_id, a_itemname, a_price,
			a_introduce, a_consult, a_FAQ, a_joinex, a_charge,
			a_stime, a_etime, a_address, a_photo, mer_id, t_id,
			a_lat, a_lon);
		actionlist.add(actions);
	    }
	    return actionlist;
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    dbConn.CloseConn(rs, ps, conn);
	}
	return null;
    }

    @Override
    public int insertAction(String sqlstr) {
	// sql
	String sql = "insert into action" + sqlstr;
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
    public int updateAction(String sqlstr) {
	// sql
	String sql = "update action " + sqlstr;
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
    public ArrayList<Action> findAction(String sqlstr) {
	// sql
	String sql = "select * from action";
	System.out.println(sql);
	// 获取连接
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ArrayList<Action> actionlist = new ArrayList<Action>();
	try {
	    ps = conn.prepareStatement(sql);

	    rs = ps.executeQuery();
	    while (rs.next()) {
		// Integer a_id, String a_itemname, String a_price,
		// String a_introduce, String a_consult, String a_charge,
		// String a_stime, String a_etime, String a_address,
		// Merchant merchant, Type type
		Integer a_id = rs.getInt("a_id");
		String a_itemname = rs.getString("a_itemname");
		Double a_price = rs.getDouble("a_price");
		String a_introduce = rs.getString("a_introduce");
		String a_consult = rs.getString("a_consult");
		String a_charge = rs.getString("a_charge");
		String a_stime = rs.getString("a_stime");
		String a_etime = rs.getString("a_etime");
		String a_address = rs.getString("a_address");
		String a_FAQ = rs.getString("a_FAQ");
		String a_joinex = rs.getString("a_joinex");
		String a_photo = rs.getString("a_photo");
		Integer mer_id = rs.getInt("mer_id");
		Integer t_id = rs.getInt("t_id");
		double a_lat = rs.getDouble("a_lat");
		double a_lon = rs.getDouble("a_lon");
		Action actions = new Action(a_id, a_itemname, a_price,
			a_introduce, a_consult, a_FAQ, a_joinex, a_charge,
			a_stime, a_etime, a_address, a_photo, mer_id, t_id,
			a_lat, a_lon);
		actionlist.add(actions);
	    }

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return actionlist;
    }

    @Override
    public ArrayList<Action> search(String search) {
	// sql
	String sql = "select * from action where a_itemname like '%" + search
		+ "%' ";
	System.out.println(sql);
	// 获取连接
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ArrayList<Action> actionlist = new ArrayList<Action>();
	try {
	    ps = conn.prepareStatement(sql);
	    rs = ps.executeQuery();
	    while (rs.next()) {
		// Integer a_id, String a_itemname, String a_price,
		// String a_introduce, String a_consult, String a_charge,
		// String a_stime, String a_etime, String a_address,
		// Merchant merchant, Type type
		Integer a_id = rs.getInt("a_id");
		String a_itemname = rs.getString("a_itemname");
		Double a_price = rs.getDouble("a_price");
		String a_introduce = rs.getString("a_introduce");
		String a_consult = rs.getString("a_consult");
		String a_charge = rs.getString("a_charge");
		String a_stime = rs.getString("a_stime");
		String a_etime = rs.getString("a_etime");
		String a_address = rs.getString("a_address");
		String a_FAQ = rs.getString("a_FAQ");
		String a_joinex = rs.getString("a_joinex");
		String a_photo = rs.getString("a_photo");
		Integer mer_id = rs.getInt("mer_id");
		Integer t_id = rs.getInt("t_id");
		double a_lat = rs.getDouble("a_lat");
		double a_lon = rs.getDouble("a_lon");
		Action actions = new Action(a_id, a_itemname, a_price,
			a_introduce, a_consult, a_FAQ, a_joinex, a_charge,
			a_stime, a_etime, a_address, a_photo, mer_id, t_id,
			a_lat, a_lon);
		actionlist.add(actions);

	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return actionlist;
    }

}
