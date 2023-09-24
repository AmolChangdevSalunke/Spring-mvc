package com.demo.daoi;

import java.util.List;

import com.demo.model.Student;

public interface DaoI {
public int saveRecord(Student stu);
public List<Student>getSingleData(String us,String pw);
public List<Student>getAllData(String us,String pw);
}
