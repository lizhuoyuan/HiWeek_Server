package com.HiWeek.Servlet.ClientServlet.movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Movie_order;
import com.HiWeek.Dao.daoHelper.UserDaoHelper;
import com.HiWeek.Dao.daoImpl.Movie_orderDaoImpl;
import com.google.gson.Gson;

/**
 * 修改电影订单的状态和用户的余额和增加积分servlet
 * 
 * @author 郑雅倩
 *
 */
@WebServlet(name = "UpdateState", urlPatterns = { "/servlet/client/UpdateState" })
public class UpdateState extends HttpServlet {

  
    public UpdateState() {
	super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	    doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
       //得到json解析成Movie_order对象
    	String bufferedString;
    	StringBuilder sb = new StringBuilder();
    	BufferedReader reader = new BufferedReader(new InputStreamReader(
    		request.getInputStream()));
    	while ((bufferedString = reader.readLine()) != null) {
    	    sb.append(bufferedString);
    	}
    	String json = URLDecoder.decode(sb.toString(), "utf-8");
    	System.out.println(json);
    	Gson gson = new Gson();
    	Movie_order movie_order = gson.fromJson(json, Movie_order.class);
        //更改订单状态
    	int mo_id=movie_order.getMo_id();
    	System.out.println("mo_id"+mo_id);
    	Movie_orderDaoImpl moi = new Movie_orderDaoImpl();
    	int i = moi.updataMovie_orderState(mo_id);
    	//更改用户积分和余额信息
    	int u_id=movie_order.getUser().getU_id();
    	double u_yue=movie_order.getUser().getU_yue()-movie_order.getMo_price();
    	int u_credit=(int) (movie_order.getMo_price()+movie_order.getUser().getU_credit());
    	UserDaoHelper ud = new UserDaoHelper();
    	ud.updateUserByID(u_id, u_credit, u_yue);
    	response.getWriter().print(i);
    }

}
