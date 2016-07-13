package com.HiWeek.Servlet.ClientServlet.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Action_order;
import com.HiWeek.Bean.Movie_order;
import com.HiWeek.Dao.daoHelper.Action_orderDaoHelper;
import com.HiWeek.Dao.daoHelper.Movie_orderDaoHelper;
import com.google.gson.Gson;

/**
 * 得到订单的数据
 * 
 * @author 郑雅倩
 *
 */
@WebServlet(name = "GetOrderServlet", urlPatterns = "/servlet/GetOrderServlet")
public class GetOrderServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	System.out.println("jdfhdsjf");
	int u_id = Integer.parseInt(request.getParameter("u_id"));
	String s=request.getParameter("page");
	System.out.println("s----------"+s);
	int page=Integer.parseInt(s);
	System.out.println("page---------"+page);
	System.out.println(u_id);
	Movie_orderDaoHelper mod = new Movie_orderDaoHelper();
	Action_orderDaoHelper adh = new Action_orderDaoHelper();
	ArrayList<Action_order> list1 = adh.selectBypage(u_id, page);
	ArrayList<Movie_order> list = mod.selectBypage(u_id, page);
	HashMap<Integer, ArrayList> map1 = new HashMap<Integer, ArrayList>();
	map1.put(1, list1);
	map1.put(2, list);
	System.out.println(map1.get(1).size()+"--------------------------");
	if(map1.get(1).size()==0 && map1.get(2).size()==0){
		response.getWriter().print("数据全部加载完成");
	}else{
		
		Gson gson = new Gson();
		String json = gson.toJson(map1);
		/*
		 * String json1=gson.toJson(list1); String json=gson.toJson(list);
		 */
		// response.getWriter().print(json1);
		response.getWriter().print(json);
	}
	
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doGet(request, response);
    }

}
