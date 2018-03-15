/**
 * 
 */
package com.sorpresa.service;

import com.sorpresa.domain.entities.Student;
import com.sorpresa.persistence.student.StudentDao;

/**
 * @author albert.agusti
 *
 */
public class AddressService {
	
	private StudentDao studentDao;
	
	public void set(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public int insert(Student student) {
		int id = studentDao.insert(student);
		return id;
	}
	
	public Student update(Student student) {
		this.studentDao.update(student);
		return student;
	}
	
	public int delete(Student student) {
		this.studentDao.delete(student);
		return student.getIdStudent();
	}
}
