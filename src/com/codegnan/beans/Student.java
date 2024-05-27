package com.codegnan.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
	int id;
	String name;
	String email;
	String branch;
}
//	public Student() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public Student(int id, String name, String email, String branch) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.email = email;
//		this.branch = branch;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getBranch() {
//		return branch;
//	}
//	public void setBranch(String branch) {
//		this.branch = branch;
//	}
//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", branch=" + branch + "]";
//	}
//	
//
//}
