package com.HiWeek.Dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.HiWeek.Bean.Quiz;
import com.HiWeek.Bean.User;
import com.HiWeek.Dao.daoHelper.UserDaoHelper;
import com.HiWeek.Dao.daoInterface.QuizDao;
import com.HiWeek.Utils.DBConn;

/**
 * @author 李卓原 创建时间：2015-10-21 下午7:14:33
 * 
 */
public class QuizImpl implements QuizDao {

	@Override
	public int insertQuiz(String sqlstr) {
		// sql
		String sql = "insert into quiz (q_time,q_cont,a_itemname,a_id,u_id) values"
				+ sqlstr;
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
	public ArrayList<Quiz> findQuiz(Integer a_id) {
		String sql = "select * from quiz where a_id=?";
		System.out.println(sql);
		// 获取连接
		DBConn dbConn = DBConn.getInstance();
		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Quiz> question = new ArrayList<Quiz>();
		UserDaoHelper uHelper = new UserDaoHelper();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, a_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String q_time = rs.getString("q_time");
				String q_cont = rs.getString("q_cont");
				String q_answer = rs.getString("q_answer");
				int u_id = rs.getInt("u_id");
				User user = uHelper.selectUserByID(u_id);
				Quiz qs = new Quiz(q_time, q_cont, q_answer);
				qs.setUser(user);
				question.add(qs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return question;
	}

	@Override
	public ArrayList<Quiz> SelectMyQuestion(Integer a_id) {
		String sql = "select * from quiz where a_id=? ORDER BY q_id DESC LIMIT 0,2";
		System.out.println(sql);
		// 获取连接
		DBConn dbConn = DBConn.getInstance();
		Connection conn = dbConn.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Quiz> question = new ArrayList<Quiz>();
		UserDaoHelper uHelper = new UserDaoHelper();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, a_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String q_time = rs.getString("q_time");
				String q_cont = rs.getString("q_cont");
				String q_answer = rs.getString("q_answer");
				int u_id = rs.getInt("u_id");
				User user = uHelper.selectUserByID(u_id);
				Quiz qs = new Quiz(q_time, q_cont, q_answer);
				qs.setUser(user);
				question.add(qs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return question;
	}
}
