package com.demo.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.daoi.DaoI;
import com.demo.model.Student;
@Repository
public class DaoImpl implements DaoI {
	@Autowired
	SessionFactory sf;

	@Override
	public int saveRecord(Student stu) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(stu);
		tx.commit();
		session.close();

		return stu.getSid();
	}

	@Override
	public List<Student> getSingleData(String us, String pw) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query querry = session.createQuery("from Student where user=:user and pass=:pass");
		querry.setParameter("user", us);
		querry.setParameter("pass", pw);
		List studentList = querry.getResultList();
		tx.commit();
		return studentList;
	}

	@Override
	public List<Student> getAllData(String us, String pw) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query querry = session.createQuery("from Student where user=:user and pass=:pass");
		List studentList = querry.getResultList();
		return studentList;

	}

}
