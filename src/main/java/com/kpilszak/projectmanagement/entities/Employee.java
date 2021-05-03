package com.kpilszak.projectmanagement.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
	@Id
	@SequenceGenerator(name = "employee_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
	private long employeeId;
	private String firstName;
	private String lastName;
	private String email;
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee",
			joinColumns = @JoinColumn(name = "employee_id"),
			inverseJoinColumns = @JoinColumn(name = "project_id")
	)
	private List<Project> projects;
	
	public Employee() {
	}
	
	public Employee(final String firstName, final String lastName, final String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public long getId() {
		return employeeId;
	}
	
	public void setId(final long employeeId) {
		this.employeeId = employeeId;
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
	
	public List<Project> getProjects() { return projects; }
	
	public void setProjects(final List<Project> projects) { this.projects = projects; }
}
