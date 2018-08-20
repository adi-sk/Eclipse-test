package com.zycusBank.bank;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BranchDoServlet
 */
@WebServlet("/branch.do")
public class BranchDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BranchDoServlet() {
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

		System.out.println(request.getParameter("bankCode"));
		System.out.println(request.getParameter("branchCode"));
		System.out.println(request.getParameter("branchName"));

		System.out.println("ACTION CALLED : " + action);

		switch (action) {
		case "addBranch":
			if (addBranch(request.getParameter("bankCode"), request.getParameter("branchCode"),
					request.getParameter("branchName"))) {
				response.setStatus(HttpServletResponse.SC_OK);
				return;
			}

			else {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return;
			}

		default:
			System.out.println("Action Can not be Handled");
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
		}
	}

	private boolean addBranch(String bankCode, String branchCode, String branchName) {
		BranchDAO branchD = new BranchDAO();
		return (branchD.create(new Branch(branchCode, bankCode, branchName)));
	}

}
