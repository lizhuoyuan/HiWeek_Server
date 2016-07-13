package com.HiWeek.Servlet.ClientServlet.movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Movie;
import com.HiWeek.Dao.daoImpl.MovieDaoImpl;
import com.google.gson.Gson;

@WebServlet(name = "UpLoadMovieInfo", urlPatterns = { "/servlet/client/UpLoadMovieInfo" })
public class UpLoadMovieInfo extends HttpServlet {
    Gson gson;
    MovieDaoImpl movieDaoImpl;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	gson = new Gson();
	movieDaoImpl = new MovieDaoImpl();
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		req.getInputStream()));
	String buffString;
	StringBuilder sb = new StringBuilder();
	while ((buffString = reader.readLine()) != null) {
	    sb.append(URLDecoder.decode(buffString, "UTF-8"));
	}
	reader.close();
	System.out.println("POSTMovie:" + sb.toString());
	Movie movie = gson.fromJson(sb.toString(), Movie.class);
	movieDaoImpl.insertMovie(movie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	doGet(req, resp);

    }

}
