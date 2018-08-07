package com.zycusBank.aditya;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zycusBank.customer.Customer;
import com.zycusBank.customer.CustomerDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			// get request parameters for userID and password
			String user = request.getParameter("user");
			String pwd = request.getParameter("pwd");
			
			CustomerDAO customerD = new CustomerDAO();
			
			//fetching required customer using userId
			Customer customer = customerD.findById(user);
			
			
			if(customer.getId().equals(user) && customer.getPass().equals(HashIt.generateHash(pwd))){
				HttpSession session = request.getSession();
				session.setAttribute("user", customer);
				//setting session to expiry in 10 mins
				session.setMaxInactiveInterval(10*60);
				Cookie userName = new Cookie("user", customer.getId());
				userName.setMaxAge(30*60);
				response.addCookie(userName);
				response.sendRedirect("home.html");
			}else{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
				PrintWriter out= response.getWriter();
				out.println("<font color=red>Either user name or password is wrong.</font>");
				rd.include(request, response);
			}

		
	
	}

}
