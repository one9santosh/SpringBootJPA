package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudentDAO {
	@Autowired
	StudentRepository repo;
	//insert a single object
	public Student insert(Student s) {
		return repo.save(s);
	}
	
	
	//retrieve all the objects
	public List<Student> getall(){
		return repo.findAll();
	}
	
	
	//delete
	public String deleteByid(int id) {
		repo.deleteById(id);
		return "deleted the id value:"+id; 
	}
	
	
	//update
	                     //updated value: 1 pavan k@c.c
	public Student update(Student s) {
		Student ss=repo.findById(s.getSid()).orElse(null);
		//in ss we have 1 karthik k@c.c
                   //pavan		
		ss.setName(s.getName());
		ss.setEmail(s.getEmail());
		return repo.save(ss);
	}
	
}
