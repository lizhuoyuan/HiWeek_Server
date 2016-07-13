package com.HiWeek.Servlet.ClientServlet.activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Action_order;
import com.HiWeek.Dao.daoHelper.UserDaoHelper;
import com.HiWeek.Dao.daoImpl.Action_orderImpl;
import com.google.gson.Gson;

/**
 * 插入action_order的servlet
 * 
 * @author Administrator
 *
 */
@WebServlet(name = "UpLoadAction_order", urlPatterns = { "/servlet/client/UpLoadAction_order" })
public class UpLoadAction_order extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	System.out.println("UpLoadAction_order");
	String bufferedString;
	StringBuilder sb = new StringBuilder();
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		request.getInputStream()));
	while ((bufferedString = reader.readLine()) != null) {
	    sb.append(bufferedString);
	}
    //插入活动的订单
	String json = URLDecoder.decode(sb.toString(), "utf-8");
	System.out.println(json);
	Gson gson = new Gson();
	Action_order action_order = gson.fromJson(json, Action_order.class);
	Action_orderImpl aoi = new Action_orderImpl();
	int i = aoi.insertAction_orderDao(action_order);//返回活动的id
	//修改用户积分
		int u_id=action_order.getUser().getU_id();
		int u_credit=action_order.getUser().getU_credit();
		UserDaoHelper udi=new UserDaoHelper();
		udi.updateuesrcredit(u_id, u_credit);
		response.getWriter().print(i);
    }
}
