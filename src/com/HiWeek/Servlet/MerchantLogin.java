package com.HiWeek.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.HiWeek.Bean.Merchant;
import com.HiWeek.Dao.daoHelper.MerchantDaoHelper;

@WebServlet(name = "MerchantLogin", urlPatterns = "/servlet/MerchantLogin")
public class MerchantLogin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		MerchantDaoHelper mDaoHelper = new MerchantDaoHelper();
		HttpSession session = request.getSession();
		String tel = request.getParameter("tel");
		String pwd = request.getParameter("pwd");
		Merchant merchant = mDaoHelper.selectMerchantByTel(tel);
		if (merchant == null) {
			out.println(0);
		} else {
			String topwd = merchant.getMer_password();
			if (pwd.equals(topwd)) {
				out.println(1);
				session.setAttribute("userlogin", true);
				session.setAttribute("user", tel);
			} else {
				out.println(0);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
