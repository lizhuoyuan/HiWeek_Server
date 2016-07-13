package com.HiWeek.Servlet.ClientServlet.activity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Dao.daoImpl.CollectImpl;
import com.HiWeek.Dao.daoInterface.CollectDao;

/**
 * @author 李卓原 创建时间：2015-11-9 上午9:18:24
 * 
 */
@WebServlet(name = "AddCollect", urlPatterns = { "/servlet/AddCollect" })
public class AddCollect extends HttpServlet {
	CollectDao cd;

	public AddCollect() {
		cd = new CollectImpl();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		int a_id = Integer.parseInt(request.getParameter("a_id"));
		String a_itemname = request.getParameter("a_itemname");
		String ce_time = request.getParameter("ce_time");
		int i  = cd.insertCollect(a_id, ce_time, a_itemname, u_id);
		System.out.println(i);
	}

}
