package com.HiWeek.Dao.daoHelper;

import java.util.ArrayList;

import com.HiWeek.Bean.Action;
import com.HiWeek.Bean.Movie;
import com.HiWeek.Dao.daoImpl.MovieDaoImpl;

/**
 * 
 * @ClassName: MovieDaoHelper
 * @Description: 电影表的帮助类
 * @author: XU
 * @date: 2015年10月16日 下午4:00:47
 */
public class MovieDaoHelper {
	private MovieDaoImpl mDaoImpl;

	public MovieDaoHelper() {
		mDaoImpl = new MovieDaoImpl();
	}

	/**
	 * 
	 * @Title: selectMovies
	 * @Description: 因为数据过多，所以设置为分页查询，默认每页查询10条
	 * @return
	 * @Author XU
	 */
	public ArrayList<Movie> selectMovies(int page) {
		String sqlstr = "limit " + page * 10 + ",10";

		return mDaoImpl.selectMovies(sqlstr);
	}

	public ArrayList<Movie> selectMovies() {
		return selectMovies(0);
	}

	public Movie selectMovie(int movieID) {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		String sqlStr = " where m_id = " + movieID;
		movies = mDaoImpl.selectMovies(sqlStr);
		if (movies.size() <= 0) {
			return null;

		} else {
			return movies.get(0);
		}
	}

	public ArrayList<Movie> selectMovieByweek() {
		String sqlstr =" limit 0,5";
		if (mDaoImpl.selectMovies(sqlstr).size() == 0) {
			return null;
		} else {
			return mDaoImpl.selectMovies(sqlstr);
		}
	}
	
	public ArrayList<Movie> selectMovieByhost() {
		String sqlstr ="ORDER BY m_id DESC "+" limit 0,5";
		if (mDaoImpl.selectMovies(sqlstr).size() == 0) {
			return null;
		} else {
			return mDaoImpl.selectMovies(sqlstr);
		}
	}
}
