package com.HiWeek.Servlet.ClientServlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Dao.daoHelper.UserDaoHelper;
import com.google.gson.Gson;

@WebServlet(name = "UserLoginServlet", urlPatterns = { "/servlet/client/UserLoginServlet" })
public class UserLogin extends HttpServlet {
    Gson gson;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	gson = new Gson();
	System.out.println("------------");

	String u_tel = req.getParameter("u_tel");
	String u_pwd = req.getParameter("u_pwd");

	UserDaoHelper uDaoHelper = new UserDaoHelper();
	int result = uDaoHelper.checkUserLogin(u_tel, u_pwd);
	if (result != 1) {
	    resp.getWriter().println(result);
	} else {
	    String jsonString = gson
		    .toJson(uDaoHelper.selectUserByU_tel(u_tel));
	    System.out.println(jsonString);
	    resp.getWriter().println(jsonString);
	}

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	doGet(req, resp);
    }

}
