package com.HiWeek.Servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Cinema;
import com.HiWeek.Dao.daoImpl.CinemaDaoImpl;
import com.HiWeek.net.util.CinemaUtil;

@WebServlet(name = "UpdateCinemaData", urlPatterns = { "/servlet/Admin/UpdateCinemaData" })
public class UpdateCinemaData extends HttpServlet {
	CinemaUtil cUtil;
	CinemaDaoImpl cImpl;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		cUtil = new CinemaUtil();
		cImpl = new CinemaDaoImpl();
		PrintWriter out = resp.getWriter();
		ArrayList<Cinema> cinemas = cUtil.getCinemaData(21);
		cImpl.deleteCinema();
		int flag;
		for (Cinema cinema : cinemas) {
			flag = cImpl.insertCinema(cinema);
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
