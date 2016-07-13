package com.HiWeek.Servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.HiWeek.Dao.daoHelper.ActionDaoHelper;

@WebServlet(name = "AImageServlet", urlPatterns = "/servlet/AImageServlet")
@MultipartConfig
public class AImageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionDaoHelper aDaoHelper = new ActionDaoHelper();
		PrintWriter out = response.getWriter();
		int mer_id = 16;
		String storePath = request.getServletContext().getRealPath(
				"/ActionPhotos");
		File dirfile = new File(storePath, mer_id + "");
		if (!dirfile.exists()) {

			dirfile.mkdirs();
		}
		Part part = request.getPart("a_photo");
		// 获取请求头
		String header = part.getHeader("content-disposition");
		// 获取文件名
		String fileName = System.currentTimeMillis()
				+ header.substring(header.lastIndexOf("=") + 2,
						header.length() - 1);
		int i = aDaoHelper.updateforImage(mer_id, fileName);
		if (i > 0) {
			out.println("发布成功");
		} else {
			out.println("发布失败");

		}

		// 写
		part.write(dirfile.getPath() + File.separator + fileName);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
