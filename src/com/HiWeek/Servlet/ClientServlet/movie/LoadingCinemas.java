package com.HiWeek.Servlet.ClientServlet.movie;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Cinema;
import com.HiWeek.Dao.daoHelper.CinemaDaoHelper;
import com.google.gson.Gson;

@WebServlet(name = "LoadingCinemas", urlPatterns = { "/servlet/client/LoadingCinemas" })
public class LoadingCinemas extends HttpServlet {
    CinemaDaoHelper cDaoHelper;
    ArrayList<Cinema> cinemas;
    Gson gson;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	String page = req.getParameter("pageSize");
	System.out.println("page:" + page);
	cDaoHelper = new CinemaDaoHelper();
	cinemas = new ArrayList<Cinema>();
	gson = new Gson();
	if (page == "" || page == null) {
	    cinemas = cDaoHelper.loadingCinemas();
	} else {
	    cinemas = cDaoHelper.loadingCinemas(Integer.parseInt(page));
	}
	String jsonString = gson.toJson(cinemas);

	resp.getWriter().println(jsonString);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	doGet(req, resp);

    }

}
