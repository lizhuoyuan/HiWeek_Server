package com.HiWeek.Dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.HiWeek.Bean.Discuss;
import com.HiWeek.Bean.Movie;
import com.HiWeek.Bean.User;
import com.HiWeek.Dao.daoHelper.MovieDaoHelper;
import com.HiWeek.Dao.daoHelper.UserDaoHelper;
import com.HiWeek.Dao.daoInterface.CommentDao;
import com.HiWeek.Utils.DBConn;

public class CommentDaoImpl implements CommentDao {
    private UserDaoHelper userDaoHelper;
    private MovieDaoHelper movieDaoHelper;

    public CommentDaoImpl() {
	movieDaoHelper = new MovieDaoHelper();
	userDaoHelper = new UserDaoHelper();
    }

    @Override
    public int insertComment(Discuss discuss) {
	String sql = "insert into discuss(m_id,u_id,d_cont,d_time,m_grade) values(?,?,?,?,?)";

	// 获取连接
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	int key = 0;
	ResultSet keys = null;
	try {
	    ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

	    // ps.setInt(1, discuss.getD_id());
	    ps.setInt(1, discuss.getMovie().getM_id());
	    ps.setInt(2, discuss.getUser().getU_id());
	    ps.setString(3, discuss.getD_cont());
	    ps.setString(4, discuss.getD_time());
	    ps.setFloat(5, discuss.getM_grade());
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
    public int deleteComment(String sqlstr) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public int updateComment(String sqlstr) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public ArrayList<Discuss> SelectComments(String sqlstr) {
	// sql
	String sql = "select * from discuss " + sqlstr;
	// 获取连接
	System.out.println(sql);
	DBConn dbConn = DBConn.getInstance();
	Connection conn = dbConn.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	Discuss discuss;
	Movie movie;
	User user;
	ArrayList<Discuss> commentlist = null;
	try {
	    commentlist = new ArrayList<>();
	    ps = conn.prepareStatement(sql);

	    rs = ps.executeQuery();
	    while (rs.next()) {
		discuss = new Discuss();
		discuss.setD_id(rs.getInt("d_id"));
		movie = movieDaoHelper.selectMovie(rs.getInt("m_id"));
		discuss.setMovie(movie);
		user = userDaoHelper.selectUserByID(rs.getInt("u_id"));
		discuss.setUser(user);
		discuss.setD_cont(rs.getString("d_cont"));
		discuss.setD_time(rs.getString("d_time"));
		discuss.setM_grade(rs.getFloat("m_grade"));
		// 添加到集合
		commentlist.add(discuss);
	    }
	    return commentlist;
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    dbConn.CloseConn(rs, ps, conn);
	}
	return null;
    }
}
