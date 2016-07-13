package com.HiWeek.Dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.HiWeek.Bean.User;
import com.HiWeek.Dao.daoInterface.UserDao;
import com.HiWeek.Utils.DBConn;

/**
 * 用户Dao层的实现
 * 
 * @author XU
 * 
 */
public class UserImpl implements UserDao {

    @Override
    public int insertUser(String sqlstr) {
	// sql
	String sql = "insert into user " + sqlstr;

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

    // 删除用户
    @Override
    public int deleteUser(String sqlstr) {
	// sql
	String sql = "delete from user " + sqlstr;
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

    // 更新用户
    @Override
    public int updateUser(String sqlstr) {
	// sql
	String sql = "update user " + sqlstr;
	// 获取连接
	System.out.println("updateUser:" + sql);
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

    // 查询
    @Override
    public ArrayList<User> selectUsers(String sqlstr) {
	// sql
	String sql = "select * from user " + sqlstr;
	// 获取连接
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ArrayList<User> userlist = null;
	try {
	    userlist = new ArrayList<>();
	    ps = conn.prepareStatement(sql);

	    rs = ps.executeQuery();
	    while (rs.next()) {
		// public User(int u_id, String u_name, String u_pwd, String
		// u_tel)
		User user = new User(rs.getInt("u_id"), rs.getString("u_name"),
			rs.getString("u_pwd"), rs.getString("u_tel"));
		System.out.println("UID:" + user.getU_id());
		// 每个字段进行判断，为空则不赋值
		// u_pic r_name u_sex u_credit;
		String u_pic = rs.getString("u_pic");
		String u_sex = rs.getString("u_sex");
		String r_name = rs.getString("r_name");
		int u_credit = rs.getInt("u_credit");
		if (!"".equals(u_pic)) {
		    user.setU_pic(u_pic);
		}
		if (!"".equals(u_sex)) {
		    user.setU_sex(u_sex);
		}
		if (!"".equals(r_name)) {
		    user.setR_name(r_name);
		}
		user.setU_paynum(rs.getInt("u_paynum"));
		user.setU_yue(rs.getDouble("u_yue"));
		user.setU_credit(u_credit);
		// 添加到集合
		userlist.add(user);

	    }
	    if (userlist.size() == 0) {
		return null;
	    } else {
		return userlist;
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    dbConn.CloseConn(rs, ps, conn);
	}
	return null;
    }

}
