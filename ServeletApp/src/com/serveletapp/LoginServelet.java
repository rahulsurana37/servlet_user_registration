package com.serveletapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.regex.*;

//@WebServlet("/loginservlet")
public class LoginServelet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_name = "rahul";
		//String password = "luhar";
		String username = req.getParameter("username");
		String pass = req.getParameter("Pass");
		String firstname= req.getParameter("first_name");
		
		final String pass_match="^([a-zA-Z0-9]*)[^a-zA-Z0-9_]([a-zA-Z0-9]*)$";
		final String first_name_match="^[A-Z]{1}+[A-Za-z]{2,}$";
		
		//password
		Pattern ppat = Pattern.compile(pass_match);
		Matcher pmat = ppat.matcher(pass);
		boolean pvalid = pmat.matches();
		
		//first_name
		Pattern pat = Pattern.compile(first_name_match);
		Matcher mat = pat.matcher(firstname);
		boolean valid = mat.matches();
		
		PrintWriter out = resp.getWriter();
		if (pvalid == true && username.equals(user_name) && valid == true) {
			String htmlresponse = "<html>";
			htmlresponse+="<h1>username is:" +username+"</h1>";
			htmlresponse+="<h1>Login Success"+"</h1>";
			htmlresponse+="<h1>Valid First Name: "+firstname+"</h1>";
			htmlresponse+="</html>";
			out.println(htmlresponse);	
		}
		else {
			String errorresponse = "<html>";
			errorresponse+="<h1>username is:" +username+"</h1>";
			errorresponse+="<h1>Login failed"+"</h1>";
			errorresponse+="<h1>Invalid First Name: "+firstname+"</h1>";
			errorresponse+="</html>";
			out.println(errorresponse);	
		}
			
		System.out.println("Username is " +username);
		System.out.println("Password is " +pass);
		
		
	}

}
