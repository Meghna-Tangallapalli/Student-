package com.demostudent.api.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Student")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id;
	private String name;
	private String email;
	private String phoneNumber;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public StudentEntity(long id, String name, String email, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public StudentEntity() {
		super();
		
	}
	
	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}           
	
	
	
}
