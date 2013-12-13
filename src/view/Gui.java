package view;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import controller.Controller;

public class Gui {

	Controller con = new Controller();
	DefaultListModel<String> studentListModel = new DefaultListModel<String>();
	JList<String> studentList = new JList<String>(studentListModel);

	DefaultListModel<String> courseListModel = new DefaultListModel<String>();
	JList<String> courseList = new JList<String>(courseListModel);

	private JFrame frame;
	private JTextField snameField;
	private JTextField spnrField;
	private JTextField sadressField;
	private JTextField stelField;
	private JTextField searchField;
	private JTextField searchCourseField;
	private JTextField knameField;
	private JTextField kkodField;
	private JTextField kadressField;
	private JTextField poangField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public static void main(String[] args) { // Start the application
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Gui() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 435, 416);
		frame.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Student", null, panel, null);
		panel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 430, 393);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 229, 417, 153);
		panel_4.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Studenter",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		studentList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				showStudent();
			}
		});
		studentList.setBounds(10, 21, 397, 121);
		panel_4.add(studentList);

		JLabel lblNamn = new JLabel("Namn");
		lblNamn.setBounds(10, 90, 113, 23);
		panel_3.add(lblNamn);

		JLabel lblPersonnummer = new JLabel("Personnummer");
		lblPersonnummer.setBounds(10, 115, 113, 23);
		panel_3.add(lblPersonnummer);

		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setBounds(10, 138, 113, 23);
		panel_3.add(lblAdress);

		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setBounds(10, 161, 113, 23);
		panel_3.add(lblTelefon);

		snameField = new JTextField();
		snameField.setBounds(133, 91, 294, 20);
		panel_3.add(snameField);
		snameField.setColumns(10);

		spnrField = new JTextField();
		spnrField.setBounds(133, 116, 294, 20);
		panel_3.add(spnrField);
		spnrField.setColumns(10);

		sadressField = new JTextField();
		sadressField.setBounds(133, 139, 294, 20);
		panel_3.add(sadressField);
		sadressField.setColumns(10);

		stelField = new JTextField();
		stelField.setBounds(133, 164, 294, 20);
		panel_3.add(stelField);
		stelField.setColumns(10);

		JButton btnLggTill = new JButton("L\u00E4gg till"); 									// lägg till student
		btnLggTill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addStudent();
			}
		});
		btnLggTill.setBounds(37, 195, 89, 23);
		panel_3.add(btnLggTill);

		JButton btnTaBort = new JButton("Ta bort"); // ta bort student
		btnTaBort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTaBort.setBounds(136, 195, 89, 23);
		panel_3.add(btnTaBort);

		JButton btnUppdatera = new JButton("Spara"); // Uppdatera/ändra student
		btnUppdatera.setBounds(232, 195, 89, 23);
		btnUppdatera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_3.add(btnUppdatera);

		JButton btnSk = new JButton("S\u00F6k student"); // sök student
		btnSk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchStudent();
			}
		});
		btnSk.setBounds(314, 57, 113, 23);
		panel_3.add(btnSk);

		searchField = new JTextField();
		searchField.setBounds(133, 58, 180, 20);
		panel_3.add(searchField);
		searchField.setColumns(10);

		JLabel lblangePersonnummer = new JLabel("(Ange personnummer)");
		lblangePersonnummer.setBounds(133, 37, 180, 14);
		panel_3.add(lblangePersonnummer);

		JLabel lblStudentinformation = new JLabel("Studentinformation");
		lblStudentinformation.setBounds(10, 0, 303, 29);
		lblStudentinformation.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_3.add(lblStudentinformation);
		
		JButton btnRensa_1 = new JButton("Rensa");
		btnRensa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchField.setText("");
				snameField.setText("");
				spnrField.setText("");
				sadressField.setText("");
				stelField.setText("");
			}
		});
		btnRensa_1.setBounds(331, 195, 89, 23);
		panel_3.add(btnRensa_1);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Kurs", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblKursinformation = new JLabel("Kursinformation");
		lblKursinformation.setBounds(10, 0, 198, 25);
		lblKursinformation.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblKursinformation);

		searchCourseField = new JTextField();
		searchCourseField.setBounds(133, 57, 180, 20);
		searchCourseField.setColumns(10);
		panel_1.add(searchCourseField);

		JLabel lblangeKurskod = new JLabel("(Ange kurskod)");
		lblangeKurskod.setBounds(133, 36, 180, 14);
		panel_1.add(lblangeKurskod);

		JButton btnSkKurs = new JButton("S\u00F6k kurs");
		btnSkKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchCourse();
			}
		});
		btnSkKurs.setBounds(314, 56, 113, 23);
		panel_1.add(btnSkKurs);

		knameField = new JTextField();
		knameField.setBounds(133, 90, 294, 20);
		knameField.setColumns(10);
		panel_1.add(knameField);

		kkodField = new JTextField();
		kkodField.setBounds(133, 115, 294, 20);
		kkodField.setColumns(10);
		panel_1.add(kkodField);

		kadressField = new JTextField();
		kadressField.setBounds(133, 138, 294, 20);
		kadressField.setColumns(10);
		panel_1.add(kadressField);

		poangField = new JTextField();
		poangField.setBounds(133, 163, 294, 20);
		poangField.setColumns(10);
		panel_1.add(poangField);

		JButton button_1 = new JButton("Spara");
		button_1.setBounds(232, 194, 89, 23);
		panel_1.add(button_1);

		JButton button_2 = new JButton("Ta bort");
		button_2.setBounds(136, 194, 89, 23);
		panel_1.add(button_2);

		JButton button_3 = new JButton("L\u00E4gg till");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {									//lägg till kurs
				addCourse();
			}
		});
		button_3.setBounds(37, 194, 89, 23);
		panel_1.add(button_3);

		JLabel lblHgskolepong = new JLabel("H\u00F6gskolepo\u00E4ng");
		lblHgskolepong.setBounds(10, 160, 113, 23);
		panel_1.add(lblHgskolepong);

		JLabel label_2 = new JLabel("Adress");
		label_2.setBounds(10, 137, 113, 23);
		panel_1.add(label_2);

		JLabel lblKurskod = new JLabel("Kurskod");
		lblKurskod.setBounds(10, 114, 113, 23);
		panel_1.add(lblKurskod);

		JLabel lblKursnamn = new JLabel("Kursnamn");
		lblKursnamn.setBounds(10, 89, 113, 23);
		panel_1.add(lblKursnamn);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(21, 317, 101, -76);
		panel_5.setBorder(new TitledBorder(null, "JPanel title",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Kurser",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(10, 228, 416, 149);
		panel_1.add(panel_6);
		panel_6.setLayout(null);

		courseList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				showCourse();
			}
		});
		courseList.setBounds(6, 16, 399, 122);
		panel_6.add(courseList);
		
		JButton btnRensa = new JButton("Rensa");								//clear all fields
		btnRensa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchCourseField.setText("");
				kkodField.setText("");
				knameField.setText("");
				kadressField.setText("");
				poangField.setText("");
			}
		});
		btnRensa.setBounds(331, 194, 89, 23);
		panel_1.add(btnRensa);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Registrering", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblKursregistrering = new JLabel("Kursregistrering");
		lblKursregistrering.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblKursregistrering.setBounds(10, 0, 198, 25);
		panel_2.add(lblKursregistrering);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "V\u00E4lj student",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(10, 36, 91, 141);
		panel_2.add(panel_7);
		panel_7.setLayout(null);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "V\u00E4lj kurs",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(10, 188, 91, 141);
		panel_2.add(panel_8);

		JLabel lblNamn_1 = new JLabel("Namn");
		lblNamn_1.setBounds(111, 36, 97, 14);
		panel_2.add(lblNamn_1);

		JLabel lblPersonnummer_1 = new JLabel("Personnummer");
		lblPersonnummer_1.setBounds(111, 61, 97, 14);
		panel_2.add(lblPersonnummer_1);

		textField = new JTextField();
		textField.setBounds(202, 61, 218, 20);
		panel_2.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(202, 36, 218, 20);
		panel_2.add(textField_1);

		JLabel lblHgskolepong_1 = new JLabel("H\u00F6gskolepo\u00E4ng");
		lblHgskolepong_1.setBounds(202, 256, 120, 14);
		panel_2.add(lblHgskolepong_1);

		textField_2 = new JTextField();
		textField_2.setBounds(202, 281, 87, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);

		JLabel label = new JLabel("Kursnamn");
		label.setBounds(111, 197, 113, 23);
		panel_2.add(label);

		JLabel label_1 = new JLabel("Kurskod");
		label_1.setBounds(111, 222, 113, 23);
		panel_2.add(label_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(202, 198, 218, 20);
		panel_2.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(202, 223, 218, 20);
		panel_2.add(textField_4);

		refresh(); // refreshar all input

	}

	private void refresh() {
		studentListModel.removeAllElements();
		try {
			ResultSet a = con.gofetchStudents();
			while (a.next()) {
				studentListModel.addElement(a.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		courseListModel.removeAllElements();
		try {
			ResultSet a = con.gofetchCourses();
			while (a.next()) {
				courseListModel.addElement(a.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void showStudent() {
		try {
			ResultSet a = con.getStudent(studentList.getSelectedValue());
			while (a.next()) {
				spnrField.setText(a.getString(1));
				snameField.setText(a.getString(2));
				sadressField.setText(a.getString(3));
				stelField.setText(a.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void showCourse() {
		try {
			ResultSet a = con.getCourse(courseList.getSelectedValue());
			while (a.next()) {
				kkodField.setText(a.getString(1));
				knameField.setText(a.getString(2));
				kadressField.setText(a.getString(3));
				poangField.setText(a.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void searchStudent() {
		try {
			ResultSet a = con.getStudent(searchField.getText());
			while (a.next()) {
				spnrField.setText(a.getString(1));
				snameField.setText(a.getString(2));
				sadressField.setText(a.getString(3));
				stelField.setText(a.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void searchCourse() {
		try {
			ResultSet a = con.getCourse(searchCourseField.getText());
			while (a.next()) {
				kkodField.setText(a.getString(1));
				knameField.setText(a.getString(2));
				kadressField.setText(a.getString(3));
				poangField.setText(a.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void addStudent(){
		try{
			int a = con.addStudent(
					spnrField.getText(),
					snameField.getText(),
					sadressField.getText(),
					stelField.getText());
			refresh();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void addCourse(){
		try{
			int a = con.addCourse(
					kkodField.getText(),
					knameField.getText(),
					kadressField.getText(),
					poangField.getText());
			refresh();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
