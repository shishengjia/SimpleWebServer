package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class UpLoadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ")
		// .append(request.getContextPath());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		//上传者姓名
		String name = request.getParameter("username");
		//取出文件
		Part part = request.getPart("filename");
		
		PrintWriter out = response.getWriter();
		out.print("Name:"+name+"\n");
		out.print("ContentType=" + part.getContentType() + "\n");
		DecimalFormat df = new DecimalFormat("######0.00");//保留两位小数
		double size = part.getSize();//返回的单位为B
		double size_K = size / 1024;//B化成KB
		if (size_K < 1024)
			out.print("Size=" + df.format(size_K) + "KB\n");
		else
			out.print("Size=" + df.format(size / 1024 / 1024) + "MB\n");
		
		//将文件写入到指定位置，这里把图片名写死了，所以再次上传会覆盖原来的图片
		part.write("F:\\TestOkHttp\\test.jpg");
	}

}
