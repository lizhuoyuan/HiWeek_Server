package com.HiWeek.Servlet.ClientServlet.movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Movie;
import com.HiWeek.Dao.daoHelper.MovieDaoHelper;
import com.HiWeek.Dao.daoImpl.MovieDaoImpl;
import com.google.gson.Gson;

/**
 * 
 * @ClassName: GetMovieInfo
 * @Description: 根据电影ID获取电影信息。参数为电影ID
 * @author: XU
 * @date: 2015年11月3日 下午2:16:18
 */
@WebServlet(name = "GetMovieInfo", urlPatterns = { "/servlet/client/GetMovieInfo" })
public class GetMovieInfo extends HttpServlet {
    MovieDaoHelper mDaoHelper;
    Gson gson;
    MovieDaoImpl movieDaoImpl;

    public GetMovieInfo() {
	mDaoHelper = new MovieDaoHelper();
	gson = new Gson();
	movieDaoImpl = new MovieDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {

	String ID = req.getParameter("MovieID");
	String reString;
	if (ID == null || "".equals(ID)) {
	    reString = "";
	} else {
	    Movie movie = mDaoHelper.selectMovie(Integer.parseInt(ID));

	    reString = movie == null ? "" : gson.toJson(movie);
	}
	resp.getWriter().write(reString);
	System.out.println("GETMovie:" + reString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		req.getInputStream()));
	String buffString;
	StringBuilder sb = new StringBuilder();
	while ((buffString = reader.readLine()) != null) {
	    sb.append(buffString);
	}
	reader.close();
	System.out.println("POSTMovie:" + sb.toString());
	Movie movie = gson.fromJson(sb.toString(), Movie.class);
	movieDaoImpl.insertMovie(movie);
    }
}
