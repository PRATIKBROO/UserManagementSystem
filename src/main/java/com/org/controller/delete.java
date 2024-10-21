package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.userDao;

@WebServlet("/del")
public class delete  extends  HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id =Integer. parseInt( req.getParameter("id"));
		
		userDao dao = new userDao();
		dao.deleteUserById(id);
		
		resp.sendRedirect("home.jsp");
	}
}
