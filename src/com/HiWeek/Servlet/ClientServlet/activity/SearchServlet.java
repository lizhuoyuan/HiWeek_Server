package com.HiWeek.Servlet.ClientServlet.activity;

import com.HiWeek.Bean.Action;
import com.HiWeek.Dao.daoImpl.ActionImpl;
import com.HiWeek.Dao.daoInterface.ActionDao;
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
 * @author 李卓原 创建时间：2015-10-23 下午8:24:00
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/servlet/SearchServlet"})
public class SearchServlet extends HttpServlet {

    ActionDao ad;

    public SearchServlet() {
        ad = new ActionImpl();
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
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        String search = request.getParameter("search");
        ArrayList<Action> ac = ad.search(search);
        for (Action question : ac) {
            System.out.println(question);
        }
        // 将集合数据转换成gson数据
        Gson gson = new Gson();
        String acString = gson.toJson(ac);
        PrintWriter pw = response.getWriter();
        pw.write(acString);
        pw.close();
        doGet(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
