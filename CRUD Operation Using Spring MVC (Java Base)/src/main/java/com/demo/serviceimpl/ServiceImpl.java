package com.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.daoi.DaoI;
import com.demo.model.Student;
import com.demo.serviceI.ServiceI;
@Service
public class ServiceImpl implements ServiceI{
@Autowired
DaoI di;
	@Override
	public int saveRecord(Student stu) {
		// TODO Auto-generated method stub
		return di.saveRecord(stu);
	}

	@Override
	public List<Student> getSingleData(String us, String pw) {
		// TODO Auto-generated method stub
		return di.getSingleData(us, pw);
	}

	@Override
	public List<Student> getAllData(String us, String pw) {
		// TODO Auto-generated method stub
		return di.getAllData(us, pw);
	}

}
