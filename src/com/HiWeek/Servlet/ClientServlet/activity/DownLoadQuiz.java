package com.HiWeek.Servlet.ClientServlet.activity;

import com.HiWeek.Bean.Quiz;
import com.HiWeek.Dao.daoImpl.QuizImpl;
import com.HiWeek.Dao.daoInterface.QuizDao;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 李卓原 创建时间：2015-10-21 下午8:01:34
 */
@WebServlet(name = "DownLoadQuiz", urlPatterns = {"/servlet/DownLoadQuiz"})
public class DownLoadQuiz extends HttpServlet {

    QuizDao qz;

    public DownLoadQuiz() {
        qz = new QuizImpl();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int a_id = Integer.parseInt(request.getParameter("a_id"));
        ArrayList<Quiz> ques = qz.findQuiz(a_id);
        System.out.println(ques.size());
        for (Quiz question : ques) {
            System.out.println(question);
        }

        // 将集合数据转换成gson数据
        Gson gson = new Gson();
        String acString = gson.toJson(ques);
        //String user = gson.toJson(us);
        PrintWriter pw = response.getWriter();
        pw.write(acString);
        //	pw.write(user);
        pw.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);

    }

}
