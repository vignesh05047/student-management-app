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

@WebServlet("/delete")
public class Delete extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Student admin = (Student) session.getAttribute("student");

		// Only the admin (id = 1) is allowed to delete students
		if (admin != null && admin.getId() == 1) {
			StudentDAO sdao = new StudentDAOImpl();
			int id = Integer.parseInt(req.getParameter("id"));
			// The admin account itself cannot be deleted
			if (id != 1) {
				sdao.deleteStudent(id);
			}
			resp.sendRedirect("viewStudents.jsp");
		} else {
			req.setAttribute("error-message", "Session expired!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
