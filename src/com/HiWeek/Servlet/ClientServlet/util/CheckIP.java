package com.HiWeek.Servlet.ClientServlet.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CheckIP", urlPatterns = { "/servlet/client/CheckIP" })
public class CheckIP extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	resp.getWriter().println("OK");
	System.out.println("OK");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(req, resp);
    }

}
