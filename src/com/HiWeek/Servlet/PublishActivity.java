package com.HiWeek.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Action;
import com.HiWeek.Bean.Merchant;
import com.HiWeek.Bean.Type;
import com.HiWeek.Dao.daoHelper.ActionDaoHelper;
import com.HiWeek.Dao.daoHelper.MerchantDaoHelper;
import com.HiWeek.Dao.daoHelper.TypeDaoHelper;

@WebServlet(name = "PublishActivity", urlPatterns = "/servlet/PublishActivity")
public class PublishActivity extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		MerchantDaoHelper mDaoHelper = new MerchantDaoHelper();
//		TypeDaoHelper tDaoHelper = new TypeDaoHelper();
//		ActionDaoHelper aDaoHelper = new ActionDaoHelper();
		PrintWriter out = response.getWriter();
//		// a_itemname, a_price, a_stime, a_etime,a_introduce,
//		// a_consult, a_joinex, a_FAQ,a_charge ,t_id,a_address
//		int mer_id = 16;
//		String a_itemname = request.getParameter("a_itemname");
//		double a_price = Double.parseDouble(request.getParameter("a_price"));
//		String a_stime = request.getParameter("a_stime");
//		String a_etime = request.getParameter("a_etime");
//		String a_introduce = request.getParameter("a_introduce");
//		String a_consult = request.getParameter("a_consult");
//		String a_joinex = request.getParameter("a_joinex");
//		String a_FAQ = request.getParameter("a_FAQ");
//		String a_charge = request.getParameter("a_charge");
//		String a_address = request.getParameter("a_address");
//		int t_id = Integer.parseInt(request.getParameter("t_id"));
//		Merchant merchant = mDaoHelper.selectMerchantByID(mer_id);
//		Type type = tDaoHelper.selectTypeByID(t_id);
//		Action action = new Action(a_itemname, a_price, a_introduce, a_consult,
//				a_FAQ, a_joinex, a_charge, a_stime, a_etime, a_address,
//				merchant, type);
//		int i = aDaoHelper.insertAction(action);
		int i = 1;
		if (i <= 0) {
			out.println(0);
		} else {
			out.println(1);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
