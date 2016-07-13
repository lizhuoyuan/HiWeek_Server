package com.HiWeek.Servlet.ClientServlet.movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Movie_order;
import com.HiWeek.Dao.daoHelper.UserDaoHelper;
import com.HiWeek.Dao.daoImpl.Movie_orderDaoImpl;
import com.google.gson.Gson;

/**
 * 插入电影订单和修改用户的积分servlet
 * 
 * @author 郑
 *
 */
@WebServlet(name = "UpLoadMovie_order", urlPatterns = { "/servlet/client/UpLoadMovie_order" })
public class UpLoadMovie_order extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String bufferedString;
	StringBuilder sb = new StringBuilder();
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		request.getInputStream()));
	while ((bufferedString = reader.readLine()) != null) {
	    sb.append(bufferedString);
	}

	String json = URLDecoder.decode(sb.toString(), "utf-8");
	System.out.println(json);
	Gson gson = new Gson();
	// 插入订单表数据
	Movie_order movie_order = gson.fromJson(json, Movie_order.class);
	Movie_orderDaoImpl moi = new Movie_orderDaoImpl();
	int i = moi.insertMovie_order(movie_order);
	// 更新user表积分
	int u_id = movie_order.getUser().getU_id();
	int u_credit = movie_order.getUser().getU_credit();
	UserDaoHelper udi = new UserDaoHelper();
	udi.updateuesrcredit(u_id, u_credit);

	response.getWriter().print(i);
    }

}
