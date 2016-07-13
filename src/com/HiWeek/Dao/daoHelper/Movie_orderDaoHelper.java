package com.HiWeek.Dao.daoHelper;

import java.util.ArrayList;

import com.HiWeek.Bean.Movie_order;
import com.HiWeek.Dao.daoImpl.Movie_orderDaoImpl;

/**
 * 电影订单的帮助类
 * 
 * @author Administrator
 * 
 */
public class Movie_orderDaoHelper {
	private Movie_orderDaoImpl m_orderDaoImpl;

	public Movie_orderDaoHelper(Movie_orderDaoImpl m_orderDaoImpl) {
	}

	public Movie_orderDaoHelper() {
		m_orderDaoImpl = new Movie_orderDaoImpl();
	}

	public Movie_order selsetByID(int mo_id) {
		String sqrlt = "where mo_id=" + mo_id;
		if (m_orderDaoImpl.selectMovie_order(sqrlt).size() == 0) {
			return null;
		} else {
			return m_orderDaoImpl.selectMovie_order(sqrlt).get(0);
		}
	}

	/**
	 * 根据用户id查询电影订单
	 * 
	 * @param u_id
	 * @return
	 */
	public ArrayList<Movie_order> selectByuID(int u_id) {
		String sqrlt = "where u_id=" + u_id;
		if (m_orderDaoImpl.selectMovie_order(sqrlt).size() == 0) {
			return null;
		} else {
			return m_orderDaoImpl.selectMovie_order(sqrlt);
		}
	}

	/**
	 * 分页按 u_id 来查询
	 * 
	 * @param u_id
	 * @param page
	 * @return
	 */
	public ArrayList<Movie_order> selectBypage(int u_id, int page) {
		String sqrlt = "WHERE u_id=" + u_id + " ORDER BY mo_id DESC "
				+ "limit " + (page - 1) * 4 + ",4";
		return m_orderDaoImpl.selectMovie_order(sqrlt);
	}

}
