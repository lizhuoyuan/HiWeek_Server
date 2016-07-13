package com.HiWeek.Servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminLogin", urlPatterns = { "/servlet/AdminLogin" })
public class AdminLogin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("adminName");
		String pwd = req.getParameter("adminPwd");
		if (name.equals("xujichang") && pwd.equals("123456")) {
			resp.sendRedirect("../Admin/Admin.jsp");
		} else {
			resp.sendRedirect("../Admin/AdminLogin.jsp?error=1");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
