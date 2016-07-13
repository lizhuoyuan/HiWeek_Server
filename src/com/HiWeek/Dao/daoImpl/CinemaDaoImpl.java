package com.HiWeek.Dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.HiWeek.Bean.Cinema;
import com.HiWeek.Dao.daoInterface.CinemaDao;
import com.HiWeek.Utils.DBConn;

/**
 * 电影Dao层的实现
 * 
 * @author XU
 * 
 */
public class CinemaDaoImpl implements CinemaDao {
    /**
     * 
     * @Title: insertCinema
     * @Description: 插入电影
     * @param cinema
     * @return
     */
    @Override
    public int insertCinema(Cinema cinema) {
	// int c_id, String c_name, String c_address, String c_tel,
	// float c_lat, float c_lon, String c_city, String c_traffic
	String sql = "insert into cinema values(?,?,?,?,?,?,?,?,?)";

	// 获取连接
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
	    ps = conn.prepareStatement(sql);

	    ps.setInt(1, cinema.getC_id());
	    ps.setString(2, cinema.getC_name());
	    ps.setString(3, cinema.getC_address());
	    ps.setString(4, cinema.getC_tel());
	    ps.setFloat(5, cinema.getC_lat());
	    ps.setFloat(6, cinema.getC_lon());
	    ps.setString(7, cinema.getC_city());
	    ps.setString(8, cinema.getC_traffic());
	    ps.setFloat(9, cinema.getC_grade());
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

    /**
     * 
     * @Title: deleteCinema
     * @Description: 清空电影表
     * @return
     */
    @Override
    public int deleteCinema() {
	// sql
	String sql = "delete from cinema ";
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

    /**
     * 
     * @Title: selectCinemas
     * @Description: 查询电影信息
     * @param sqlstr
     * @return
     */
    @Override
    public ArrayList<Cinema> selectCinemas(String sqlstr) {
	// sql
	String sql = "select * from cinema " + sqlstr;
	System.out.println("sql:" + sql);
	// 获取连接
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	Cinema cinema;
	ArrayList<Cinema> cinemalist = null;
	try {
	    cinemalist = new ArrayList<>();
	    ps = conn.prepareStatement(sql);

	    rs = ps.executeQuery();
	    while (rs.next()) {
		cinema = new Cinema();
		cinema.setC_address(rs.getString("c_address"));
		cinema.setC_city(rs.getString("c_city"));
		cinema.setC_id(rs.getInt("c_id"));
		cinema.setC_lat(rs.getFloat("c_lat"));
		cinema.setC_lon(rs.getFloat("c_lon"));
		cinema.setC_name(rs.getString("c_name"));
		cinema.setC_tel(rs.getString("c_tel"));
		cinema.setC_traffic(rs.getString("c_traffic"));
		cinema.setC_grade(rs.getFloat("c_grade"));
		cinema.setC_count(rs.getInt("c_count"));
		System.out.println("Grade:" + rs.getFloat("c_grade"));

		// 添加到集合
		cinemalist.add(cinema);
	    }
	    return cinemalist;
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    dbConn.CloseConn(rs, ps, conn);
	}
	return null;
    }

    @Override
    public int updategrade(int c_id, double c_grade) {
	// TODO Auto-generated method stub

	String sql = "update cinema set c_grade=?,c_count = c_count+1 where c_id=?";
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	try {
	    ps = conn.prepareStatement(sql);
	    ps.setDouble(1, c_grade);
	    ps.setInt(2, c_id);
	    int i = ps.executeUpdate();
	    if (i > 0) {
		return c_id;
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
