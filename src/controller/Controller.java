package controller;

import java.sql.*;

import dataaccesslayer.Dal;

public class Controller {
	Dal dal = new Dal();
	
	
	public ResultSet gofetchStudents() throws SQLException {			//hämtar Alla studenter
		return dal.getAllStudents();
	}
	
	public ResultSet getStudent(String spnr) throws SQLException{		//hämtar 1 student
	return dal.getStudent(spnr);
	}
	public ResultSet gofetchCourses() throws SQLException {
		return dal.getAllCourses();
	}
	
	public ResultSet getCourse(String kkod) throws SQLException{
		return dal.getCourse(kkod);
		}
	
	public int addStudent(String spnr,String sname,String sadress,String stel) throws SQLException {
		return dal.addStudent(spnr, sname, sadress, stel);
	}
	
	public int addCourse(String kkod,String kname,String kadress,String poang) throws SQLException {
		return dal.addCourse(kkod, kname, kadress, poang);
	}
	
}
