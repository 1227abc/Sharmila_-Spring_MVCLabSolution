package com.greatLearning.studentManagement.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.greatLearning.studentManagement.entity.Student;

@Repository
public class StudentServiceImpl implements StudentService {
	private SessionFactory sessionfactory;
	private Session session;

	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory) {
		this.session = sessionFactory.openSession();
	}

	@Transactional
	public List<Student> findAll() {
		List<Student> studentList = session.createQuery("from Student", Student.class).list();
		return studentList;
	}

	@Transactional
	public Student findById(int id) {
		Student student = session.get(Student.class, id);
		return student;
	}

	@Transactional
	public void save(Student theStudent) {
		session.beginTransaction();
		session.saveOrUpdate(theStudent);
		session.getTransaction().commit();
	}

	@Transactional
	public void deleteById(int theId) {
		session.beginTransaction();
		Student student = session.get(Student.class, theId);
		System.out.println("Student details:" + student.getId() + student.getName());
		session.delete(student);
		session.getTransaction().commit();

	}

}