package com.HiWeek.Servlet.ClientServlet.activity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Collect;
import com.HiWeek.Dao.daoImpl.CollectImpl;
import com.HiWeek.Dao.daoInterface.CollectDao;
import com.google.gson.Gson;

/**
 * @author 李卓原
 * 创建时间：2015-10-27 下午7:36:31 
 * 
 */
@WebServlet(name="SelectCollect",urlPatterns={"/servlet/SelectCollect"})
public class SelectCollect extends HttpServlet {
	CollectDao ce;
	public SelectCollect() {
		ce = new CollectImpl();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		ArrayList<Collect> collect = ce.findCollect(u_id);
		// 将集合数据转换成gson数据
				Gson gson = new Gson();
				String acString = gson.toJson(collect);
				PrintWriter pw = response.getWriter();
				pw.write(acString);
				pw.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
