package com.greatLearning.studentManagement.main;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatLearning.studentManagement.entity.Student;
import com.greatLearning.studentManagement.service.StudentService;
import com.greatLearning.studentManagement.service.StudentServiceImpl;

public class Appmain {

	public static void main(String[] args) {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
		SessionFactory sessionFactory = con.buildSessionFactory();

		StudentService studentService = new StudentServiceImpl(sessionFactory);

	}

}
