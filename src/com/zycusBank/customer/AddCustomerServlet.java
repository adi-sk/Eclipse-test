package com.zycusBank.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zycusBank.aditya.HashIt;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/add-customer.do")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
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
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String title = request.getParameter("title");
		int age = Integer.parseInt(request.getParameter("age"));
		
//		System.out.println(request.getParameter("dob"));
		Date dob = Date.valueOf(request.getParameter("dob"));
		
		
		HashIt hash = new HashIt();
		System.out.println(request.getParameter("password"));
		
		String hashPass = hash.generateHash(request.getParameter("password"));
		System.out.println(hashPass);
		CustomerDAO custD = new CustomerDAO();
		
		if(firstName == null || firstName.equals("") || lastName == null || lastName.equals("") || title == null || title.equals("") || firstName == null){
			
			if(firstName.length() > 2 && lastName.length()>2){
				response.sendRedirect("index.html");
			}
		}
		
		PrintWriter out = response.getWriter();
		custD.create(new Customer(firstName, lastName, title, age, dob),hashPass);		
		out.println("Your account creation request is under process");
	}

}
