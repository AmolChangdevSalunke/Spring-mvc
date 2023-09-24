package com.demo.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Student;
import com.demo.serviceI.ServiceI;

@RestController
public class HomeController {
	@Autowired
	ServiceI si;

	@RequestMapping("/reg")
	public String saveStudent(@ModelAttribute Student stu) {
		System.out.println(stu.getSid());
		int id = si.saveRecord(stu);

		if (id > 0) {
			return "index.jsp";
		} else {
			return "register.jsp";
		}


	}

	@RequestMapping("/log")
	public String getData(@RequestParam("user") String us, @RequestParam("pass") String pw) {
		if (us.equals(us) && pw.equals(pw)) {
			List<Student> singleData = si.getSingleData(us, pw);
			Iterator<Student> itr = singleData.iterator();
			while (itr.hasNext()) {
				Student st = itr.next();
				System.out.println(st.getSid());
				System.out.println(st.getSname());
				System.out.println(st.getAdrs());
				System.out.println(st.getUser());
				System.out.println(st.getPass());

		
			}
		} else if (us.equals("admin") && pw.equals("1234")) {
			List<Student> studentList = si.getAllData(us, pw);
			Iterator<Student> itr = studentList.iterator();
			while (itr.hasNext()) {
				Student s = new Student();
				System.out.println(s.getSid());
				System.out.println(s.getSname());
				System.out.println(s.getAdrs());
				System.out.println(s.getUser());
				System.out.println(s.getPass());
				System.out.println("****************");
			

		}
		return "index.jsp";
	}
		return "index.jsp";
}}