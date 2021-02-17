package org.jsp.app;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/login")
public class login extends GenericServlet
{
		@Override
		public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
			// Read userinfo from HTML file
			String phone=req.getParameter("phn");
			String password=req.getParameter("pw");
			JDBCcodee.login(phone,password);
		}	
}
