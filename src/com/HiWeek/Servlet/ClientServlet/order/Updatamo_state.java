package com.HiWeek.Servlet.ClientServlet.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Dao.daoImpl.CinemaDaoImpl;
import com.HiWeek.Dao.daoImpl.Movie_orderDaoImpl;

/**
 * 更改电影订单状态为3
 * 
 * @author 郑雅倩
 *
 */
@WebServlet(name = "Updatamo_state", urlPatterns = "/servlet/client/Updatamo_state")
public class Updatamo_state extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// 更改状态
	int mo_id = Integer.parseInt(request.getParameter("mo_id"));
	Movie_orderDaoImpl moi = new Movie_orderDaoImpl();
	int i = moi.updataMovie_orderState3(mo_id);

	// 修改分数
	double c_grade = Double.parseDouble(request.getParameter("c_grade"));
	int c_id = Integer.parseInt(request.getParameter("c_id"));
	CinemaDaoImpl cdi = new CinemaDaoImpl();
	int j = cdi.updategrade(c_id, c_grade);

	response.getWriter().print(i);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	doGet(request, response);
    }

}
