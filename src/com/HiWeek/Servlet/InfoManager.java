package com.HiWeek.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Merchant;
import com.HiWeek.Dao.daoHelper.MerchantDaoHelper;

@WebServlet(name = "InfoManager", urlPatterns = "/servlet/InfoManager")
public class InfoManager extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("laile..");
		MerchantDaoHelper mDaoHelper = new MerchantDaoHelper();
		String tel = request.getSession().getAttribute("user").toString();
		Merchant merchant = mDaoHelper.selectMerchantByTel(tel);
		request.getSession().setAttribute("merchantInfo", merchant);
		System.out.println(merchant.getMer_name());
		response.sendRedirect("../Merchant/InfoManager.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
