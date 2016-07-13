package com.HiWeek.Servlet.ClientServlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Dao.daoHelper.UserDaoHelper;

/**
 * @author 李卓原
 * 创建时间：2015-11-7 下午5:29:35 
 * 
 */
@WebServlet(name = "ChangeMySet", urlPatterns = { "/servlet/ChangeMySet" })
public class ChangeMySet extends HttpServlet {
	UserDaoHelper ud = new UserDaoHelper();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int u_id =Integer.parseInt(request.getParameter("u_id"));
		String u_sex = request.getParameter("u_sex");
		String u_name = request.getParameter("u_name");
		int u_paynum = Integer.parseInt(request.getParameter("u_paynum"));
//		int i = ud.updateUser(u_id, u_sex, u_name, u_paynum);
	//	System.out.println(i);
	}

}
