package com.HiWeek.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Dao.daoHelper.MerchantDaoHelper;

@WebServlet(name = "ChangePwd", urlPatterns = "/servlet/ChangePwd")
public class ChangePwd extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MerchantDaoHelper mDaoHelper = new MerchantDaoHelper();
		PrintWriter out = response.getWriter();
		int mer_id = Integer.parseInt(request.getParameter("mer_id"));
		String pwd = request.getParameter("pwd");
		System.out.println(mer_id+"   "+pwd);
		int i = mDaoHelper.updatePwd(mer_id, pwd);
		if (i <= 0) {
			out.println("修改失败！");
		} else {
			out.println("修改成功！");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
