package com.kpilszak.projectmanagement.controllers;

import com.kpilszak.projectmanagement.dao.EmployeeRepository;
import com.kpilszak.projectmanagement.dao.ProjectRepository;
import com.kpilszak.projectmanagement.entities.Employee;
import com.kpilszak.projectmanagement.entities.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
	final ProjectRepository projectRepository;
	final EmployeeRepository employeeRepository;
	
	public HomeController(final ProjectRepository projectRepository, final EmployeeRepository employeeRepository) {
		this.projectRepository = projectRepository;
		this.employeeRepository = employeeRepository;
	}
	
	@GetMapping("/")
	public String displayHome(Model model) {
		List<Project> projects = projectRepository.findAll();
		model.addAttribute("projects", projects);
		
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("employees", employees);
		
		return "main/home";
	}
}
