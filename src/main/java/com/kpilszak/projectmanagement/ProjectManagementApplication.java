package com.kpilszak.projectmanagement;

import com.kpilszak.projectmanagement.dao.EmployeeRepository;
import com.kpilszak.projectmanagement.dao.ProjectRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.kpilszak.projectmanagement", "com.kpilszak.utils"})
public class ProjectManagementApplication {
	
	private final EmployeeRepository employeeRepository;
	private final ProjectRepository projectRepository;
	
	public ProjectManagementApplication(final EmployeeRepository employeeRepository,
			final ProjectRepository projectRepository) {
		this.employeeRepository = employeeRepository;
		this.projectRepository = projectRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
}
