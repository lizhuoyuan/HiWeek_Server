package com.HiWeek.Servlet.ClientServlet.movie;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Movie;
import com.HiWeek.Dao.daoHelper.MovieDaoHelper;
import com.google.gson.Gson;

/**
 * 
 * @ClassName: LoadingMovies
 * @Description: 用户加载电影数据的Servlet,参数分为两种情况，
 * @author: XU
 * @date: 2015年10月16日 下午4:11:35
 */
@WebServlet(name = "LoadingMovies", urlPatterns = { "/servlet/client/LoadingMovies" })
public class LoadingMovies extends HttpServlet {
    MovieDaoHelper mDaoHelper;
    ArrayList<Movie> movies;
    Gson gson;

    public LoadingMovies() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	mDaoHelper = new MovieDaoHelper();
	String page = req.getParameter("pagesize");
	gson = new Gson();
	if (page == "" || page == null) {
	    movies = mDaoHelper.selectMovies();
	} else {
	    movies = mDaoHelper.selectMovies(Integer.parseInt(page));
	}
	String result = gson.toJson(movies);
	resp.getWriter().println(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	doGet(req, resp);
    }

}
