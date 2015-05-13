package com.student.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WriteDocAction extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException,IOException
	{
		response.setContentType("application/msword");
		PrintWriter pw = response.getWriter();
		HttpSession session = req.getSession();
		String s2 = (String)req.getParameter("s2");
		System.out.println(" s2 data is:"+s2);
		pw.print(s2);
		pw.close();
	}
}