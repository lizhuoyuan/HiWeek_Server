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
 * @author 李卓原 创建时间：2015-11-11 下午2:22:31 查询是否收藏当前活动
 */
@WebServlet(name = "CollectFind", urlPatterns = { "/servlet/CollectFind" })
public class CollectFind extends HttpServlet {
	CollectDao cd ;
	public CollectFind() {
		cd = new CollectImpl();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int a_id = Integer.parseInt(request.getParameter("a_id"));
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		int i=cd.FindCollect(u_id,a_id);
		System.out.println("查询结果："+i);
		response.getWriter().print(i);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
