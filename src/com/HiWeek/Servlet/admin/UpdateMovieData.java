package com.HiWeek.Servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Movie;
import com.HiWeek.Dao.daoImpl.MovieDaoImpl;
import com.HiWeek.net.util.MovieUtil;

/**
 * 更新数据库电影数据 <br>
 * 1,首先获取电影最新数据,将ID存放在集合<br>
 * 2,依次根据电影ID集合查询电影详细信息存放到数据库<br>
 * 3,客户端使用内置SDK
 * 
 * @author XU
 * 
 */
@WebServlet(name = "UpdateMovieData", urlPatterns = { "/servlet/Admin/UpdateMovieData" })
public class UpdateMovieData extends HttpServlet {
	MovieUtil mUtil;
	MovieDaoImpl mImpl;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		mUtil = new MovieUtil();
		mImpl = new MovieDaoImpl();
		int flag;
		PrintWriter out = resp.getWriter();
		ArrayList<Movie> movies = mUtil.getMovies(21);
		mImpl.deleteMovie();
		for (Movie movie : movies) {

			flag = mImpl.insertMovie(movie);
			if (flag <= 0) {
				out.println("error");
				return;
			}
		}
		out.println("success");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
