package com.ibik.pbo.praktikum;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.ibik.pbo.praktikum.User;

public class Register extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Register() {
		pack();
		setSize(310, 390);
		setTitle("Register");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		GenerateUI(this);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Register();
	}

	private void GenerateUI(Register frame) {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		frame.setContentPane(mainPanel);

		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		mainPanel.add(panel1, BorderLayout.NORTH);

		JLabel lblFullname = new JLabel("Fullname");
		lblFullname.setBounds(22, 29, 80, 16);
		panel1.add(lblFullname);
		final JTextField textFullname = new JTextField();
		textFullname.setBounds(105, 24, 169, 30);
		panel1.add(textFullname);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(22, 69, 61, 16);
		panel1.add(lblEmail);

		final JTextField textEmail = new JTextField();
		textEmail.setBounds(105, 64, 169, 30);
		panel1.add(textEmail);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(22, 109, 61, 16);
		panel1.add(lblPhone);
		final JTextField txtPhone = new JTextField();
		txtPhone.setBounds(105, 104, 169, 30);
		panel1.add(txtPhone);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(22, 149, 61, 16);
		panel1.add(lblPassword);
		final JPasswordField textPassword = new JPasswordField();
		textPassword.setBounds(105, 144, 169, 30);
		panel1.add(textPassword);

		JLabel lblConfirm = new JLabel("Confirm");
		lblConfirm.setBounds(22, 189, 61, 16);
		panel1.add(lblConfirm);
		final JPasswordField textConfirm = new JPasswordField();
		textConfirm.setBounds(105, 184, 169, 30);
		panel1.add(textConfirm);

		final JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(22, 220, 61, 16);
		panel1.add(lblGender);
		final JRadioButton radioGender1 = new JRadioButton("Female");
		radioGender1.setBounds(105, 215, 100, 30);
		panel1.add(radioGender1);
		final JRadioButton radioGender2 = new JRadioButton("Male");
		radioGender2.setBounds(200, 215, 100, 30);
		panel1.add(radioGender2);
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioGender1);
		bg.add(radioGender2);

		JLabel lblCityzen = new JLabel("Citizenship");
		lblCityzen.setBounds(22, 250, 100, 16);
		panel1.add(lblCityzen);
		String country[] = { "Indonesia", "India", "Australia", "U.S.A", "England", "Newzealand" };
		final JComboBox selectCitizen = new JComboBox(country);
		selectCitizen.setBounds(105, 250, 169, 30);
		panel1.add(selectCitizen);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(105, 290, 169, 40);
		panel1.add(btnSubmit);
		frame.add(panel1);

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> out = new ArrayList<String>();
				User user = new User();
				String nama = textFullname.getText();
				String email = textEmail.getText();
				String phone = txtPhone.getText();
				String password = new String(textPassword.getPassword());
				String confirm = new String(textConfirm.getPassword());

				String output = "";

				if (nama.isBlank() || email.isBlank() || phone.isBlank()) {
					JOptionPane.showMessageDialog(null, "Data tidak boleh kosong. Silakan periksa kembali isian anda.");
					return;
				} else {
					out.add(nama);
					out.add(email);
					out.add(phone);
					user.setFullname(textFullname.getText());
					user.setEmail(textEmail.getText());
					user.setPhone(txtPhone.getText());
				}

				if (!password.isEmpty()) {
					if (!password.equals(confirm)) {
						JOptionPane.showMessageDialog(null,
								"Password tidak sesuai.\nHarap periksa kembali Password anda", "Alert!",
								JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						user.setPassword(password);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Password harus diisi", "Alert!", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (!radioGender1.isSelected() && !radioGender2.isSelected()) {
					JOptionPane.showMessageDialog(null, "Data tidak boleh kosong. Silakan periksa kembali isian anda.");
					return;

				} else if (radioGender1.isSelected()) {
					out.add(radioGender1.getText());
					user.setGender(radioGender1.getText());
				} else if (radioGender2.isSelected()) {
					out.add(radioGender2.getText());
					user.setGender(radioGender2.getText());
				}

				user.setCitizenship(selectCitizen.getSelectedItem().toString());
				
                RegisterDao regDAO = new RegisterDao();
                try {
                    regDAO.savedRegister(user);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null, "Error : " + e1.getMessage());
                    e1.printStackTrace();
                }
				
				out.add(selectCitizen.getSelectedItem().toString());
				
				
				output += "Data Anda Adalah : \n";
				output += "Name 		: " + out.get(0) + "\n";
				output += "Email 		: " + out.get(1) + "\n";
				output += "Phone 		: " + out.get(2) + "\n";
				output += "Gender 		: " + out.get(3) + "\n";
				output += "Citizenship 	: " + out.get(4) + "\n";
				JOptionPane.showMessageDialog(null, output, "Data Diri", JOptionPane.INFORMATION_MESSAGE);

				Login othFrame = new Login();
				othFrame.setVisible(true);
				dispose();

			}
		});

	}

}