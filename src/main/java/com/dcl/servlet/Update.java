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

@WebServlet("/update")
public class Update extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDAO sdao=new StudentDAOImpl();
		HttpSession session=req.getSession();
		Student sessionStudent=(Student)session.getAttribute("student");
		Student s=sdao.getStudentById(Integer.parseInt(req.getParameter("id")));
		
		if(s!=null&&s.getId()==sessionStudent.getId()) {
			sessionStudent.setName(req.getParameter("name"));
			sessionStudent.setPhone(req.getParameter("phone"));
			sessionStudent.setEmail(req.getParameter("email"));
			sdao.updateStudent(sessionStudent);
			req.setAttribute("success-message", "Student Updated successfully!");
			req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("error-message", "Invalid Student Info!, Kindly login");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
