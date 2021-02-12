package com.kpilszak.projectmanagement.entities;

import javax.persistence.*;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
	fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private Project project;
	
	public Employee() {
	}
	
	public Employee(final String firstName, final String lastName, final String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(final long employeeId) {
		this.id = employeeId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(final String email) {
		this.email = email;
	}
	
	public Project getProject() {
		return project;
	}
	
	public void setProject(final Project project) {
		this.project = project;
	}
}
