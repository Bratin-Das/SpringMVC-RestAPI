package com.NoobCoders.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.NoobCoders.service.GreetingService;

@WebServlet(urlPatterns = "/greet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1.Read inputs from the requests
		String name = req.getParameter("name");
		
		
		//2.invoke a model method to get aa model 
		GreetingService service = new GreetingService();
		String message = service.getMessage(name);
		
		
		
		//3.store the model in a scope accessible to the view
		req.setAttribute("message", message);
		
		
		//4.forward the request to the view
		req.getRequestDispatcher("/WEB-INF/pages/greet.jsp").forward(req, resp);
	}
	
	
}
