package com.zycusBank.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zycusBank.enums.Role;
import com.zycusBank.user.UserDAO;

/**
 * Servlet implementation class AccountDoServlet
 */
@WebServlet("/account.do")
public class AccountDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AccountDAO accountD = new AccountDAO();
	UserDAO userD = new UserDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountDoServlet() {
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

		System.out.println("ACTION   : " + action);

		switch (action) {
		case "addAccount":
			if (addAccount(request)) {
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

	private boolean addAccount(HttpServletRequest request) {

		String type = request.getParameter("accountType");

		System.out.println(type);
		System.out.println("ROLE : " + request.getParameter("role"));
		Role role = Role.valueOf(request.getParameter("role"));

		Account account = new Account(request.getParameter("accountNo"), AccountType.valueOf(type),
				request.getParameter("bankCode"), request.getParameter("branchCode"),
				request.getParameter("customerId"), 1000L, AccountStatus.ACTIVE);

		if (accountD.create(account)) {
			return userD.assignUser(request.getParameter("customerId"), role, request.getParameter("bankCode"),
					request.getParameter("branchCode"));
		}

		return false;

	}

}
