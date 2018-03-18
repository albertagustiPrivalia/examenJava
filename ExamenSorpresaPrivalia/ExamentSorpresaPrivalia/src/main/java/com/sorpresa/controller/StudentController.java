package com.sorpresa.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.sorpresa.entity.Student;
import com.sorpresa.service.IStudentService;

@Controller
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	@GetMapping("student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@GetMapping("student/{id}/addresses")
	public ResponseEntity<Student> getStudentByIdAddresses(@PathVariable("id") Integer id) {
		Student student = studentService.getStudentById(id);
		return new ResponseEntity < Set < ? extends BaseResponse >> (student.getAddress(), HttpStatus.OK);
	}
	
	@GetMapping("students")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> list = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
	
	@PostMapping("student")
	public ResponseEntity<Void> addStudent(@RequestBody Student student, UriComponentsBuilder builder) {
        boolean flag = studentService.addStudent(student);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/student/{id}").buildAndExpand(student.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("student")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@DeleteMapping("student/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") Integer id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 