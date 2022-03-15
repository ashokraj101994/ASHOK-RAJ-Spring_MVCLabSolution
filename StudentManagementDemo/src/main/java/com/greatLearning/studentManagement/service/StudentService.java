package com.greatLearning.studentManagement.service;

import java.util.List;

import com.greatLearning.studentManagement.entity.Student;


public interface StudentService {

public List<Student> showAll();
	
	public Student findById(int id);
	
	public void save(Student std);
	
	public void deleteById(int id);
	
}
