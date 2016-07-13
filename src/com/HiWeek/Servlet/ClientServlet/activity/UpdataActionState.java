package com.HiWeek.Servlet.ClientServlet.activity;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Action_order;
import com.HiWeek.Dao.daoHelper.UserDaoHelper;
import com.HiWeek.Dao.daoImpl.Action_orderImpl;
import com.google.gson.Gson;
/**
 * 
 * @author 郑雅倩
 *
 */
@WebServlet(name = "UpdataActionState", urlPatterns = { "/servlet/client/UpdataActionState" })
public class UpdataActionState extends HttpServlet {

	public UpdataActionState() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String json = request.getParameter("ao1");
		json = URLDecoder.decode(json, "utf-8");
		Gson gson = new Gson();
		Action_order ao1 = gson.fromJson(json, Action_order.class);
		// 改变订单的状态
		int ao_id = ao1.getAo_id();
		Action_orderImpl aoi = new Action_orderImpl();
		int i=aoi.updateAction_orderState(ao_id);

		// 更新user信息
        int u_id=ao1.getUser().getU_id();
        int u_credit=(int) (ao1.getUser().getU_credit()+ao1.getAo_price());
        System.out.println("ao1.getUser().getU_credit()="+ao1.getUser().getU_credit());
        
        double u_yue=ao1.getUser().getU_yue()-ao1.getAo_price();
        UserDaoHelper ud = new UserDaoHelper();
        ud.updateUserByID(u_id, u_credit, u_yue);
        response.getWriter().print(i);
	}

}
