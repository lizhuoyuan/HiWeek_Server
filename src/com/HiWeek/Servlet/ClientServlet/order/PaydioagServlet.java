package com.HiWeek.Servlet.ClientServlet.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Dao.daoHelper.UserDaoHelper;
import com.HiWeek.Dao.daoImpl.Action_orderImpl;
import com.HiWeek.Dao.daoImpl.Movie_orderDaoImpl;

@WebServlet(name = "PaydioagServlet", urlPatterns = "/servlet/PaydioagServlet")
public class PaydioagServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws ServletException, IOException {
	int i = 0;
	int id = Integer.parseInt(req.getParameter("id"));
	int sign = Integer.parseInt(req.getParameter("sign"));
	int u_id = Integer.parseInt(req.getParameter("u_id"));
	System.out.println("------------------" + req.getParameter("useprice"));
	double useprice = Double.parseDouble(req.getParameter("useprice"));
	int newcredit = Integer.parseInt(req.getParameter("newcredit"));
	double newyue = Double.parseDouble(req.getParameter("newyue"));
	switch (sign) {
	case 4:
	    Action_orderImpl aoi = new Action_orderImpl();
	    i = aoi.updateAction_orderState(id);
	    break;
	case 5:
	    System.out.println("mo_id" + id);
	    Movie_orderDaoImpl moi = new Movie_orderDaoImpl();
	    i = moi.updataMovie_orderState(id);
	    break;
	default:
	    break;
	}
	// 更改用户积分和余额信息
	UserDaoHelper ud = new UserDaoHelper();
	ud.updateUserByID(u_id, newcredit + (int) useprice, newyue - useprice);
	res.getWriter().print(i);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doGet(request, response);
    }

}
