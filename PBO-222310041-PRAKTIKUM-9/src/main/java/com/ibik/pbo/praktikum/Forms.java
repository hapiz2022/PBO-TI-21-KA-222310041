package com.ibik.pbo.praktikum;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;

public class Forms extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2010852426529829766L;

	Forms() {
		pack();
		setLocationRelativeTo(null);
		setSize(875, 510);
		setTitle("Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		placeComponents(this);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Forms();
	}

	private void placeComponents(final Forms frame) {
		final StudentsDao Dao = new StudentsDao();
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		frame.setContentPane(panel);

		JPanel headerPanel = new JPanel();
		headerPanel.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		panel.add(headerPanel, BorderLayout.NORTH);
		JLabel headerTitle = new JLabel("FORM PENILAIAN MATAKULIAH PBO");
		headerTitle.setFont(new Font("Arial", Font.PLAIN, 20));
		headerPanel.add(headerTitle);

		Border lftPanelBorder = BorderFactory.createTitledBorder("Input Data Mahasiswa");
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(null);
		leftPanel.setPreferredSize(new Dimension(335, 480));
		panel.add(leftPanel, BorderLayout.WEST);

		JLabel namaLabel = new JLabel("Nama:");
		namaLabel.setBounds(10, 40, 80, 25);
		leftPanel.add(namaLabel);

		final JTextField namaField = new JTextField(20);
		namaField.setBounds(100, 40, 160, 25);
		leftPanel.add(namaField);

		JLabel nimLabel = new JLabel("NIM:");
		nimLabel.setBounds(10, 70, 80, 25);
		leftPanel.add(nimLabel);

		final JTextField nimField = new JTextField(20);
		nimField.setBounds(100, 70, 160, 25);
		leftPanel.add(nimField);

		JLabel nilaiLabel = new JLabel("Nilai:");
		nilaiLabel.setBounds(10, 100, 80, 25);
		leftPanel.add(nilaiLabel);

		final JRadioButton aButton = new JRadioButton("A");
		aButton.setBounds(10, 145, 35, 25);
		leftPanel.add(aButton);

		final JRadioButton bButton = new JRadioButton("B");
		bButton.setBounds(60, 145, 35, 25);
		leftPanel.add(bButton);

		final JRadioButton cButton = new JRadioButton("C");
		cButton.setBounds(110, 145, 35, 25);
		leftPanel.add(cButton);

		final JRadioButton dButton = new JRadioButton("D");
		dButton.setBounds(160, 145, 35, 25);
		leftPanel.add(dButton);

		final JRadioButton eButton = new JRadioButton("E");
		eButton.setBounds(210, 145, 35, 25);
		leftPanel.add(eButton);

		final JRadioButton fButton = new JRadioButton("F");
		fButton.setBounds(260, 145, 35, 25);
		leftPanel.add(fButton);

		ButtonGroup group = new ButtonGroup();
		group.add(aButton);
		group.add(bButton);
		group.add(cButton);
		group.add(dButton);
		group.add(eButton);
		group.add(fButton);

		JButton saveButton = new JButton("Save");
		saveButton.setBounds(15, 190, 80, 25);
		leftPanel.add(saveButton);

		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(115, 190, 80, 25);
		leftPanel.add(deleteButton);

		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(205, 190, 80, 25);
		leftPanel.add(clearButton);
		leftPanel.setBorder(lftPanelBorder);
		String[] columns = { "Nama", "NIM", "Nilai" };
		Object[][] data = {};
		final DefaultTableModel model = new DefaultTableModel(data, columns);
		updateTable(model);

		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Students student = new Students();
				String nama = namaField.getText();
				String nim = nimField.getText();

				if (!nama.isEmpty()) {
					student.setFullname(nama);
				} else {
					JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong!", "Alert!",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (!nim.isEmpty()) {
					student.setNim(nim);
				} else {
					JOptionPane.showMessageDialog(null, "NIM tidak boleh kosong!", "Alert!", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (aButton.isSelected()) {
					student.setNilai(aButton.getText());
				} else if (bButton.isSelected()) {
					student.setNilai(bButton.getText());
				} else if (cButton.isSelected()) {
					student.setNilai(cButton.getText());
				} else if (dButton.isSelected()) {
					student.setNilai(dButton.getText());
				} else if (eButton.isSelected()) {
					student.setNilai(eButton.getText());
				} else if (fButton.isSelected()) {
					student.setNilai(fButton.getText());
				} else {
					JOptionPane.showMessageDialog(null, "Nilai tidak boleh kosong!", "Alert!",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					boolean exists = Dao.exists(nim);

					if (exists) {
						Dao.update(student);
						updateTable(model);
						JOptionPane.showMessageDialog(null, "Data Berhasil Di Update!", "Data",
								JOptionPane.INFORMATION_MESSAGE);

					} else {
						Dao.saved(student);
						updateTable(model);
						JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!", "Data",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, "Error: " + err.getMessage());
					err.printStackTrace();
				}

			}
		});

		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				namaField.setText("");
				nimField.setText("");
			}
		});

		Border rightBorder = BorderFactory.createTitledBorder("Data Mahasiswa");
		JPanel rightPanel = new JPanel(new BorderLayout());
		panel.add(rightPanel);

		final JTable table = new JTable(model) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -4866045286780517904L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		Dimension panelSize = rightPanel.getSize();
		table.setPreferredScrollableViewportSize(panelSize);
		table.setFillsViewportHeight(true);
		rightPanel.add(table, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(300, 40, 500, 400);
		rightPanel.add(scrollPane);
		rightPanel.setBorder(rightBorder);
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int selectedRow = table.getSelectedRow();

				if (selectedRow < 0) {
					JOptionPane.showMessageDialog(null, "Silakan pilih data terlebih dahulu!", "Alert!",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				String nim = (String) table.getValueAt(selectedRow, 1);
				try {
					Dao.delete(nim);
					model.removeRow(selectedRow);
					JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!", "Success",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception err) {
					err.printStackTrace();
				}

			}
		});

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem student_data = new JMenuItem("Open Student Data");
		JMenuItem saveToPdfItem = new JMenuItem("Save To PDF");
		saveToPdfItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Save");
				fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));
				int userSelection = fileChooser.showSaveDialog(frame);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File fileToSave = fileChooser.getSelectedFile();

					try {
						Document document = new Document();
						PdfWriter.getInstance(document, new FileOutputStream(fileToSave));
						document.open();
						PdfPTable pdfTable = new PdfPTable(table.getColumnCount());

						for (int i = 0; i < table.getColumnCount(); i++) {
							pdfTable.addCell(table.getColumnName(i));
						}
						for (int i = 0; i < table.getRowCount(); i++) {
							for (int j = 0; j < table.getColumnCount(); j++) {
								pdfTable.addCell(table.getValueAt(i, j).toString());
							}
						}

						document.add(pdfTable);
						document.close();
						JOptionPane.showMessageDialog(null, "Data saved to PDF successfully!", "Success",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Error saving data to PDF: " + ex.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		menu.add(student_data);
		menu.add(saveToPdfItem);
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("Exit");
		menu.add(menuItem);
		menuBar.add(menu);

		JMenu editMenu = new JMenu("Edit");
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		frame.setJMenuBar(menuBar);

		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	public void updateTable(DefaultTableModel model) {
		StudentsDao Dao = new StudentsDao();
		model.setRowCount(0);
		List<Students> studentList;
		try {
			studentList = Dao.getAllStudents();
			for (Students student : studentList) {
				model.addRow(new Object[] { student.getFullname(), student.getNim(), student.getNilai() });
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}