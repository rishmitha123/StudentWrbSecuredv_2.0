
package com.codegnan.dao;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.Scanner;

import com.codegnan.beans.Stu_marks;

	import com.codegnan.exception.InvalidStudentIdException;
	import com.codegnan.util.ConnectionHelper;

	public class MarksDao extends Dao{
		public boolean save(Stu_marks stu_marks) throws ClassNotFoundException, SQLException {
			boolean res = false;
			con = ConnectionHelper.getConnection();
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO Stu_marks values(" + stu_marks.getId() + ",'" + stu_marks.getName() + "','"
					+ stu_marks.getSub1() + "','" + stu_marks.getSub2() + "','"+stu_marks.getSub3()+"')";
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
			String sql = "delete from Stu_marks where id= " + id;
			int noRec = stmt.executeUpdate(sql); // we can pass insert,update and delete commands into this statement
			if (noRec == 1) {
				res = true;
			} else {
				// nothing to do

			}
			return res;

		}

		public boolean edit(Stu_marks stu_marks) throws ClassNotFoundException, SQLException {
			boolean res = false;
			con = ConnectionHelper.getConnection();
			Statement stmt = con.createStatement();
			String sql = "UPDATE Stu_marks SET name = '" + stu_marks.getName() + "'," + "sub1 = '" + stu_marks.getSub1() + "',"
					+ "sub2 = '" + stu_marks.getSub2() + "'" + "where id  = " + stu_marks.getId();
			int noRec = stmt.executeUpdate(sql); // we can pass insert,update and delete commands into this statement
			if (noRec == 1) {
				res = true;
			} else {
				// nothing to do

			}
			return res;

		}

		public Stu_marks findById(int id) throws ClassNotFoundException, SQLException, InvalidStudentIdException {
			Stu_marks stu_marks = null;
			String sql = "select * from Stu_marks where id= " + id;
			Connection con = ConnectionHelper.getConnection();
			con.commit();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			try {
				if (rs.next()) {
					String name = rs.getString(2);
					double sub1 = rs.getDouble(3);
					double sub2 = rs.getDouble(4);
					double sub3 = rs.getDouble(5);
					double total=sub1+sub2+sub3;
					stu_marks = new Stu_marks(id, name,sub1,sub2,sub3,total);

				} else {
					InvalidStudentIdException e = new InvalidStudentIdException("there is no student with this id");
					throw e;
				}
			} finally {
				con.close();
			}
			return stu_marks;
		}

		public ArrayList<Stu_marks> findAll() throws ClassNotFoundException, SQLException {
			ArrayList<Stu_marks> stu_marks = new ArrayList<>();
			String sql = "select * from Stu_marks";
			Connection con = ConnectionHelper.getConnection();
			con.commit();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double sub1 = rs.getDouble(3);
				double sub2 = rs.getDouble(4);
				double sub3 = rs.getDouble(5);
				double total=sub1+sub2+sub3;
				
				Stu_marks stu_mark = new Stu_marks(id, name,sub1,sub2,sub3,total);
				stu_marks.add(stu_mark);

			}
			con.close();
			return stu_marks;

		}

	}



