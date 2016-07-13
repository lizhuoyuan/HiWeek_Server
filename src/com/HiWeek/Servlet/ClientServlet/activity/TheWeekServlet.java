package com.HiWeek.Servlet.ClientServlet.activity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Action;
import com.HiWeek.Bean.Movie;
import com.HiWeek.Dao.daoHelper.ActionDaoHelper;
import com.HiWeek.Dao.daoHelper.MovieDaoHelper;
import com.google.gson.Gson;

@WebServlet(name = "TheWeekServlet", urlPatterns = "/servlet/TheWeekServlet")
public class TheWeekServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ActionDaoHelper ad = new ActionDaoHelper();
	ArrayList<Action> list1 = ad.selectActionByweek();
	MovieDaoHelper md = new MovieDaoHelper();
	ArrayList<Movie> list2 = md.selectMovieByweek();
	HashMap<String, Object> hm = new HashMap<>();
	hm.put("2", list1);
	hm.put("1", list2);
	Gson gson = new Gson();
	String json = gson.toJson(hm);
	System.out.println(json);
	response.getWriter().print(json);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	doGet(request, response);
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException
     *             if an error occurs
     */
    public void init() throws ServletException {
	// Put your code here
    }

}
