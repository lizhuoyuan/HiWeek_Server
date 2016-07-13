package com.HiWeek.Servlet.ClientServlet.activity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Quiz;
import com.HiWeek.Dao.daoImpl.QuizImpl;
import com.HiWeek.Dao.daoInterface.QuizDao;
import com.google.gson.Gson;

/**
 * @author 李卓原 创建时间：2015-10-21 下午11:51:28
 * 
 */
@WebServlet(name = "SelectMyQuestion", urlPatterns = { "/servlet/SelectMyQuestion" })
public class SelectMyQuestion extends HttpServlet {
	QuizDao qz;
	

	public SelectMyQuestion() {
		qz = new QuizImpl();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int a_id = Integer.parseInt(request.getParameter("a_id"));
		// int u_id = Integer.parseInt(request.getParameter("u_id"));
		ArrayList<Quiz> quiz = qz.SelectMyQuestion(a_id);
		System.out.println(quiz);

		// 将数据转换成gson数据
		Gson gson = new Gson();
		String acString = gson.toJson(quiz);
		PrintWriter pw = response.getWriter();
		if (acString == null) {
			pw.write("");
		} else {
			pw.write(acString);
		}
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
