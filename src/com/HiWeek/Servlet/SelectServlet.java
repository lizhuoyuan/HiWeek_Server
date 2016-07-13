package com.HiWeek.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Utils.SelectUtil;
@WebServlet(name = "SelectServlet", urlPatterns = "/servlet/SelectServlet")
public class SelectServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String provence = request.getParameter("provence");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		// 若provence为空则说明是第一次请求或选择了默认
		if ("".equals(provence)) {
			// 返回省份
			// response.getWriter().write(s);
			response.getWriter().println(
					SelectUtil.getInstance().getProvences());
		} else if ("".equals(city)) {
			response.getWriter().println(
					SelectUtil.getInstance().getCity(provence));
		} else if ("".equals(country)) {
			response.getWriter().println(
					SelectUtil.getInstance().getCountry(provence, city));
		}else {
			response.getWriter().println(
					"您选择的地址是"+provence+city+country);
		
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
