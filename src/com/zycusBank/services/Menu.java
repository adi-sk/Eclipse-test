package com.zycusBank.services;

public class Menu {
	public static String printMenu(int role) {

		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("<ul class=\"navbar-nav mr-auto\">");
		
		stringBuilder.append("<li class=\"nav-item\">"
				+ "<a class=\"nav-link\" href=\"../profile/home\" id=\"home\">Home</a>" + "</li>"

		);
		if (role >= 2) {
			stringBuilder.append("<li class=\"nav-item\">"
					+ "<a class=\"nav-link\" href=\"../profile/banks\" id=\"banks\">Banks</a>" + "</li>"

			);
		}

		if (role >= 1) {
			stringBuilder.append("<li class=\"nav-item\">"
					+ "<a class=\"nav-link\" href=\"../profile/branches\" id=\"branches\">Branches</a>" + "</li>");

			stringBuilder.append("<li class=\"nav-item\">"
					+ "<a class=\"nav-link\" href=\"../profile/users\" id=\"users\">Users</a>" + "</li>");

			stringBuilder.append("<li class=\"nav-item\">"
					+ "<a class=\"nav-link\" href=\"../profile/assignUser\" id=\"assignUser\">Assign User</a>"
					+ "</li>");

			stringBuilder.append("<li class=\"nav-item\">"
					+ "<a class=\"nav-link\" href=\"../profile/userRegistration\" id=\"userRegistration\">Register User</a>"
					+ "</li>");
		}

		if (role == 0) {
			stringBuilder.append("<li class=\"nav-item\">"
					+ "<a class=\"nav-link\" href=\"../profile/accounts\" id=\"accounts\">My Accounts</a>" + "</li>");
		}
		
		stringBuilder.append("</ul>");
		
		stringBuilder.append("<ul class=\"navbar-nav\">"+
		"<li class=\"nav-item\">"+
			"<a class=\"nav-link\" href=\"../logout.do\" id=\"logout\">logout</a>"+
		"</li>"+
	"</ul>");

		return stringBuilder.toString();

	}
}
