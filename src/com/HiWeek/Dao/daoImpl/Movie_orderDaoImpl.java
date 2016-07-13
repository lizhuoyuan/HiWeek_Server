package com.HiWeek.Dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.HiWeek.Bean.Movie_order;
import com.HiWeek.Dao.daoHelper.CinemaDaoHelper;
import com.HiWeek.Dao.daoHelper.MovieDaoHelper;
import com.HiWeek.Dao.daoHelper.UserDaoHelper;
import com.HiWeek.Dao.daoInterface.Movie_orderDao;
import com.HiWeek.Utils.DBConn;
import com.mysql.jdbc.Statement;

/**
 * Movie_orderDao层的实现
 * 
 * @author 郑雅倩
 *
 */
public class Movie_orderDaoImpl implements Movie_orderDao {
    // int mo_id;Cinema cinema,Movie movie,Office office
    // User user,String mo_seat，double mo_price，String mo_session，
    // String mo_state
    @Override
    public int insertMovie_order(Movie_order movie_order) {
	String sql = "insert into movie_order(c_id,m_id,u_id,mo_seat,mo_price,mo_session,mo_date,mo_count,mo_credit) values(?,?,?,?,?,?,?,?,?)";
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	int key = 0;
	ResultSet keys = null;
	try {
	    ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

	    ps.setInt(1, movie_order.getCinema().getC_id());
	    ps.setInt(2, movie_order.getMovie().getM_id());
	    ps.setInt(3, movie_order.getUser().getU_id());
	    ps.setString(4, movie_order.getMo_seat());
	    ps.setDouble(5, movie_order.getMo_price());
	    ps.setString(6, movie_order.getMo_session());
	    ps.setString(7, movie_order.getMo_date());
	    ps.setInt(8, movie_order.getMo_count());
	    ps.setInt(9, movie_order.getMo_credit());
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
    public int deleteMovie_order(int mo_id) {
	String sql = "delete from movie_order where mo_id=?";
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
	    ps = conn.prepareStatement(sql);
	    ps.setInt(1, mo_id);
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
    public ArrayList<Movie_order> selectMovie_order(String sqlstr) {
	String sql = "select * from Movie_order " + sqlstr;
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ArrayList<Movie_order> Movie_orderlist = new ArrayList<Movie_order>();
	try {
	    ps = conn.prepareStatement(sql);
	    rs = ps.executeQuery();
	    Movie_order movie_order;
	    while (rs.next()) {
		movie_order = new Movie_order();
		movie_order.setMo_id(rs.getInt("mo_id"));
		movie_order.setCinema(new CinemaDaoHelper().selectCinemaByID(rs
			.getInt("c_id")));
		movie_order.setMovie(new MovieDaoHelper().selectMovie(rs
			.getInt("m_id")));
		movie_order.setUser(new UserDaoHelper().selectUserByID(rs
			.getInt("u_id")));
		movie_order.setMo_price(rs.getDouble("mo_price"));
		movie_order.setMo_seat(rs.getString("mo_seat"));
		movie_order.setMo_session(rs.getString("mo_session"));
		movie_order.setMo_state(rs.getInt("mo_state"));
		movie_order.setMo_count(rs.getInt("mo_count"));
		movie_order.setMo_credit(rs.getInt("mo_credit"));
		movie_order.setMo_date(rs.getString("mo_date"));
		Movie_orderlist.add(movie_order);
	    }
	    return Movie_orderlist;
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    dbConn.CloseConn(rs, ps, conn);
	}
	return null;
    }

    @Override
    public int updataMovie_orderState(int mo_id) {
	String sql = "update Movie_order set mo_state=2 where mo_id=?";
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	try {
	    ps = conn.prepareStatement(sql);
	    ps.setInt(1, mo_id);
	    int i = ps.executeUpdate();
	    if (i > 0) {
		return mo_id;
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

    @Override
    public int updataMovie_orderState3(int mo_id) {
	String sql = "update Movie_order set mo_state=3 where mo_id=?";
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	try {
	    ps = conn.prepareStatement(sql);
	    ps.setInt(1, mo_id);
	    int i = ps.executeUpdate();
	    if (i > 0) {
		return mo_id;
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
