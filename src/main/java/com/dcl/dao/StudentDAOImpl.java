package com.dcl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dcl.dto.Student;
import com.dcl.util.ConnectionFactory;

public class StudentDAOImpl implements StudentDAO {

	private Connection con;
	
	public StudentDAOImpl() {
		this.con=ConnectionFactory.getCon();
	}
	
	@Override
	public void insertStudent(Student s) {
		String query="INSERT INTO STUDENT VALUES (0,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,s.getName());
			ps.setString(2, s.getPhone());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateStudent(Student s) {
		String query="UPDATE STUDENT SET NAME=?, PHONE=?, EMAIL=?, PASSWORD=? WHERE ID=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setString(2, s.getPhone());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getPassword());
			ps.setInt(5, s.getId());
			ps.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public void deleteStudent(Integer id) {
		String query="DELETE FROM STUDENT WHERE ID=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

	}

	@Override
	public Student getStudentById(Integer id) {
		Student s=null;
		String query="SELECT * FROM STUDENT WHERE ID=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id")); 
				s.setName(rs.getString("name"));
				s.setPhone(rs.getString("phone"));
				s.setEmail(rs.getString("email"));
				s.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public Student getStudentByEmail(String email) {
		Student s=null;
		String query="SELECT * FROM STUDENT WHERE EMAIL=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id")); 
				s.setName(rs.getString("name"));
				s.setPhone(rs.getString("phone"));
				s.setEmail(rs.getString("email"));
				s.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> studentList=new ArrayList();
		Student s=null;
		String query="SELECT * FROM STUDENT WHERE ID!=1";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id")); 
				s.setName(rs.getString("name"));
				s.setPhone(rs.getString("phone"));
				s.setEmail(rs.getString("email"));
				s.setPassword(rs.getString("password"));
				studentList.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return studentList;
	}

}
