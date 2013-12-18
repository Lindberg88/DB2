package view;

import java.sql.*; 
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import org.omg.CORBA.DynAnyPackage.Invalid;

import controller.Controller;

public class Gui {

	Controller con = new Controller();
	
	DefaultListModel<String> studentListModel = new DefaultListModel<String>();
	JList<String> studentList = new JList<String>(studentListModel);

	DefaultListModel<String> studentListModel2 = new DefaultListModel<String>();
	JList<String> studentListReg = new JList<String>(studentListModel2);

	DefaultListModel<String> studentListCurrentCourses = new DefaultListModel<String>();
	JList<String> currentStudentsCourse = new JList<String>(studentListCurrentCourses);

	DefaultListModel<String> courseListModel = new DefaultListModel<String>();
	JList<String> courseList = new JList<String>(courseListModel);
	
	DefaultListModel<String> courseListModel2 = new DefaultListModel<String>();										
	JList<String> courseListReg = new JList<String>(courseListModel2);
	
	DefaultListModel<String> currentStudentsOnCourse = new DefaultListModel<String>();								//Studenter som läser kursen
	JList<String> studentsOnCourse = new JList<String>(currentStudentsOnCourse);
	
	DefaultListModel<String> ladokListModel = new DefaultListModel<String>();										//Ladok studentlista
	JList<String> ladokStudentList = new JList<String>(ladokListModel);
	
	DefaultListModel<String> ladokListModelCourse = new DefaultListModel<String>();									//ladok lista med kurser som student läser
	JList<String> ladokCourseList = new JList<String>(ladokListModelCourse);
	
	
	
	

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
	private JTextField spnrRegField;  
	private JTextField snameRegField;
	private JTextField poangRegField;
	private JTextField knameRegField;
	private JTextField kkodRegField;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;

	public static void main(String[] args) { 								// Start the application
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
		frame.setBounds(100, 100, 458, 667);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 442, 629);
		frame.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Student", null, panel, null);
		panel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 437, 632);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 229, 417, 153);
		panel_4.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Studenter",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 21, 397, 121);
		panel_4.add(scrollPane_1);
		scrollPane_1.setViewportView(studentList);
		
		
		
		//Student-frame
		studentList.addListSelectionListener(new ListSelectionListener() {					//Visar alla studenter i en lista
			public void valueChanged(ListSelectionEvent arg0) {										  
				showStudent();
			}
		});

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

		JButton btnLggTill = new JButton("L\u00E4gg till"); 									
		btnLggTill.setBounds(37, 195, 89, 23);
		panel_3.add(btnLggTill);

		JButton btnTaBort = new JButton("Ta bort"); 												
		btnTaBort.setBounds(136, 195, 89, 23);
		
		panel_3.add(btnTaBort);

		JButton btnSk = new JButton("S\u00F6k student"); 											
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
		btnRensa_1.setBounds(331, 195, 89, 23);
		panel_3.add(btnRensa_1);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "P\u00E5g\u00E5ende kurser", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_9.setBounds(10, 393, 410, 94);
		panel_3.add(panel_9);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(6, 16, 394, 67);
		panel_9.add(scrollPane);
		
		JList currentCourses = new JList();
		scrollPane.setViewportView(currentCourses);
		currentCourses.setModel(studentListCurrentCourses);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Avslutade kurser", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_10.setBounds(10, 498, 291, 94);
		panel_3.add(panel_10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(6, 16, 275, 67);
		panel_10.add(scrollPane_2);
		
		JList list_1 = new JList();
		scrollPane_2.setViewportView(list_1);
		
		JLabel label_3 = new JLabel("H\u00F6gskolepo\u00E4ng");
		label_3.setBounds(314, 498, 113, 14);
		panel_3.add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(314, 517, 113, 20);
		panel_3.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(314, 572, 113, 20);
		panel_3.add(textField_6);
		
		JLabel lblBetyg = new JLabel("Betyg");
		lblBetyg.setBounds(314, 558, 113, 14);
		panel_3.add(lblBetyg);
		
		JButton btnSpara = new JButton("Spara");
		btnSpara.setBounds(232, 195, 89, 23);
		panel_3.add(btnSpara);

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

		JButton deleteCourse = new JButton("Ta bort");
		
		deleteCourse.setBounds(136, 194, 89, 23);
		panel_1.add(deleteCourse);

		JButton button_3 = new JButton("L\u00E4gg till");
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
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setBounds(6, 16, 399, 122);
		panel_6.add(scrollPane_3);
		scrollPane_3.setViewportView(courseList);
		
		//Kurs-frame
		courseList.addListSelectionListener(new ListSelectionListener() {				//Visa alla kurser i en lista 
			public void valueChanged(ListSelectionEvent arg0) {											 
				showCourse();
			}
		});
		
		JButton btnRensa = new JButton("Rensa");								
		btnRensa.setBounds(331, 194, 89, 23);
		panel_1.add(btnRensa);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Studenter som l\u00E4ser kursen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_11.setBounds(7, 388, 413, 105);
		panel_1.add(panel_11);
		panel_11.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_4.setBounds(6, 16, 397, 82);
		panel_11.add(scrollPane_4);
		
		JList studentsOnCourse = new JList();
		scrollPane_4.setViewportView(studentsOnCourse);
		studentsOnCourse.setModel(currentStudentsOnCourse);

		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Studenter som har l\u00E4st kursen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_12.setBounds(10, 496, 306, 105);
		panel_1.add(panel_12);
		panel_12.setLayout(null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_5.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_5.setBounds(6, 16, 294, 82);
		panel_12.add(scrollPane_5);
		
		JList list_3 = new JList();
		scrollPane_5.setViewportView(list_3);
		
		JLabel lblSlutbetyg = new JLabel("Slutbetyg");
		lblSlutbetyg.setBounds(331, 496, 91, 14);
		panel_1.add(lblSlutbetyg);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(331, 521, 96, 20);
		panel_1.add(textField_8);
		textField_8.setColumns(10);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Registrering", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblKursregistrering = new JLabel("Kursregistrering");
		lblKursregistrering.setBounds(10, 0, 198, 25);
		lblKursregistrering.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(lblKursregistrering);

		JLabel lblNamn_1 = new JLabel("Namn");
		lblNamn_1.setBounds(128, 36, 97, 14);
		panel_2.add(lblNamn_1);

		JLabel lblPersonnummer_1 = new JLabel("Personnummer");
		lblPersonnummer_1.setBounds(128, 61, 97, 14);
		panel_2.add(lblPersonnummer_1);

		spnrRegField = new JTextField();
		spnrRegField.setBounds(219, 61, 208, 20);
		panel_2.add(spnrRegField);
		spnrRegField.setColumns(10);

		snameRegField = new JTextField();
		snameRegField.setBounds(219, 36, 208, 20);
		snameRegField.setColumns(10);
		panel_2.add(snameRegField);

		JLabel lblHgskolepong_1 = new JLabel("H\u00F6gskolepo\u00E4ng");
		lblHgskolepong_1.setBounds(128, 176, 120, 14);
		panel_2.add(lblHgskolepong_1);

		poangRegField = new JTextField();
		poangRegField.setBounds(219, 173, 87, 20);
		panel_2.add(poangRegField);
		poangRegField.setColumns(10);

		JLabel label = new JLabel("Kursnamn");
		label.setBounds(128, 117, 113, 23);
		panel_2.add(label);

		JLabel label_1 = new JLabel("Kurskod");
		label_1.setBounds(128, 142, 113, 23);
		panel_2.add(label_1);

		knameRegField = new JTextField();
		knameRegField.setBounds(219, 118, 208, 20);
		knameRegField.setColumns(10);
		panel_2.add(knameRegField);

		kkodRegField = new JTextField();
		kkodRegField.setBounds(219, 143, 208, 20);
		kkodRegField.setColumns(10);
		panel_2.add(kkodRegField);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "V\u00E4lj student", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(14, 27, 109, 72);
		panel_2.add(panel_7);
		panel_7.setLayout(null);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_6.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_6.setBounds(6, 16, 97, 45);
		panel_7.add(scrollPane_6);
		scrollPane_6.setViewportView(studentListReg);
		
		studentListReg.addListSelectionListener(new ListSelectionListener() { 
			public void valueChanged(ListSelectionEvent e) { 
				showStudentReg();
			}
		});
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "V\u00E4lj kurs", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(16, 105, 109, 85);
		panel_2.add(panel_8);
		panel_8.setLayout(null);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_7.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_7.setBounds(6, 16, 97, 58);
		panel_8.add(scrollPane_7);
		scrollPane_7.setViewportView(courseListReg);
		
		//Registrering-frame
		
		courseListReg.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				showCourseReg();
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 223, 417, 2);
		panel_2.add(separator);
		
		JLabel lblStatistik = new JLabel("LADOK");
		lblStatistik.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStatistik.setBounds(10, 236, 198, 25);
		panel_2.add(lblStatistik);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "V\u00E4lj kurs", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_13.setBounds(162, 272, 113, 85);
		panel_2.add(panel_13);
		panel_13.setLayout(null);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_9.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_9.setBounds(6, 16, 97, 58);
		panel_13.add(scrollPane_9);
		
		JList ladokCourseList = new JList(ladokListModelCourse);
		scrollPane_9.setViewportView(ladokCourseList);
		ladokCourseList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
			}
		});
		
		JPanel ladokList = new JPanel();
		ladokList.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "V\u00E4lj student", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ladokList.setBounds(10, 273, 113, 85);
		panel_2.add(ladokList);
		ladokList.setLayout(null);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_8.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_8.setBounds(6, 16, 97, 58);
		ladokList.add(scrollPane_8);
		
				
				ladokStudentList = new JList<String>(ladokListModel);																							
				scrollPane_8.setViewportView(ladokStudentList);
				ladokStudentList.addListSelectionListener(new ListSelectionListener() {  
					public void valueChanged(ListSelectionEvent arg0) {   
							try {
								ladokShowStudentCourses();
							} catch (SQLException e) {
								e.printStackTrace();
							}
					}
				});
		
		JButton btnNewButton_1 = new JButton("Spara betyg");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gradeStudent();
			}
		});
		btnNewButton_1.setBounds(316, 327, 111, 23);
		panel_2.add(btnNewButton_1);
		
		JLabel lblTackTillAlla = new JLabel("      Tack till alla som hj\u00E4lpt till vid framtagandet av denna programvara!");
		lblTackTillAlla.setBounds(10, 369, 417, 221);
		panel_2.add(lblTackTillAlla);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 368, 417, 2);
		panel_2.add(separator_1);
		
		JList studentListKursregistrering = new JList();
		studentListKursregistrering.addListSelectionListener(new ListSelectionListener() { 							//studentListRegistrering 
			public void valueChanged(ListSelectionEvent arg0) {																 
				
			}
		});
		
		
		
		
		
		
		btnLggTill.addActionListener(new ActionListener() {									//Lägg till student 
			public void actionPerformed(ActionEvent arg0) {										 
				addStudent();
			}
		});
		
		btnTaBort.addActionListener(new ActionListener() {								 // ta bort student 
			public void actionPerformed(ActionEvent arg0) {											
				int deleteStudent = JOptionPane.showConfirmDialog(null, 
						   "Ta bort?",null, JOptionPane.YES_NO_OPTION);
						if(deleteStudent == JOptionPane.YES_OPTION) {
							deleteStudent();
							searchField.setText("");
							snameField.setText("");
							spnrField.setText("");
							sadressField.setText("");
							stelField.setText("");
							spnrField.setEditable(true);
						} 
			}
		});
		
		btnSk.addActionListener(new ActionListener() { 									//Sök student
			public void actionPerformed(ActionEvent arg0) { 
				searchStudent();
			}
		});
		
		btnRensa_1.addActionListener(new ActionListener() { 							//Rensa alla fält (studentinfo)
			public void actionPerformed(ActionEvent e) {												 
				searchField.setText("");
				snameField.setText("");
				spnrField.setText("");
				sadressField.setText("");
				stelField.setText("");
				spnrField.setEditable(true);
				studentListCurrentCourses.removeAllElements();
			}
		});
		
		btnSpara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {									//Uppdatera student
				updateStudent();
				JOptionPane.showMessageDialog(null, "Ny studentinfo sparad!");
			}
		});

		btnSkKurs.addActionListener(new ActionListener() {  						//Sök kurs 
			public void actionPerformed(ActionEvent arg0) {									
				searchCourse();
			}
		});
		
		button_1.addActionListener(new ActionListener() { 								//Uppdatera kurs 
			public void actionPerformed(ActionEvent arg0) {											
				updateCourse();
				JOptionPane.showMessageDialog(null, "Ny kursinfo sparad!");
			}
		});
		
		deleteCourse.addActionListener(new ActionListener() { 								//Ta bort kurs 
			public void actionPerformed(ActionEvent arg0) {										
				int deleteCourse = JOptionPane.showConfirmDialog(null, 
						   "Ta bort?",null, JOptionPane.YES_NO_OPTION);
						if(deleteCourse == JOptionPane.YES_OPTION) {
							deleteCourse();
							searchCourseField.setText("");
							kkodField.setText("");
							knameField.setText("");
							kadressField.setText("");
							poangField.setText("");
							kkodField.setEditable(true);
						} 
				}
		});
		
		btnRensa.addActionListener(new ActionListener() { 								//Rensa alla fält (kursinfo)
			public void actionPerformed(ActionEvent e) { 
				searchCourseField.setText("");
				kkodField.setText("");
				knameField.setText("");
				kadressField.setText("");
				poangField.setText("");
				kkodField.setEditable(true);
			}
		});
		
		button_3.addActionListener(new ActionListener() { 								//lägg till kurs
			public void actionPerformed(ActionEvent e) {									 
				addCourse();
			}
		});
		
		JButton registerBtn = new JButton("Registrera");
		registerBtn.addActionListener(new ActionListener() {																	//Registrera student på kurs
			public void actionPerformed(ActionEvent arg0) {
				addStudentToCourse();
				JOptionPane.showMessageDialog(null, "Student registrerad på kurs!");
			}
		});
		registerBtn.setBounds(316, 172, 111, 23);
		panel_2.add(registerBtn);
		
		
		String [] betygLista = {"A", "B", "C", "D", "E", "U"};
		JComboBox comboBox = new JComboBox(betygLista);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBox.setToolTipText("");
		comboBox.setBounds(316, 279, 111, 25);
		panel_2.add(comboBox);

		
		//refreshar all input
		refresh(); 	
	}
	
	
	private void refresh() {
		//Student
		studentListModel.removeAllElements();
		try {
			ResultSet a = con.gofetchStudents();
			while (a.next()) {
				studentListModel.addElement(a.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Kurs
		courseListModel.removeAllElements();
		try {
			ResultSet a = con.gofetchCourses();
			while (a.next()) {
				courseListModel.addElement(a.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Registrering
		studentListModel2.removeAllElements();
		try {
			ResultSet a = con.gofetchStudents();
			while (a.next()) {
				studentListModel2.addElement(a.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		courseListModel2.removeAllElements();
		try {
			ResultSet a = con.gofetchCourses();
			while (a.next()) {
				courseListModel2.addElement(a.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//LADOK
		ladokListModel.removeAllElements();
		try {
			ResultSet a = con.gofetchStudents();
			while (a.next()) {
				ladokListModel.addElement(a.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}//refresh slut

	//Studentmetoder
	private void showStudent() {
		try {
			ResultSet a = con.getStudent(studentList.getSelectedValue());
			while (a.next()) {
				spnrField.setText(a.getString(1).trim());
				snameField.setText(a.getString(2).trim());
				sadressField.setText(a.getString(3).trim());
				stelField.setText(a.getString(4).trim());
				spnrField.setEditable(false);
			}
			showStudentCourses();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	

	private void showStudentCourses() throws SQLException{
			ResultSet a = con.getStudentOnCourse(studentList.getSelectedValue());
			studentListCurrentCourses.removeAllElements();
			while (a.next()) {
		        String kkod = a.getString("kkod");
		        studentListCurrentCourses.addElement(kkod);
			}	
	}
	
	private void ladokShowStudentCourses() throws SQLException{
		ResultSet a = con.getStudentOnCourse(ladokStudentList.getSelectedValue().toString());
		ladokListModelCourse.removeAllElements();
		while (a.next()) {
	        String kkod = a.getString("kkod");
	        
	        ladokListModelCourse.addElement(kkod);
		}
		
	}
	
	
	private void showStudentReg() {
		try {
			ResultSet a = con.getStudent(studentListReg.getSelectedValue());
			while (a.next()) {
				spnrRegField.setText(a.getString(1).trim());
				snameRegField.setText(a.getString(2).trim());
				spnrRegField.setEditable(false);
				snameRegField.setEditable(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void addStudent(){
		try{
			int a = con.addStudent(
					spnrField.getText().trim(),
					snameField.getText().trim(),
					sadressField.getText().trim(),
					stelField.getText().trim());
					spnrField.setEditable(false);
			refresh();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void deleteStudent(){
		try{
			int a = con.deleteStudent(
					spnrField.getText().trim(),
					snameField.getText().trim(),
					sadressField.getText().trim(),
					stelField.getText().trim());
			refresh();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void searchStudent() {
		try {
			ResultSet a = con.getStudent(searchField.getText());
			while (a.next()) {
				spnrField.setText(a.getString(1).trim());
				snameField.setText(a.getString(2).trim());
				sadressField.setText(a.getString(3).trim());
				stelField.setText(a.getString(4).trim());
				spnrField.setEditable(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void updateStudent(){
		try{
			int a = con.updateStudent(
					spnrField.getText().trim(),
					snameField.getText().trim(),
					sadressField.getText().trim(),
					stelField.getText().trim());
			refresh();
		}
			catch (SQLException e) {
				e.printStackTrace();
			}			
		}
	
	
	
	//Kursmetoder
	private void showCourse() {
		try {
			ResultSet a = con.getCourse(courseList.getSelectedValue());
			while (a.next()) {
				kkodField.setText(a.getString(1).trim());
				knameField.setText(a.getString(2).trim());
				kadressField.setText(a.getString(3).trim());
				poangField.setText(a.getString(4).trim());
				kkodField.setEditable(false);
			}
			showCourseStudents();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void showCourseStudents() throws SQLException{
		ResultSet a = con.getCourseStudents(courseList.getSelectedValue());
		currentStudentsOnCourse.removeAllElements();
		while (a.next()) {
	        String spnr = a.getString("spnr");
	        currentStudentsOnCourse.addElement(spnr);
		}	
}
	
	private void showCourseReg() {
		try {
			ResultSet a = con.getCourse(courseListReg.getSelectedValue());
			while (a.next()) {
				kkodRegField.setText(a.getString(1).trim());
				knameRegField.setText(a.getString(2).trim());
				poangRegField.setText(a.getString(4).trim());
				kkodRegField.setEditable(false);
				knameRegField.setEditable(false);
				poangRegField.setEditable(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void searchCourse() {
		try {
			ResultSet a = con.getCourse(searchCourseField.getText());
			while (a.next()) {
				kkodField.setText(a.getString(1).trim());
				knameField.setText(a.getString(2).trim());
				kadressField.setText(a.getString(3).trim());
				poangField.setText(a.getString(4).trim());
				kkodField.setEditable(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void addCourse(){
		try{
			int a = con.addCourse(
					kkodField.getText().trim(),
					knameField.getText().trim(),
					kadressField.getText().trim(),
					poangField.getText().trim());
					kkodField.setEditable(false);
			refresh();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void deleteCourse(){
		try{
			int a = con.deleteCourse(
					kkodField.getText().trim(),
					knameField.getText().trim(),
					kadressField.getText().trim(),
					poangField.getText().trim());
			refresh();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void updateCourse(){
		try{
			int a = con.updateCourse(
					kkodField.getText().trim(),
					knameField.getText().trim(),
					kadressField.getText().trim(),
					poangField.getText().trim());
			refresh();
		}
			catch (SQLException e) {
				e.printStackTrace();
			}			
		}

	
	//Registrering
	private void addStudentToCourse(){   
		try{
			int a = con.addStudentToCourse(
					spnrRegField.getText().trim(),
					kkodRegField.getText().trim());	
					
					snameRegField.setText("");
					knameRegField.setText("");
					poangRegField.setText("");
					spnrRegField.setText("");
					kkodRegField.setText("");
					
					snameRegField.setEditable(true);
					knameRegField.setEditable(true);
					poangRegField.setEditable(true);
					spnrRegField.setEditable(true);
					kkodRegField.setEditable(true);

			refresh();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private void gradeStudent(){
		int a = con.gradeStudent(
				ladokStudentList.getSelectedValue(),
				ladokCourseList.getSelectedValue(),
				comboBox.getSelectedItem().toString());
	}
	
	
	
}//main
