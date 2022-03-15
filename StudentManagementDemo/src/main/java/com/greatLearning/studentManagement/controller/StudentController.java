package com.greatLearning.studentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatLearning.studentManagement.entity.Student;
import com.greatLearning.studentManagement.service.StudentService;



@Controller
@RequestMapping("/student")
public class StudentController {
    
	@Autowired
	StudentService service;


	@RequestMapping("/list")
	public String listBooks(Model theModel) {
       List<Student> std = service.showAll();
       
       for(Student student:std) {
    	   System.out.println(student);
       }
       theModel.addAttribute("Student",std);
       return "list-Students";
	}
	
	@RequestMapping("/save")
	public String saveBook(@RequestParam("id") int id,
			@RequestParam("name") String name,@RequestParam("department") String department,@RequestParam("country") String country) {

		System.out.println(id);
		Student std;
		if(id!=0)
		{
			std=service.findById(id);
			std.setId(id);
			std.setName(name);
			std.setDepartment(department);
			std.setCountry(country);	
		}
		else {
			std=new Student(name, department, country);
		}
        
		
		service.save(std);
		Student student = new Student("Ashok","tech","India");
		System.out.println(student);
		return "redirect:/student/list";
		
		
	}	
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Student student = new Student();

		theModel.addAttribute("Student", student);

		return "Student-form";
	}
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("stdId") int theId,
			Model theModel) {

		// get the Book from the service
		Student student = service.findById(theId);


		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("Student", student);

		// send over to our form
		return "Student-form";		
}  
	@RequestMapping("/delete")
	public String delete(@RequestParam("stdId") int theId) {

		// delete the Book
		service.deleteById(theId);

		// redirect to /Books/list
		return "redirect:/student/list";
	
}

}














