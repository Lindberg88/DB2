
package dataaccesslayer;

import java.sql.*;						

public class Dal {
	
	public Dal(){																								//konstruktor
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
		} 
		catch (Exception e) {
			System.out.println("Kan inte hitta database driver class: " + e);
		} 
	}
	
	private Connection connect() throws SQLException{
		return DriverManager.getConnection("JDBC:ODBC:Grupp30;database=Grupp30;");								//connection string
	}
			
	//Studentmetoder
	public ResultSet getStudentOnCourse(String spnr) throws SQLException{												//Hämtar 1 student från databasen
		PreparedStatement stmtStudentOnCourse = connect().prepareStatement("select * from laser where spnr = ?");
		stmtStudentOnCourse.setString(1, spnr);
		ResultSet rsetStudentCourse = stmtStudentOnCourse.executeQuery();
		return rsetStudentCourse;
		}

	public ResultSet getAllStudents() throws SQLException{														//Hämtar alla studenter (till listan) 
		Statement stmtStudent = connect().createStatement();													
		String sqlStudent = "select * from student";															
		ResultSet rsetStudent = stmtStudent.executeQuery(sqlStudent);
		return rsetStudent;
	}
	
	public ResultSet getStudent(String spnr) throws SQLException{												//Hämtar 1 student från databasen
		PreparedStatement stmtStudent = connect().prepareStatement("select * from student where spnr = ?");
		stmtStudent.setString(1, spnr);
		ResultSet rsetStudent = stmtStudent.executeQuery();
		return rsetStudent;
		}

	public int addStudent(String spnr,String sname,String sadress,String stel) throws SQLException {			//Lägg till student
		PreparedStatement stmtStudent = connect().prepareStatement("insert into Student values(?,?,?,?)");
		stmtStudent.setString(1, spnr);
		stmtStudent.setString(2, sname);
		stmtStudent.setString(3, sadress);
		stmtStudent.setString(4, stel);
		int rsetStudent = stmtStudent.executeUpdate();
		return rsetStudent;
	}
	
	public int deleteStudent(String spnr, String sname, String sadress,String stel) throws SQLException {
		PreparedStatement stmtStudent = connect().prepareStatement("delete from student where spnr =? and sname = ? and sadress = ? and stel = ?");
		stmtStudent.setString(1, spnr);
		stmtStudent.setString(2, sname);
		stmtStudent.setString(3, sadress);
		stmtStudent.setString(4, stel);
		int rsetStudent = stmtStudent.executeUpdate();
		return rsetStudent;
	}

	public int updateStudent(String spnr, String sname, String sadress,String stel) throws SQLException {
		PreparedStatement stmtStudent = connect().prepareStatement("UPDATE Student SET sname = ?, sadress = ?, stel = ? where spnr = ?");
		stmtStudent.setString(1, sname);
		stmtStudent.setString(2, sadress);
		stmtStudent.setString(3, stel);
		stmtStudent.setString(4, spnr);
		int rsetStudent = stmtStudent.executeUpdate();
		return rsetStudent;
	}
	
	public ResultSet getFinishedCourses(String spnr) throws SQLException {
		PreparedStatement stmtFinished = connect().prepareStatement("select * from harLastKurs where spnr = ?");
		stmtFinished.setString(1, spnr);
		ResultSet rsetFinished = stmtFinished.executeQuery();
		return rsetFinished;
	}
	
	
	//Kursmetoder
	public ResultSet getAllCourses() throws SQLException{														//Hämtar alla kurser (till listan)
		Statement stmtCourse = connect().createStatement();														
		String sqlCourse = "select * from kurs";					
		ResultSet rsetCourse = stmtCourse.executeQuery(sqlCourse);
		
		return rsetCourse;
	}

	public ResultSet getCourse(String kkod) throws SQLException{												//Hämtar 1 kurs från databasen
		PreparedStatement stmtCourse = connect().prepareStatement("select * from kurs where kkod = ?");
		stmtCourse.setString(1, kkod);
		ResultSet rsetCourse = stmtCourse.executeQuery();
		return rsetCourse;
		}

	public int addCourse(String kkod, String kname, String kadress, String poang) throws SQLException {			//Lägg till kurs
		PreparedStatement stmtCourse = connect().prepareStatement("insert into kurs values(?,?,?,?)");
		stmtCourse.setString(1, kkod);
		stmtCourse.setString(2, kname);
		stmtCourse.setString(3, kadress);
		stmtCourse.setString(4, poang);
		int rsetCourse = stmtCourse.executeUpdate();
		return rsetCourse;
	}

	public int deleteCourse(String kkod, String kname, String kadress,String poang) throws SQLException {
		PreparedStatement stmtCourse = connect().prepareStatement("delete from kurs where kkod =? and kname = ? and kadress = ? and poang = ?");
		stmtCourse.setString(1, kkod);
		stmtCourse.setString(2, kname);
		stmtCourse.setString(3, kadress);
		stmtCourse.setString(4, poang);
		int rsetCourse = stmtCourse.executeUpdate();
		return rsetCourse;
	}

	public int updateCourse(String kkod, String kname, String kadress,String poang) throws SQLException {
		PreparedStatement stmtCourse = connect().prepareStatement("UPDATE Kurs SET kname = ?, kadress = ?, poang = ? where kkod = ?");
		stmtCourse.setString(1, kname);
		stmtCourse.setString(2, kadress);
		stmtCourse.setString(3, poang);
		stmtCourse.setString(4, kkod);
		int rsetCourse = stmtCourse.executeUpdate();
		return rsetCourse;
	}

	public ResultSet getCourseStudents(String kkod) throws SQLException{												//Hämtar 1 student från databasen
		PreparedStatement stmtCourseStudents = connect().prepareStatement("select * from laser where kkod = ?");
		stmtCourseStudents.setString(1, kkod);
		ResultSet rsetCourseStudents = stmtCourseStudents.executeQuery();
		return rsetCourseStudents;
		}
	
	public ResultSet getFinishedStudents(String kkod) throws SQLException {
		PreparedStatement stmtFinished = connect().prepareStatement("select * from harLastKurs where kkod = ?");
		stmtFinished.setString(1, kkod);
		ResultSet rsetFinished = stmtFinished.executeQuery();
		return rsetFinished;
	}
	
	
	//Registrering
	public int addStudentToCourse(String spnr, String kkod) throws SQLException {  
		PreparedStatement stmtStudentCourse = connect().prepareStatement("insert into laser values(?,?)");
		stmtStudentCourse.setString(1, spnr);
		stmtStudentCourse.setString(2, kkod);
		int rsetStudentCourse = stmtStudentCourse.executeUpdate();
		return rsetStudentCourse;
	}
	
	public int gradeStudent(String spnr, String kkod, String betyg) throws SQLException{
		PreparedStatement stmtGradeStudent = connect().prepareStatement("insert into harLastKurs values (?, ?, ?)");
		stmtGradeStudent.setString(1, spnr);
		stmtGradeStudent.setString(2, kkod);
		stmtGradeStudent.setString(3, betyg);
		int rsetGradeStudent = stmtGradeStudent.executeUpdate();
		return rsetGradeStudent;
	}
	
	public int removeStudentFromCourse(String spnr, String kkod) throws SQLException{ 
		PreparedStatement stmtRemoveStudent = connect().prepareStatement("delete from laser where spnr = ? and kkod =  ?");
		stmtRemoveStudent.setString(1, spnr);
		stmtRemoveStudent.setString(2, kkod);
		int rsetRemoveStudent = stmtRemoveStudent.executeUpdate();
		return rsetRemoveStudent;
	}

}

