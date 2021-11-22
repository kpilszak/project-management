package com.kpilszak.projectmanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kpilszak.projectmanagement.dto.ChartData;
import com.kpilszak.projectmanagement.dto.EmployeeProject;
import com.kpilszak.projectmanagement.entities.Project;
import com.kpilszak.projectmanagement.services.EmployeeService;
import com.kpilszak.projectmanagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
	
	@Value("${version}")
	private String ver;
	
	final ProjectService projectService;
	final EmployeeService employeeService;
	
	public HomeController(final ProjectService projectService, final EmployeeService employeeService) {
		this.projectService = projectService;
		this.employeeService = employeeService;
	}
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		model.addAttribute("versionNumber", ver);
		
		Map<String, Object> map = new HashMap<>();
		
		List<Project> projects = projectService.getAll();
		model.addAttribute("projects", projects);
		
		List<ChartData> projectData = projectService.getProjectStatus();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		model.addAttribute("projectStatusCount", jsonString);
		
		List<EmployeeProject> employeesProjectCount = employeeService.employeeProjects();
		model.addAttribute("employeesProjectCount", employeesProjectCount);
		
		return "main/home";
	}
}
