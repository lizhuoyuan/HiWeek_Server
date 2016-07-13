package com.HiWeek.Servlet.ClientServlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.User;
import com.HiWeek.Dao.daoHelper.UserDaoHelper;
import com.HiWeek.Utils.ClientUtils;
import com.google.gson.Gson;

/**
 * 
 * @ClassName UserRegister
 * @Description 用户注册Servlet,注册成功返回>0,注册失败返回-1，用户已存在返回0；
 * @author Administrator
 * @date 2015年10月15日
 */
@WebServlet(name = "UserRegister", urlPatterns = { "/servlet/client/UserRegister" })
public class UserRegister extends HttpServlet {

    UserDaoHelper uHelper;

    Gson gson;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	uHelper = new UserDaoHelper();
	ClientUtils cUtils = ClientUtils.getInstence();
	gson = new Gson();

	String JSONString = cUtils.read(req.getInputStream());
	System.out.println(JSONString);
	if (JSONString == null || JSONString == "") {
	    resp.getWriter().println("你逗我？");
	    return;
	}

	User user = gson.fromJson(JSONString, User.class);
	System.out.println(user);
	int result = uHelper.registerUser(user);
	System.out.println(user);
	resp.getWriter().println(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	doGet(req, resp);

    }

}
