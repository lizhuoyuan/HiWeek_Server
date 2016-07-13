package com.HiWeek.Servlet.ClientServlet.activity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Dao.daoImpl.CollectImpl;
import com.HiWeek.Dao.daoInterface.CollectDao;

/**
 * @author 李卓原 创建时间：2015-11-9 上午9:42:39
 * 
 */
@WebServlet(name = "DeleteCollect", urlPatterns = { "/servlet/DeleteCollect" })
public class DeleteCollect extends HttpServlet {

	CollectDao cd;

	public DeleteCollect() {
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
		int i = cd.deleteCollect(a_id, u_id);
		System.out.println(i);
	}

}
