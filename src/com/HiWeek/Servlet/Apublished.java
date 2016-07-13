package com.HiWeek.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.HiWeek.Bean.Action;
import com.HiWeek.Dao.daoHelper.ActionDaoHelper;

@WebServlet(name = "Apublished", urlPatterns = "/servlet/Apublished")
public class Apublished extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionDaoHelper aDaoHelper = new ActionDaoHelper();
		HttpSession session = request.getSession();
		int mer_id = 16;
		session.setAttribute("publishedA",
				aDaoHelper.selectActionsByMechant(mer_id));
		response.sendRedirect("../Merchant/PubedActivities.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
