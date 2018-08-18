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

import com.zycusBank.user.User;
import com.zycusBank.user.UserDAO;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get request parameters for userID and password
		String userId = request.getParameter("user");
		String pwd = request.getParameter("pwd");

		UserDAO userD = new UserDAO();

		// fetching required user using userId
		User user = userD.findById(userId);
		
		if ( user != null && user.getId().equals(userId) && user.getPass().equals(HashIt.generateHash(pwd))) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			// setting session to expiry in 10 mins
			session.setMaxInactiveInterval(2 * 60);
			Cookie userName = new Cookie("user", user.getId());
			userName.setMaxAge(2 * 60);
			response.addCookie(userName);
			response.sendRedirect("user/home.jsp");
			} 
	
		
		else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}

	}

}
