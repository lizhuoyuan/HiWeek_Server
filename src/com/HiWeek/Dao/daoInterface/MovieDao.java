package com.HiWeek.Dao.daoInterface;

import java.util.ArrayList;

import com.HiWeek.Bean.Movie;

/**
 * 电影DAO层
 * 
 * @author XU
 * 
 */
public interface MovieDao {
	// 增加
	int insertMovie(Movie movie);

	// 删除
	int deleteMovie();

	// 根据条件查询
	ArrayList<Movie> selectMovies(String sql);
}
