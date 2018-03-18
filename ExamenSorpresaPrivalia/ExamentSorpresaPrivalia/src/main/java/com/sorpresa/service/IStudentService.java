package com.sorpresa.service;

import java.util.List;

import com.sorpresa.entity.Student;

public interface IStudentService {
     List<Student> getAllStudents();
     Student getStudentById(long id);
     boolean addStudent(Student student);
     void updateStudent(Student student);
     void deleteStudent(long id);
}
