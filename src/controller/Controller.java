package controller;

import java.sql.*;

import dataaccesslayer.Dal;

public class Controller {
	Dal dal = new Dal();
	
	//Studentmetoder
	public ResultSet gofetchStudents() throws SQLException {											//hämtar Alla studenter (till listan)
		return dal.getAllStudents();
	}
	
	public ResultSet getStudent(String spnr) throws SQLException{										//hämtar 1 student
	return dal.getStudent(spnr);
	}
	
	public ResultSet getStudentOnCourse(String spnr) throws SQLException{										//hämtar 1 student
		return dal.getStudentOnCourse(spnr);
	}

	public int addStudent(String spnr,String sname,String sadress,String stel) throws SQLException {	//Lägg till student
		return dal.addStudent(spnr, sname, sadress, stel);
	}
	
	public int deleteStudent(String spnr, String sname, String sadress, String stel) throws SQLException{	//Ta bort student
		return dal.deleteStudent(spnr,sname,sadress,stel);
	}
	
	public int updateStudent(String spnr, String sname, String sadress, String stel) throws SQLException{
		return dal.updateStudent(spnr, sname, sadress, stel);
	}
	
	//Kursmetoder
	public ResultSet gofetchCourses() throws SQLException {												//Hämtar alla kurser (till listan)
		return dal.getAllCourses();
	}
	
	public ResultSet getCourse(String kkod) throws SQLException{										//Hämtar 1 kurs
		return dal.getCourse(kkod);
		}
	
	public int addCourse(String kkod,String kname,String kadress,String poang) throws SQLException {	//Lägg till kurs
		return dal.addCourse(kkod, kname, kadress, poang);
	}
	
	public int deleteCourse(String kkod, String kname, String kadress, String poang) throws SQLException{	//Ta bort kurs
		return dal.deleteCourse(kkod,kname,kadress,poang);
	}

	
	public int updateCourse(String kkod, String kname, String kadress, String poang) throws SQLException {
		return dal.updateCourse(kkod, kname, kadress, poang);
	}

	public ResultSet getCourseStudents(String kkod) throws SQLException {
		return dal.getCourseStudents(kkod);
	}
	
	

	
	
	//Registrering
	
	public int addStudentToCourse(String spnr, String kkod) throws SQLException{ 
		return dal.addStudentToCourse(spnr, kkod);
	}

	public int gradeStudent(String spnr, String kkod, String betyg) throws SQLException{
		return dal.gradeStudent(spnr, kkod, betyg);
	}	
}
