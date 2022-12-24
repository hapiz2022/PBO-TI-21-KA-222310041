package com.ibik.pbo.praktikum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

public class StudentsDao {

	private String query = "INSERT INTO `students_score`(`nim`, `fullname`, `nilai`) VALUES (?,?,?) ";

	public void saved(Students students) throws Exception {

		Connection c = new ConnectionDB().connect();

		PreparedStatement psInsert = c.prepareStatement(query);

		psInsert.setString(1, students.getNim());
		psInsert.setString(2, students.getFullname());
		psInsert.setString(3, students.getNilai());

		psInsert.executeUpdate();

		c.close();
	}

	public void delete(String nim) throws Exception {
		Connection c = new ConnectionDB().connect();

		String query = "DELETE FROM `students_score` WHERE nim = ?";
		PreparedStatement psDelete = c.prepareStatement(query);
		psDelete.setString(1, nim);
		psDelete.executeUpdate();

		c.close();
	}

	public List<Students> getAllStudents() throws Exception {
		List<Students> studentList = new ArrayList<>();
		Connection c = new ConnectionDB().connect();
		String query = "SELECT * FROM students_score";
		java.sql.Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			Students student = new Students();
			student.setNim(rs.getString("nim"));
			student.setFullname(rs.getString("fullname"));
			student.setNilai(rs.getString("nilai"));
			studentList.add(student);
		}

		c.close();
		return studentList;
	}

	public boolean exists(String nim) throws Exception {
		Connection c = new ConnectionDB().connect();

		String query = "SELECT * FROM students_score WHERE nim = ?";
		PreparedStatement psSelect = c.prepareStatement(query);
		psSelect.setString(1, nim);
		ResultSet rs = psSelect.executeQuery();

		boolean exists = rs.next();

		c.close();

		return exists;

	}

	public void update(Students student) throws Exception {
		Connection c = new ConnectionDB().connect();

		String query = "UPDATE students_score SET fullname = ?, nilai = ? WHERE nim = ?";
		PreparedStatement psUpdate = c.prepareStatement(query);
		psUpdate.setString(1, student.getFullname());
		psUpdate.setString(2, student.getNilai());
		psUpdate.setString(3, student.getNim());
		psUpdate.executeUpdate();

		c.close();
	}

}
