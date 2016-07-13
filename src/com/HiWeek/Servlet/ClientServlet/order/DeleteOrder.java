package com.HiWeek.Servlet.ClientServlet.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Dao.daoHelper.UserDaoHelper;
import com.HiWeek.Dao.daoImpl.Action_orderImpl;
import com.HiWeek.Dao.daoImpl.Movie_orderDaoImpl;

@WebServlet(name = "DeleteOrder", urlPatterns = "/servlet/client/DeleteOrder")
public class DeleteOrder extends HttpServlet {

    public DeleteOrder() {
	super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	int result = 0;
	Action_orderImpl aoi = new Action_orderImpl();
	Movie_orderDaoImpl moi = new Movie_orderDaoImpl();
	// 更新积分
	int i = Integer.parseInt(request.getParameter("i"));
	System.out.println("kjdsfhoijfdsfoig" + i);
	int u_id = Integer.parseInt(request.getParameter("u_id"));
	System.out.println("kjdsfhoijfdsfoig" + u_id);
	int u_credit = Integer.parseInt(request.getParameter("u_credit"));
	System.out.println("kjdsfhoijfdsfoig" + u_credit);
	int id = Integer.parseInt(request.getParameter("id"));
	System.out.println("kjdsfhoijfdsfoig" + id);
	int sign = Integer.parseInt(request.getParameter("sign"));
	System.out.println("kjdsfhoijfdsfoig" + sign);
	if (i == 0) {
	    UserDaoHelper udi = new UserDaoHelper();
	    udi.updateuesrcredit(u_id, u_credit);
	} else {
	    System.out.println("不是取消");
	}
	// 删除订单

	switch (sign) {
	case 4:
	    result = aoi.deleteAction_orderDao(id);
	    break;
	case 5:
	    result = moi.deleteMovie_order(id);
	    break;
	default:
	    break;
	}
	response.getWriter().print(result);
    }

}
