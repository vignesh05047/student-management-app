package com.dcl.servlet;

import java.io.IOException;

import com.dcl.dto.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		System.out.println(req.getRequestedSessionId());
		Student s=(Student)session.getAttribute("student");
		if(s!=null) {
			session.invalidate();
			req.setAttribute("success-msg", "Logout successful!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("error-message", "Session expired!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
