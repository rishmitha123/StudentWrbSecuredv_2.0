package com.codegnan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.codegnan.beans.Student;
import com.codegnan.exception.InvalidStudentIdException;
import com.codegnan.util.ConnectionHelper;

public class StudentDao extends Dao {
	public boolean save(Student student) throws ClassNotFoundException, SQLException {
		boolean res = false;
		con = ConnectionHelper.getConnection();
		Statement stmt = con.createStatement();
		String sql = "INSERT INTO student values(" + student.getId() + ",'" + student.getName() + "','"
				+ student.getEmail() + "','" + student.getBranch() + "')";
		int noRec = stmt.executeUpdate(sql); // we can pass insert,update and delete commands into this statement
		if (noRec == 1) {
			res = true;
		} else {
			// nothing to do

		}
		return res;
	}

	public boolean delete(int id) throws ClassNotFoundException, SQLException {
		boolean res = false;
		con = ConnectionHelper.getConnection();
		Statement stmt = con.createStatement();
		String sql = "delete from student where id= " + id;
		int noRec = stmt.executeUpdate(sql); // we can pass insert,update and delete commands into this statement
		if (noRec == 1) {
			res = true;
		} else {
			// nothing to do

		}
		return res;

	}

	public boolean edit(Student student) throws ClassNotFoundException, SQLException {
		boolean res = false;
		con = ConnectionHelper.getConnection();
		Statement stmt = con.createStatement();
		String sql = "UPDATE STUDENT SET name = '" + student.getName() + "'," + "email = '" + student.getEmail() + "',"
				+ "branch = '" + student.getBranch() + "'" + "where id  = " + student.getId();
		int noRec = stmt.executeUpdate(sql); // we can pass insert,update and delete commands into this statement
		if (noRec == 1) {
			res = true;
		} else {
			// nothing to do

		}
		return res;

	}

	public Student findById(int id) throws ClassNotFoundException, SQLException, InvalidStudentIdException {
		Student student = null;
		String sql = "select * from student where id= " + id;
		Connection con = ConnectionHelper.getConnection();
		con.commit();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		try {
			if (rs.next()) {
				String name = rs.getString(2);
				String email = rs.getString(3);
				String branch = rs.getString(4);
				student = new Student(id, name, email, branch);

			} else {
				InvalidStudentIdException e = new InvalidStudentIdException("there is no student with this id");
				throw e;
			}
		} finally {
			con.close();
		}
		return student;
	}

	public ArrayList<Student> findAll() throws ClassNotFoundException, SQLException {
		ArrayList<Student> students = new ArrayList<>();
		String sql = "select * from student";
		Connection con = ConnectionHelper.getConnection();
		con.commit();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String email = rs.getString(3);
			String branch = rs.getString(4);
			Student student = new Student(id, name, email, branch);
			students.add(student);

		}
		con.close();
		return students;

	}

}
