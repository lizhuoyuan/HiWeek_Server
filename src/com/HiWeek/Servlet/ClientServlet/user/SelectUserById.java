package com.HiWeek.Servlet.ClientServlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.User;
import com.HiWeek.Dao.daoHelper.UserDaoHelper;
import com.HiWeek.Dao.daoImpl.UserImpl;
import com.HiWeek.Dao.daoInterface.UserDao;
import com.google.gson.Gson;

/**
 * @author 李卓原
 * 创建时间：2015-10-27 上午8:58:07 
 * 
 */
@WebServlet(name = "SelectUserById", urlPatterns = "/servlet/SelectUserById")
public class SelectUserById extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		UserDaoHelper udh = new UserDaoHelper();
		User us = udh.selectUserByID(u_id);
		
		// 将集合数据转换成gson数据
		Gson gson = new Gson();
		String acString = gson.toJson(us);
		PrintWriter pw = response.getWriter();
		pw.write(acString);
		pw.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
