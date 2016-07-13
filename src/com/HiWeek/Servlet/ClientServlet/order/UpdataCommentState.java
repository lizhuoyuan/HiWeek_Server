package com.HiWeek.Servlet.ClientServlet.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdataCommentState", urlPatterns = "/servlet/UpdataCommentState")
public class UpdataCommentState extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// 更改状态
	// int mo_id = Integer.parseInt(request.getParameter("mo_id"));
	// Movie_orderDaoImpl moi = new Movie_orderDaoImpl();
	// int i = moi.updataMovie_orderState3(mo_id);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// doGet(request, response);
    }

}
