package com.HiWeek.Servlet.ClientServlet.movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HiWeek.Bean.Discuss;
import com.HiWeek.Dao.daoHelper.CommentDaoHelper;
import com.HiWeek.Dao.daoImpl.CommentDaoImpl;
import com.google.gson.Gson;

/**
 * 
 * @ClassName: MovieComment
 * @Description: 电影评论的servlet,post为上传评论，get为获取评论，<br>
 *               获取评论需提供电影ID,page,page属性不存在时为显示两条 返回null为没有评论<br>
 *               上传时需提供与服务器相同的电影评论表的实体类，方便解析
 * @author: XU
 * @date: 2015年10月26日 上午11:01:45
 */
@WebServlet(name = "MovieComment", urlPatterns = { "/servlet/client/MovieComment" })
public class MovieComment extends HttpServlet {
    private ArrayList<Discuss> comments;
    CommentDaoHelper commentHelper;
    Gson gson;
    CommentDaoImpl commentDaoImpl;

    public MovieComment() {
	commentHelper = new CommentDaoHelper();
	gson = new Gson();
	comments = new ArrayList<Discuss>();
	commentDaoImpl = new CommentDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {

	String movie_id = req.getParameter("Movie_ID");
	System.out.println("movie_id:" + movie_id);
	String page = req.getParameter("page");
	if (page == "" || page == null) {
	    comments = commentHelper.selectComments(Integer.parseInt(movie_id));
	} else {
	    comments = commentHelper.selectComments(Integer.parseInt(movie_id),
		    Integer.parseInt(page));
	}
	System.out.println(comments.size());
	String jsonString = gson.toJson(comments);
	resp.getWriter().println(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		req.getInputStream()));
	String buffString;
	StringBuilder sb = new StringBuilder();
	while ((buffString = reader.readLine()) != null) {
	    sb.append(buffString);
	}
	reader.close();
	String json = URLDecoder.decode(sb.toString(), "utf-8");
	System.out.println(sb.toString());
	Discuss discuss = gson.fromJson(json, Discuss.class);
	commentDaoImpl.insertComment(discuss);
    }
}
