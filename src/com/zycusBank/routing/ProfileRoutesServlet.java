package com.zycusBank.routing;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileRoutesServlet
 */
@WebServlet("/profile/*")
public class ProfileRoutesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileRoutesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		// TODO Auto-generated method stub
		if ((session == null) || (session.getAttribute("user") == null)) {
			response.sendRedirect(request.getContextPath() + "/login.html");
		} else {
			System.out.println("login Successful");

			switch (request.getPathInfo()) {

			case "/home":
				request.getRequestDispatcher("/user/home.jsp").forward(request, response);
				return;

			case "/banks":
				request.getRequestDispatcher("/user/addBank.jsp").forward(request, response);
				return;

			case "/branches":
				request.getRequestDispatcher("/user/addBranch.jsp").forward(request, response);
				return;

			case "/users":
				request.getRequestDispatcher("/user/allUsers.jsp").forward(request, response);
				return;

			case "/assignUser":
				request.getRequestDispatcher("/user/assignUser.jsp").forward(request, response);
				return;

			case "/userRegistration":
				request.getRequestDispatcher("/user/register.jsp").forward(request, response);
				return;

			case "/accounts":
				request.getRequestDispatcher("/user/myAccounts.jsp").forward(request, response);
				return;

			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
