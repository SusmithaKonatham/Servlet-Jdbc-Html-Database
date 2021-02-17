package org.jsp.app;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/Support")
public class Support extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException
	{
		String name=req.getParameter("nm");
		 String DescribeIssue=req.getParameter("des");
		JDBCcodee.supp (name,DescribeIssue);

	}

}
