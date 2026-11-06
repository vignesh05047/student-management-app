package com.dcl.servlet;

import java.io.IOException;

import com.dcl.dao.StudentDAO;
import com.dcl.dao.StudentDAOImpl;
import com.dcl.dto.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Creating DAO obj
		//Servlet will communicate with DB Logic
		StudentDAO sdao=new StudentDAOImpl();
		//Creating POJO class obj
		Student s=new Student();
		if(req.getParameter("password").equals(req.getParameter("confirm"))) {
			//Data Transferred To Object
			s.setName(req.getParameter("name"));
			s.setPhone(req.getParameter("phone"));
			s.setEmail(req.getParameter("email"));
			s.setPassword(req.getParameter("password"));
			sdao.insertStudent(s);
			
			req.setAttribute("success-msg", "Data added successfully!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		//	resp.getWriter().println("User Registered Successfully!");
		}
		else {
			resp.getWriter().println("Password mismatch!");
		}

	}
}
