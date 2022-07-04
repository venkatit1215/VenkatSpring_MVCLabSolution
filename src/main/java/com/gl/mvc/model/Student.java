package com.gl.mvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "studente")
public class Student implements Serializable {
 	private static final long serialVersionUID = -5943461472530543260L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  studentId;
 
    @Column
    private String name;
 
    @Column
    private String department;
 
    @Column
    private String country;

    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
    
 
}
