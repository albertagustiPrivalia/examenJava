package com.sorpresa.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sorpresa.entity.Address;
import com.sorpresa.entity.Student;
import com.sorpresa.repository.StudentRepository;
@Service
public class StudentService implements IStudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student getStudentById(long studentId) {
		Optional<Student> obj = this.studentRepository.findById(studentId);
		return obj.get();
	}	
	
	@Override
	public List<Student> getAllStudents(){
		List<Student> list = new ArrayList<Student>();
		Page<Student> page = (Page<Student>) this.studentRepository.findAll();
		list = page.getContent();
		return list;
	}
	
	@Override
	public boolean addStudent(Student student){

	   Optional<Student> optional = this.studentRepository.findById(student.getId());

       if (optional.empty() != null) {
    			this.studentRepository.save(student);
    	   		return true;
       } else {
    	   		return false;
       }
	}
	
	@Override
	public void updateStudent(Student student) {
		this.studentRepository.save(student);
	}
	
	@Override
	public void deleteStudent(long studentId) {
		this.studentRepository.delete(getStudentById(studentId));
	}
	
	public Set<Address> getAddressesByStudent(long studentID) {
		
		   Optional<Student> optional = this.studentRepository.findById(studentID);

	       if (optional.empty() != null) {
	    			Student s = optional.get();
	    	   		return s.getAddress();
	       } else {
	    	   		return new HashSet<>();
	       }
	}
}
