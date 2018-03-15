package com.sorpresa.domain.entities;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStudent;
	private String name;
	private String age;
	private HashSet<Address> addresses = new HashSet<Address>();
	
	/**
	 * @return  HashSet
	 */
	public HashSet<Address> getAddresses() {
		return addresses;
	}


	/**
	 * @param addresses the addresses to set
	 */
	public void setAddress(Address address) {
		this.addresses.add(address);
	}

	
	/**
	 * @return the idStudent
	 */
	public int getIdStudent() {
		return idStudent;
	}


	/**
	 * @param idStudent the idStudent to set
	 */
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.setAge(age);
	}
	


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idStudent;
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (idStudent != other.idStudent)
			return false;
		return true;
	}


	public Student() {
	}
	

}
