package com.sorpresa.client;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sorpresa.entity.Address;
import com.sorpresa.entity.Student;

public class RestClientUtil {
	
    public void getStudentByIdDemo() {
    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
    RestTemplate rest = new RestTemplate();
    
    String url = "http://localhost:8080/student/{id}";
    
    HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
    ResponseEntity<Student> responseEntity = rest.exchange(url, HttpMethod.GET, requestEntity, Student.class, 1);
    Student student = responseEntity.getBody();
    System.out.println("Id:"+ student.getId());      
    }
    
	public void getAllStudentsDemo() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate rest = new RestTemplate();
        
	    String url = "http://localhost:8080/students";
	    
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Student[]> responseEntity = rest.exchange(url, HttpMethod.GET, requestEntity, Student[].class);
        Student[] students = responseEntity.getBody();
        for(Student student : students) {
              System.out.println("Id:"+student.getId());
        }
    }
	
    public void addStudentDemo() {
    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate rest = new RestTemplate();
        
	    String url = "http://localhost:8080/student";
	    Student student = new Student();
	    student.setId(2);
	    student.setAge("18");
	    student.setName("albert");
	    student.setSurname("agusti");
	    Address a = new Address();
	    Set<Address> addresses = new HashSet<Address>();
	    addresses.add(a);
	    a.setId(Long.getLong("1"));
	    a.setPostalCode("08186");
	    a.setStreet("aaaaaaa");
	    student.setAddress(addresses);

        HttpEntity<Student> requestEntity = new HttpEntity<Student>(student, headers);
        URI uri = rest.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    
    public void updateStudentDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate rest = new RestTemplate();
        
	    String url = "http://localhost:8080/student";
	    Student student = new Student();
	    student.setId(2);
	    student.setAge("18");
	    student.setName("albert");
	    student.setSurname("agusti");
        HttpEntity<Student> requestEntity = new HttpEntity<Student>(student, headers);
        rest.put(url, requestEntity);
    }
    
    public void deleteStrudentDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate rest = new RestTemplate();
	    String url = "http://localhost:8080/student/{id}";
        HttpEntity<Student> requestEntity = new HttpEntity<Student>(headers);
        rest.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();

    	util.getAllStudentsDemo();    	
    }    
}
