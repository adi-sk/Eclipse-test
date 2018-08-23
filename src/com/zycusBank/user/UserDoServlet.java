package com.zycusBank.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zycusBank.enums.Role;

/**
 * Servlet implementation class UserDoServlet
 */
@WebServlet("/user.do")
public class UserDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDAO userD = new UserDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDoServlet() {
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
		// TODO Auto-generated method stub

		String action = request.getParameter("action");

		String time = String.valueOf(System.nanoTime() % 1000000);

		switch (action) {
		case "getCurrentTime":
			response.setContentType("text/plain");
			response.getWriter().write(String.valueOf(System.nanoTime() % 1000000));
			response.setStatus(HttpServletResponse.SC_OK);

			break;

		case "assignUser":
			if (assignUser(request)) {
				response.setStatus(HttpServletResponse.SC_OK);
				return;
			} else {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return;
			}

		default:
			System.out.println("Action can not be handled");
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;

		}

	}

	private boolean assignUser(HttpServletRequest request) {

		Role role = Role.valueOf(request.getParameter("role"));

		if (userD.assignUser(request.getParameter("id"), role, request.getParameter("bankCode"),
				request.getParameter("branchCode"))) {
			return true;
		}
		return false;
	}

}
