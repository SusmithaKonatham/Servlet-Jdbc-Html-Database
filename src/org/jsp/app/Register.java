package org.jsp.app;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/Register")
public class Register extends GenericServlet 
{
	 static String name,phone,email,password,confirmpassword;
		@Override
		public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException
		{
			// Read userinfo from HTML file
			name=req.getParameter("nm");
			phone=req.getParameter("mb");
			email=req.getParameter("id");
			password=req.getParameter("ppwd");
			confirmpassword=req.getParameter("confpwd");
			JDBCcodee.reg();
		}
}
