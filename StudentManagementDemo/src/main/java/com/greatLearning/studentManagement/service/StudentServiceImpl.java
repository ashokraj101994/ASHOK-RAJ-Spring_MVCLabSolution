package com.greatLearning.studentManagement.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatLearning.studentManagement.entity.Student;

@Repository
public class StudentServiceImpl implements StudentService {
 
	private SessionFactory sessionFactory;
	private Session session;
	
	@Override
	@Transactional
	public List<Student> showAll() {
		Transaction transaction = session.beginTransaction();
		List<Student> std=session.createQuery("from Student",Student.class).getResultList();
		transaction.commit();
		return std;
	}
	
	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
		this.session=sessionFactory.openSession();
	}
	@Override
	@Transactional
	public Student findById(int id) {
		Student std = session.get(Student.class,id);
		return std;
	}

	@Override
	@Transactional
	public void save(Student std) {
		session.saveOrUpdate(std);
	
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Student std = session.get(Student.class, id);
		session.delete(std);
	}
	
	
	

}