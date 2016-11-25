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
		//�ϴ�������
		String name = request.getParameter("username");
		//ȡ���ļ�
		Part part = request.getPart("filename");
		
		PrintWriter out = response.getWriter();
		out.print("Name:"+name+"\n");
		out.print("ContentType=" + part.getContentType() + "\n");
		DecimalFormat df = new DecimalFormat("######0.00");//������λС��
		double size = part.getSize();//���صĵ�λΪB
		double size_K = size / 1024;//B����KB
		if (size_K < 1024)
			out.print("Size=" + df.format(size_K) + "KB\n");
		else
			out.print("Size=" + df.format(size / 1024 / 1024) + "MB\n");
		
		//���ļ�д�뵽ָ��λ�ã������ͼƬ��д���ˣ������ٴ��ϴ��Ḳ��ԭ����ͼƬ
		part.write("F:\\TestOkHttp\\test.jpg");
	}

}
