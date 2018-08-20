package com.zycusBank.bank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BankDo
 */
@WebServlet(description = "Handles all bank related calls", urlPatterns = { "/bank.do" })
public class BankDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankDoServlet() {
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
		
		/*System.out.println(request.getParameter("action"));
		System.out.println(request.getParameter("bankCode"));
		System.out.println(request.getParameter("bankName"));*/
		String action = request.getParameter("action");
		
		System.out.println("ACTION CALLED : "+ action);
		
		switch(action){
			case "addBank": if(addBank(request.getParameter("bankCode"), request.getParameter("bankName"))) {
								response.setStatus(HttpServletResponse.SC_OK);
								return;
							}		
								
							else {
								response.setStatus(HttpServletResponse.SC_FORBIDDEN);
								return;
							}
			
			default		  : System.out.println("Action Can not be Handled");
							response.setStatus(HttpServletResponse.SC_FORBIDDEN);
							return; 		
		}
		
	}
	
	
	private boolean addBank(String bankCode,String bankName) {
		BankDAO bankD = new BankDAO();
		return(bankD.create(new Bank(bankCode,bankName)));
	}

}
