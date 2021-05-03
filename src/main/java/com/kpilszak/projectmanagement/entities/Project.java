package com.kpilszak.projectmanagement.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {
	
	@Id
	@SequenceGenerator(name = "project_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
	private long projectId;
	private String name;
	private String stage; //NOTSTARTED, COMPLETED, INPROGRESS
	private String description;
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee",
			joinColumns = @JoinColumn(name = "project_id"),
			inverseJoinColumns = @JoinColumn(name = "employee_id")
	)
	private List<Employee> employees;
	
	public Project() {
	
	}
	
	public  Project(String name, String stage, String description) {
		this.name = name;
		this.stage = stage;
		this.description = description;
	}
	
	public long getId() {
		return projectId;
	}
	
	public void setId(long projectId) {
		this.projectId = projectId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStage() {
		return stage;
	}
	
	public void setStage(String stage) {
		this.stage = stage;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Employee> getEmployees() { return employees; }
	
	public void setEmployees(final List<Employee> employees) { this.employees = employees; }
	
	public void addEmployee(final Employee employee) {
		if (employees == null) {
			employees = new ArrayList<>();
		}
		
		employees.add(employee);
	}
}
