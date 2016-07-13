package com.HiWeek.Servlet.ClientServlet.activity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Action;
import com.HiWeek.Dao.daoHelper.ActionDaoHelper;
import com.HiWeek.Dao.daoInterface.ActionDao;
import com.google.gson.Gson;

/**
 * @author 李卓原 创建时间：2015-10-27 下午9:24:35
 * 
 */
@WebServlet(name = "SelectActionById", urlPatterns = { "/servlet/SelectActionById" })
public class SelectActionById extends HttpServlet {

	public SelectActionById() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String a_id = request.getParameter("a_id");
		ActionDaoHelper adh = new ActionDaoHelper();
		Action ac = adh.selectActionByID(a_id);
		// 将集合数据转换成gson数据
				Gson gson = new Gson();
				String acString = gson.toJson(ac);
				PrintWriter pw = response.getWriter();
				pw.write(acString);
				pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
