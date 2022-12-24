package com.ibik.pbo.praktikum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ibik.pbo.praktikum.ConnectionDB;
import com.ibik.pbo.praktikum.User;

public class RegisterDao {

	private String queryRegister = "INSERT INTO users (fullname, email, phone, password, gender, citizenship) "
			+ "values (?, ?, ?, ?, ?, ?)";

	public void savedRegister(User user) throws Exception {
		Connection c = new ConnectionDB().connect();

		PreparedStatement Insert = c.prepareStatement(queryRegister);

		Insert.setString(1, user.getFullname());
		Insert.setString(2, user.getEmail());
		Insert.setString(3, user.getPhone());
		Insert.setString(4, user.getPassword());
		Insert.setString(5, user.getGender());
		Insert.setString(6, user.getCitizenship());

		Insert.executeUpdate();

		c.close();
	}
}
