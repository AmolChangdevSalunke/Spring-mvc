package com.demo.serviceI;

import java.util.List;

import com.demo.model.Student;

public interface ServiceI {
	public int saveRecord(Student stu);
	public List<Student> getSingleData(String us, String pw);
	public List<Student> getAllData(String us, String pw);
	
	
	

}
