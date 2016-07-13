package com.HiWeek.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Merchant;
import com.HiWeek.Bean.Type;
import com.HiWeek.Dao.daoHelper.MerchantDaoHelper;
import com.HiWeek.Dao.daoHelper.TypeDaoHelper;

@WebServlet(name = "MerRegister", urlPatterns = "/servlet/MerRegister")
public class MerRegister extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("///////////////////");
		MerchantDaoHelper mDaoHelper = new MerchantDaoHelper();
		TypeDaoHelper tDaoHelper = new TypeDaoHelper();
		PrintWriter out = response.getWriter();
		String mer_name = request.getParameter("mer_name");
		String mer_tel = request.getParameter("mer_tel");
		String mer_password = request.getParameter("mer_pwd");
		int t_id = Integer.parseInt(request.getParameter("t_id"));
		Type type = tDaoHelper.selectTypeByID(t_id);
		Merchant merchant = new Merchant(mer_name, mer_tel, mer_password, type);

		int i = mDaoHelper.insertMerchant(merchant);
		System.out.println("i:"+i);
		if (i <= 0) {
			out.println("0");
		} else {
			System.out.println("..............");
			out.println("1");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
