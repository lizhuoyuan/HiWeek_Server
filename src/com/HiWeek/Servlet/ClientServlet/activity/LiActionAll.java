package com.HiWeek.Servlet.ClientServlet.activity;

import com.HiWeek.Bean.Action;
import com.HiWeek.Dao.daoHelper.ActionDaoHelper;
import com.HiWeek.Dao.daoImpl.ActionImpl;
import com.HiWeek.Dao.daoInterface.ActionDao;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 活动信息
 * 
 * @author 李卓原 创建时间：2015-10-20 上午11:37:13
 */
@WebServlet(name="LiActionAll",urlPatterns={"/servlet/LiActionAll"})
public class LiActionAll extends HttpServlet {
	ActionDao ad;

	public LiActionAll() {
		ad = new ActionImpl();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * request.setCharacterEncoding("UTF-8")
		 * 
		 * response.setCharacterEncoding("UTF-8") ;
		 * response.setContentType("text/html; charset=UTF-8");
		 */
		// 查询所有活动信息
		String s=request.getParameter("page");
		int page=Integer.parseInt(s);
		System.out.println(page+"--------------");
		ActionDaoHelper aod=new ActionDaoHelper();
		List<Action> actions = aod.selectByPage(page);
		/*System.out.println(actions.size());
		for (Action action : actions) {
			System.out.println(action);
		}*/
		if(actions.size()==0){
			response.getWriter().print("数据加载完成");
		}else{
			// 将集合数据转换成gson数据
			Gson gson = new Gson();
			String acString = gson.toJson(actions);
			PrintWriter pw = response.getWriter();
			pw.write(acString);
			pw.close();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
