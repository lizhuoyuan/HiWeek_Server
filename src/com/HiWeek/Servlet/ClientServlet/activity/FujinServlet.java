package com.HiWeek.Servlet.ClientServlet.activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Action;
import com.HiWeek.Bean.Cinema;
import com.HiWeek.Dao.daoHelper.ActionDaoHelper;
import com.HiWeek.Dao.daoHelper.CinemaDaoHelper;
import com.google.gson.Gson;

/**
 * @author 李卓原 创建时间：2015-11-13 下午8:22:42 查询分数高于4.5的电影院和活动id为2(热门)的活动
 */
@WebServlet(name = "FujinServlet", urlPatterns = { "/servlet/FujinServlet" })
public class FujinServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionDaoHelper ad = new ActionDaoHelper();
		// int t_id = Integer.parseInt(request.getParameter("t_id"));
		ArrayList<Action> ac = ad.selectActionByType(2);
		CinemaDaoHelper cd = new CinemaDaoHelper();
		ArrayList<Cinema> ci = cd.selectCinemaByGrade();
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("1", ci);
		hm.put("2", ac);
		Gson gson = new Gson();
		String json = gson.toJson(hm);
		System.out.println(json);
		response.getWriter().print(json);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
