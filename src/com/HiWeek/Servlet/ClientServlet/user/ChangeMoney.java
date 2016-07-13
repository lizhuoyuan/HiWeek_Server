package com.HiWeek.Servlet.ClientServlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Dao.daoHelper.UserDaoHelper;

/**
 * @author 李卓原 创建时间：2015-10-27 上午9:43:43
 * 
 */
@WebServlet(name = "ChangeMoney", urlPatterns = "/servlet/ChangeMoney")
public class ChangeMoney extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	int u_id = Integer.parseInt(request.getParameter("u_id"));
	int u_credit = Integer.parseInt(request.getParameter("u_credit"));
	double u_yue = Double.valueOf(request.getParameter("u_yue"));
	UserDaoHelper ud = new UserDaoHelper();
	int i = ud.updateUserByID(u_id, u_credit, u_yue);
	System.out.println(i);
    }

}
