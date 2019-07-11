package com.sethi.aayush.springrest.demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sethi.aayush.springrest.demo.entity.Student;
import com.sethi.aayush.springrest.demo.exception.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentController {

	List<Student> studentList;

	@PostConstruct
	public void loadStudentData() {
		studentList = new ArrayList<>();
		studentList.add(new Student("Aman", "Gandhi"));
		studentList.add(new Student("Vivek", "Singh"));
		studentList.add(new Student("Sid", "Bengali"));
	}

	@GetMapping("/student")
	public List<Student> getAllStudents() {
		return studentList;
	}

	@GetMapping("/student/{studentId}")
	public Student getStudentFromId(@PathVariable int studentId) {
		if ((!studentList.isEmpty() && studentList.size() < studentId + 1) || studentId < 0) {
			throw new StudentNotFoundException("Student id is not found - " + studentId);
		}
		return studentList.get(studentId);
	}

	
}
