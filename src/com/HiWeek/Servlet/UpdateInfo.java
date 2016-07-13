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

@WebServlet(name = "UpdateInfo", urlPatterns = "/servlet/UpdateInfo")
public class UpdateInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("更新。。。。。。。");
		MerchantDaoHelper mDaoHelper = new MerchantDaoHelper();
		TypeDaoHelper tDaoHelper = new TypeDaoHelper();
		int mer_id = Integer.parseInt(request.getParameter("mer_id"));
		String mer_name = request.getParameter("mer_name");
		String mer_address = request.getParameter("mer_address");
		String mer_tel = request.getParameter("mer_tel");
		String mer_introduce = request.getParameter("mer_introduce");
		Type type = tDaoHelper.selectTypeByID(Integer.parseInt(request
				.getParameter("type_id")));
		Merchant merchant = new Merchant(mer_id, mer_name, mer_address,
				mer_tel, mer_introduce, type);
		int i = mDaoHelper.updateMerchant(merchant);
		if (i <= 0) {
			response.getWriter().println("更新失败！");
			System.out.println("更新失败！");
		} else {

			response.getWriter().println("更新成功！");
			System.out.println("更新成功！");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
