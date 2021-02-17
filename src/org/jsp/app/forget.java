package org.jsp.app;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/forget")
public class forget extends GenericServlet
{
	static String phone,newpassword,confirmpassword;

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// Read userinfo from HTML file
		 phone=req.getParameter("num");
		 newpassword=req.getParameter("newpwd");
		 confirmpassword =req.getParameter("conpwd");
		 JDBCcodee.fget();
	}

}
