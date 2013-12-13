package dataaccesslayer;

import java.sql.*;						

public class Dal {
	
	public Dal(){																		//konstruktor
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				//connection string
		} 
		catch (Exception e) {
			System.out.println("Kan inte hitta database driver class: " + e);
		} 
	}
	
	private Connection connect() throws SQLException{
		return DriverManager.getConnection("JDBC:ODBC:Grupp30;database=Grupp30;");
	}
			
	public ResultSet getAllStudents() throws SQLException{
		Statement stmtStudent = connect().createStatement();					//metod för att hämta allt från Student
		String sqlStudent = "select * from student";					//SQL-kod
		ResultSet rsetStudent = stmtStudent.executeQuery(sqlStudent);
		
		return rsetStudent;
	}
	
	public ResultSet getStudent(String spnr) throws SQLException{				//metod för att hämta allt från Student (som vi sedan kastar in i GUI)
		PreparedStatement stmtStudent = connect().prepareStatement("select * from student where spnr = ?");
		stmtStudent.setString(1, spnr);
		ResultSet rsetStudent = stmtStudent.executeQuery();
		
		return rsetStudent;
		}
	
	
	public ResultSet getAllCourses() throws SQLException{
		Statement stmtCourse = connect().createStatement();					//metod för att hämta allt från Student
		String sqlCourse = "select * from kurs";					//SQL-kod
		ResultSet rsetCourse = stmtCourse.executeQuery(sqlCourse);
		
		return rsetCourse;
	}

	public ResultSet getCourse(String kkod) throws SQLException{				//metod för att hämta allt från Student (som vi sedan kastar in i GUI)
		PreparedStatement stmtCourse = connect().prepareStatement("select * from kurs where kkod = ?");
		stmtCourse.setString(1, kkod);
		ResultSet rsetCourse = stmtCourse.executeQuery();
		return rsetCourse;
		}

	public int addStudent(String spnr,String sname,String sadress,String stel) throws SQLException {
		PreparedStatement stmtStudent = connect().prepareStatement("insert into Student values(?,?,?,?)");
		stmtStudent.setString(1, spnr);
		stmtStudent.setString(2, sname);
		stmtStudent.setString(3, sadress);
		stmtStudent.setString(4, stel);
		int rsetStudent = stmtStudent.executeUpdate();
		return rsetStudent;
		
	}

	public int addCourse(String kkod, String kname, String kadress, String poang) throws SQLException {
		PreparedStatement stmtCourse = connect().prepareStatement("insert into Kurs values(?,?,?,?)");
		stmtCourse.setString(1, kkod);
		stmtCourse.setString(2, kname);
		stmtCourse.setString(3, kadress);
		stmtCourse.setString(4, poang);
		int rsetCourse = stmtCourse.executeUpdate();
		return rsetCourse;
	}
		//så funkar det :DA:D:A:D
	
	}

