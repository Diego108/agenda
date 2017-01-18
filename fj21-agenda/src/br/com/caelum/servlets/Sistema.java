package br.com.caelum.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sistema extends HttpServlet{

	    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	    	
	    	PrintWriter writer = resp.getWriter();
	    	
	    	writer.println("<html>"
	    			+ 	   "<body>"
	    			+ 	   "<h1>Olá mundo !</h1>"
	    			+ 	   "</body>"
	    			+ 	   "</html>");
	    }

}
