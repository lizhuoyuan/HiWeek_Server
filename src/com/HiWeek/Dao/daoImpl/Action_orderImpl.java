package com.HiWeek.Dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.HiWeek.Bean.Action_order;
import com.HiWeek.Dao.daoHelper.ActionDaoHelper;
import com.HiWeek.Dao.daoHelper.UserDaoHelper;
import com.HiWeek.Dao.daoInterface.Action_orderDao;
import com.HiWeek.Utils.DBConn;
import com.mysql.jdbc.Statement;

public class Action_orderImpl implements Action_orderDao {

    @Override
    public int insertAction_orderDao(Action_order action_order) {
	String sql = "insert into action_order(u_id,a_id,ao_price,ao_count,ao_date,ao_credit) values(?,?,?,?,?,?)";
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	int key = 0;
	ResultSet keys = null;
	try {
	    ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

	    ps.setInt(1, action_order.getUser().getU_id());
	    ps.setInt(2, action_order.getAction().getA_id());
	    ps.setDouble(3, action_order.getAo_price());
	    ps.setInt(4, action_order.getAo_count());
	    ps.setString(5, action_order.getAo_date());
	    ps.setInt(6, action_order.getAo_credit());
	    int i = ps.executeUpdate();
	    if (i > 0) {
		keys = ps.getGeneratedKeys();
		while (keys.next()) {
		    key = keys.getInt(1);
		}
		return key;
	    } else {
		return 0;
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    dbConn.CloseConn(keys, ps, conn);
	}
	return -1;
    }

    @Override
    public int deleteAction_orderDao(int ao_id) {
	String sql = "delete from action_order where ao_id=?";
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
	    ps = conn.prepareStatement(sql);
	    ps.setInt(1, ao_id);
	    int i = ps.executeUpdate();
	    if (i > 0) {
		return i;
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
    public ArrayList<Action_order> selectAction_order(String sqlstr) {
	String sql = "select * from action_order " + sqlstr;
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ArrayList<Action_order> Action_orderlist = new ArrayList<Action_order>();
	try {
	    ps = conn.prepareStatement(sql);
	    rs = ps.executeQuery();
	    Action_order action_order;
	    while (rs.next()) {
		action_order = new Action_order();
		action_order.setAo_id(rs.getInt("ao_id"));
		action_order.setAction(new ActionDaoHelper()
			.selectActionByID(rs.getInt("a_id") + ""));
		action_order.setAo_count(rs.getInt("ao_count"));
		action_order.setAo_date(rs.getString("ao_date"));
		action_order.setAo_price(rs.getDouble("ao_price"));
		action_order.setAo_state(rs.getInt("ao_state"));
		action_order.setAo_credit(rs.getInt("ao_credit"));
		action_order.setUser(new UserDaoHelper().selectUserByID(rs
			.getInt("u_id")));
		Action_orderlist.add(action_order);
	    }
	    return Action_orderlist;
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    dbConn.CloseConn(rs, ps, conn);
	}
	return null;
    }

    @Override
    public int updateAction_orderState(int ao_id) {
	String sql = "update action_order set ao_state=3 where ao_id=?";
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	try {
	    ps = conn.prepareStatement(sql);
	    ps.setInt(1, ao_id);
	    int i = ps.executeUpdate();
	    if (i > 0) {
		return ao_id;
	    } else {
		return 0;
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    dbConn.CloseConn(ps, conn);
	}
	return -1;
    }

}
