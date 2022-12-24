package com.ibik.pbo.praktikum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class LoginDao {
    private String queryLogin = "SELECT * FROM users where email = ? and password = ?";
    private String queryFullname = "SELECT fullname FROM users WHERE email = ?";
    public boolean authLogin(String email, String password) throws Exception {
        boolean isUser = false;
        try {
            Connection c = new ConnectionDB().connect();
            PreparedStatement ps = c.prepareStatement(queryLogin);
            PreparedStatement pss = c.prepareStatement(queryLogin);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                isUser = true;
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, e.getMessage(), "Error : ", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return isUser;
    }

    public String getFullName(String email) {
        String fullName = null;
        try {
            Connection c = new ConnectionDB().connect();
            PreparedStatement ps = c.prepareStatement(queryFullname);
            ps.setString(1, email);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                fullName = result.getString("fullname");
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return fullName;
    }
}
