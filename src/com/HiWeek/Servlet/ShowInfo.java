package com.HiWeek.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.HiWeek.Bean.Action;
import com.HiWeek.Dao.daoHelper.ActionDaoHelper;

@WebServlet(name = "ShowInfo", urlPatterns = "/servlet/ShowInfo")
public class ShowInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionDaoHelper aDaoHelper = new ActionDaoHelper();
		HttpSession session = request.getSession();
		String a_id = request.getParameter("a_id");
		Action action = aDaoHelper.selectActionByID(a_id);
		session.setAttribute("Action", action);
		response.sendRedirect("../Merchant/ActionInfo.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
