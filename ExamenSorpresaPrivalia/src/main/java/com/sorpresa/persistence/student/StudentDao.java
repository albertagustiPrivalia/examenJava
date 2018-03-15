package com.sorpresa.persistence.student;

import java.util.Set;

import com.sorpresa.domain.entities.Student;

public interface StudentDao {
	
	public int insert(Student student);
	public void update(Student student);
	public Set<Student> get(int id);
	public int delete(Student address);
}
