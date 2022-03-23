package com.greatLearning.studentManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatLearning.studentManagement.entity.Student;

@Service
public interface StudentService {
	
	
	public List<Student> findAll();
	public Student findById(int id);
	public void save (Student stu);
	public void deleteById(int id);
	

}
