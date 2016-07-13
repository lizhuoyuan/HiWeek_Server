package com.HiWeek.Servlet.ClientServlet.activity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Dao.daoImpl.UserImpl;
import com.HiWeek.Dao.daoInterface.UserDao;

@WebServlet(name = "UserLogin", urlPatterns = { "/servlet/UserLogin" })
public class UserLogin extends HttpServlet {
    /**
     * @author 李卓原 创建时间：${date} ${time}
     * 
     */

    UserDao us;

    public UserLogin() {
	us = new UserImpl();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
	super.destroy(); // Just puts "destroy" string in log
	// Put your code here
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String u_tel = request.getParameter("tel");
	String u_pwd = request.getParameter("pwd");
	System.out.println(u_tel + "," + u_pwd);
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException
     *             if an error occurs
     */
    public void init() throws ServletException {
	// Put your code here
    }

}
