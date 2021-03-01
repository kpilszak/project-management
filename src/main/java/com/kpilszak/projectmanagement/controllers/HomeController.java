package com.kpilszak.projectmanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kpilszak.projectmanagement.dao.EmployeeRepository;
import com.kpilszak.projectmanagement.dao.ProjectRepository;
import com.kpilszak.projectmanagement.dto.ChartData;
import com.kpilszak.projectmanagement.dto.EmployeeProject;
import com.kpilszak.projectmanagement.entities.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
	final ProjectRepository projectRepository;
	final EmployeeRepository employeeRepository;
	
	public HomeController(final ProjectRepository projectRepository, final EmployeeRepository employeeRepository) {
		this.projectRepository = projectRepository;
		this.employeeRepository = employeeRepository;
	}
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		Map<String, Object> map = new HashMap<>();
		
		List<Project> projects = projectRepository.findAll();
		model.addAttribute("projects", projects);
		
		List<ChartData> projectData = projectRepository.getProjectStatus();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		model.addAttribute("projectStatusCount", jsonString);
		
		List<EmployeeProject> employeesProjectCount = employeeRepository.employeeProjects();
		model.addAttribute("employeesProjectCount", employeesProjectCount);
		
		return "main/home";
	}
}
