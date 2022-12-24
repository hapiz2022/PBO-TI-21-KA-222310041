package com.ibik.pbo.praktikum;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import com.ibik.pbo.praktikum.ConnectionDB;
public class App {

	App() {
		ConnectionDB conn = new ConnectionDB();
		try {
			conn.connect();
			new Login();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void main(String[] args) {
		new App();

	}
}