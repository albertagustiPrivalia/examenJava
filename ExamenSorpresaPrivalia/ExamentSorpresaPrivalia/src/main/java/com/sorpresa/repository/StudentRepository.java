package com.sorpresa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sorpresa.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long>  {

}
