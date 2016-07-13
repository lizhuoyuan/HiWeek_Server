package com.HiWeek.Servlet.ClientServlet.activity;

import com.HiWeek.Dao.daoImpl.QuizImpl;
import com.HiWeek.Dao.daoInterface.QuizDao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 李卓原 创建时间：2015-10-21 下午5:54:57
 * 
 */
@WebServlet(name = "UploadQuiz", urlPatterns = { "/servlet/UploadQuiz" })
public class UploadQuiz extends HttpServlet {
    QuizDao qz;

    public UploadQuiz() {
	qz = new QuizImpl();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String q_time = request.getParameter("q_time");
	String u_name = request.getParameter("u_name");
	String q_cont = request.getParameter("q_cont");
	String a_itemname = request.getParameter("a_itemname");
	int a_id = Integer.parseInt(request.getParameter("a_id"));
	int u_id = Integer.parseInt(request.getParameter("u_id"));

	// 插入数据
	String str = "(" + "'" + q_time + "'" + ","
		+ "'" + q_cont + "'" + "," + "'" + a_itemname + "'" + ","
		+ a_id + "," + u_id + ")";
	System.out.println(str);
	qz.insertQuiz(str);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
    }
}
