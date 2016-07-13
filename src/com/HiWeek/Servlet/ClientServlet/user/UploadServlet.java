package com.HiWeek.Servlet.ClientServlet.user;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.HiWeek.Dao.daoHelper.UserDaoHelper;

/**
 * 用户头像上传 修改用户资料数据
 * 
 * @author 李卓原 创建时间：2015-11-2 上午10:50:28
 */
@WebServlet(name = "UploadServlet", urlPatterns = { "/servlet/UploadServlet" })
public class UploadServlet extends HttpServlet {
    private static String fieldValue;
    String fileName, u_name, u_sex;
    int u_id, u_paynum;
    ArrayList<String> user;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	System.out.println("......................");
	user = new ArrayList<>();
	// 1、创建文件上传的工厂类实例对象
	DiskFileItemFactory factory = new DiskFileItemFactory();
	// 2、创建文件上传的ServletFileUpload实例对象
	ServletFileUpload upload = new ServletFileUpload(factory);
	// 3、利用ServletFileUpload实例对象解析Request对象中有关文件上传的内容
	try {
	    List<FileItem> items = upload.parseRequest(request);
	    // 解析文件上传的List集合（直接遍历），得到有关文件上传的所有内容（普通字段和上传文件内容）
	    for (FileItem fileItem : items) {

		/*
		 * 如果可以知道当前的FileItem是普通项还是文件项 *
		 * 通过FileItem.isFormFiled()方法判断当前是普通项还是文件项 * 结果是true的话，表示当前是普通项
		 * * 结果是false的话，表示当前是文件项
		 */

		if (fileItem.isFormField()) {
		    // * 普通项
		    // * *getFieldName()方法：获取普通项的name属性值。
		    // * *getString()方法：获取普通项的文本内容。

		    String fieldName = fileItem.getFieldName();
		    fieldValue = fileItem.getString();
		    user.add(fieldValue);
		    System.out.println(fieldName + "---" + fieldValue);

		} else {
		    // * 文件项
		    // * *getName()方法：获取文件项的上传文件名称。
		    // * *getInputStream()方法：获取文件项的上传文件输入流。
		    fileName = fileItem.getName();
		    System.out.println("fileName:" + fileName);
		    InputStream in = fileItem.getInputStream();
		    String realPath = getServletContext().getRealPath("/Image");
		    OutputStream out = new FileOutputStream(new File(realPath,
			    fileName));
		    IOUtils.copy(in, out);
		    in.close();
		    out.close();
		    response.getWriter().write("照片上传成功！");
		}
	    }
	} catch (FileUploadException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	UserDaoHelper ud = new UserDaoHelper();
	String u_pic = fileName;
	u_id = Integer.parseInt(user.get(0));
	u_sex = user.get(1);
	u_name = user.get(2);
	u_paynum = Integer.parseInt(user.get(3));
	int i = ud.updateUser(u_id, u_sex, u_name, u_pic, u_paynum);
	System.out.println(i);
    }
}
