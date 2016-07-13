package com.HiWeek.Servlet.ClientServlet.activity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 李卓原 创建时间：2015-10-20 上午11:54:38
 * 
 */
@WebServlet(name = "ActionOrderup", urlPatterns = { "/servlet/ActionOrderup" })
public class ActionOrderup extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public ActionOrderup() {
	super();
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
	String a_name = request.getParameter("a_name");
	System.out.println(a_name + "------");
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
