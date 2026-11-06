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
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDAO sdao=new StudentDAOImpl();
		Student s=sdao.getStudentByEmail(req.getParameter("email"));
		
		if(s!=null) {
			if(s.getPassword().equals(req.getParameter("password"))) {
				//resp.getWriter().println("Login succesful!, Welcome "+s.getName());
				
				
				//CREATION OF SESSION OBJ
				HttpSession session=req.getSession();
				session.setAttribute("student", s);
				req.setAttribute("success-message", "Login successful!");
				req.getRequestDispatcher("dashboard.jsp").forward(req, resp); //we are using RequestDispatcher just to send success-msg, not the student
			}
			else {
				req.setAttribute("error-message", "Invalid Password!");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		}
		else {
			req.setAttribute("error-message", "User Not Found!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
		
	}
}
