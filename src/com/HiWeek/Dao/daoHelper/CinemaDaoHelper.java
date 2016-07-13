package com.HiWeek.Dao.daoHelper;

import java.util.ArrayList;

import com.HiWeek.Bean.Cinema;
import com.HiWeek.Dao.daoImpl.CinemaDaoImpl;

/**
 * 
 * @ClassName: CinemaDaoHelper
 * @Description: 电影表的帮助类
 * @author: XU
 * @date: 2015年10月18日 下午7:58:09
 */
public class CinemaDaoHelper {
	CinemaDaoImpl cDaoImpl;

	public CinemaDaoHelper() {
		this.cDaoImpl = new CinemaDaoImpl();
	}

	/**
	 * 
	 * @Title: loadingCinemas
	 * @Description:查询影院信息，每次显示10条信息
	 * @return
	 * @Author XU
	 */
	public ArrayList<Cinema> loadingCinemas(int page) {
		String sqlstr = "limit " + page * 10 + ",10";
		return cDaoImpl.selectCinemas(sqlstr);
	}

	public ArrayList<Cinema> loadingCinemas() {
		return loadingCinemas(0);
	}

	/**
	 * 
	 * 
	 * @Title: selectCinemaByID
	 * @Description: TODO
	 * @param c_id
	 * @return
	 * @Author XU
	 */
	public Cinema selectCinemaByID(int c_id) {
		String sqlstr = "where c_id=" + c_id;
		if (cDaoImpl.selectCinemas(sqlstr).size() == 0) {
			return null;
		} else {
			return cDaoImpl.selectCinemas(sqlstr).get(0);
		}
	}

	public void upDateCinemaGrade(int cinema_id, float grade) {
		// 取出Cinema对象
		Cinema cinema = selectCinemaByID(cinema_id);
		// 取出评论人数，平均分
		int count = cinema.getC_count();
		float c_grade = cinema.getC_grade();
		// 计算新的平均评分
		float newgrade = (c_grade * count + grade) / (count + 1);
		cDaoImpl.updategrade(cinema_id, newgrade);
	}

	// li 取评分高的影院
	public ArrayList<Cinema> selectCinemaByGrade() {
		String sqlstr = "where c_grade>4.5 ORDER BY c_grade DESC limit 0,5";
		if (cDaoImpl.selectCinemas(sqlstr).size() == 0) {
			return null;
		} else {
			return cDaoImpl.selectCinemas(sqlstr);
		}
	}
}
