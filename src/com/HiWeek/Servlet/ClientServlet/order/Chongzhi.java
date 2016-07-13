package com.HiWeek.Servlet.ClientServlet.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.User;
import com.HiWeek.Dao.daoHelper.UserDaoHelper;
/**
 * 充值的servlet
 * 郑雅倩
 */
@WebServlet(name="Chongzhi",urlPatterns="/servlet/client/Chongzhi")
public class Chongzhi extends HttpServlet {

	public Chongzhi() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String u_tel= request.getParameter("newtel");
		int u_paynum=Integer.parseInt(request.getParameter("newmima"));
		double newjine=Double.parseDouble(request.getParameter("newjine"));
		int u_id=Integer.parseInt(request.getParameter("u_id"));
		//double u_yue=newjine+Double.parseDouble(request.getParameter("u_yue"));
		UserDaoHelper ud=new UserDaoHelper();
		User user;
		if ((user =ud.selectUserByU_tel(u_tel)) != null){
			if(user.getU_paynum()==u_paynum){
				ud.updateuesryue(u_id, newjine+user.getU_yue());
				response.getWriter().print("充值成功");
			}else{
				response.getWriter().print("密码不正确");
			}
		}else{
			response.getWriter().print("用户不存在");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
