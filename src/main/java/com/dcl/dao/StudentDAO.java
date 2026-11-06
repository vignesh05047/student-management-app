package com.dcl.dao;

import java.util.List;

import com.dcl.dto.Student;

public interface StudentDAO {

	public void insertStudent(Student s);
	
	public void updateStudent(Student s);
	
	public void deleteStudent(Integer id);
	
	public Student getStudentById(Integer id);
	
	public Student getStudentByEmail(String email);
	
	public List<Student> getAllStudent();
}
