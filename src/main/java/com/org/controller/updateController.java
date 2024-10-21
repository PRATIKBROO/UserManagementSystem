package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.userDao;
import com.org.dto.user;

@WebServlet("/update")
public class updateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		int id = Integer.parseInt(req.getParameter("id"));

		user user =new user();
		
		user.setName(name);
		user.setAge(age);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setId(id);
		
		userDao dao = new userDao();
		dao.updateUserById(id, user);

		resp.sendRedirect("home.jsp");
	}
}
