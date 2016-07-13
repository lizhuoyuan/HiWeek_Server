package com.HiWeek.Dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.HiWeek.Bean.Movie;
import com.HiWeek.Dao.daoInterface.MovieDao;
import com.HiWeek.Utils.DBConn;

/**
 * MovieDao层的实现<br>
 * 
 * @author XU
 * 
 */
public class MovieDaoImpl implements MovieDao {

    @Override
    public int insertMovie(Movie movie) {
	// sql
	// int m_id, String m_name, String m_poster, String m_introduce,
	// double m_grade, String m_director, String m_district,
	// String m_duration, String m_date, String m_genres,
	// String m_language, String m_year
	String sql = "insert into movie values(?,?,?,?,?,?,?,?,?,?,?,?)";

	// 获取连接
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
	    ps = conn.prepareStatement(sql);

	    ps.setInt(1, movie.getM_id());
	    ps.setString(2, movie.getM_name());
	    ps.setString(3, movie.getM_poster());
	    ps.setString(4, movie.getM_introduce());
	    ps.setDouble(5, movie.getM_grade());
	    ps.setString(6, movie.getM_director());
	    ps.setString(7, movie.getM_district());
	    ps.setString(8, movie.getM_duration());
	    ps.setString(9, movie.getM_date());
	    ps.setString(10, movie.getM_genres());
	    ps.setString(11, movie.getM_language());
	    ps.setString(12, movie.getM_year());
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
    public int deleteMovie() {
	// sql
	String sql = "delete from movie ";
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
    public ArrayList<Movie> selectMovies(String sqlstr) {
	// sql
	String sql = "select * from movie " + sqlstr;
	System.out.println(sql);
	// 获取连接
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ArrayList<Movie> movielist = null;
	try {
	    movielist = new ArrayList<>();
	    ps = conn.prepareStatement(sql);

	    rs = ps.executeQuery();
	    while (rs.next()) {
		Movie movie = new Movie();
		movie.setM_date(rs.getDate("m_date").toString());
		movie.setM_director(rs.getString("m_director"));
		movie.setM_district(rs.getString("m_district"));
		movie.setM_duration(rs.getString("m_duration"));
		movie.setM_genres(rs.getString("m_genres"));
		movie.setM_grade(rs.getDouble("m_grade"));
		movie.setM_id(rs.getInt("m_id"));
		movie.setM_introduce(rs.getString("m_introduce"));
		movie.setM_language(rs.getString("m_language"));
		movie.setM_name(rs.getString("m_name"));
		movie.setM_poster(rs.getString("m_poster"));
		movie.setM_year(rs.getString("m_year"));
		// 添加到集合
		movielist.add(movie);
	    }
	    return movielist;
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    dbConn.CloseConn(rs, ps, conn);
	}
	return null;
    }

}
