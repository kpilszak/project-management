package com.kpilszak.projectmanagement;

import com.kpilszak.projectmanagement.dao.EmployeeRepository;
import com.kpilszak.projectmanagement.dao.ProjectRepository;
import com.kpilszak.projectmanagement.entities.Employee;
import com.kpilszak.projectmanagement.entities.Project;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
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
