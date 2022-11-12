package com.kpilszak.projectmanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kpilszak.projectmanagement.dto.TimeChartData;
import com.kpilszak.projectmanagement.entities.Employee;
import com.kpilszak.projectmanagement.entities.Project;
import com.kpilszak.projectmanagement.services.EmployeeService;
import com.kpilszak.projectmanagement.services.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    final ProjectService projectService;
    final EmployeeService employeeService;
    
    public ProjectController(final ProjectService projectService, final EmployeeService employeeService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
    }
    
    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = projectService.getAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }
    
    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project project = new Project();
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("project", project);
        model.addAttribute("employees", employees);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        projectService.save(project);
        return "redirect:/projects";
    }

    @GetMapping("/timelines")
    public String displayProjectTimelines(Model model) throws JsonProcessingException {
        List<TimeChartData> timelineData = projectService.getTimeData();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonTimelineString = objectMapper.writeValueAsString(timelineData);

        model.addAttribute("projectTimeList", jsonTimelineString);

        return "projects/project-timelines";
    }
}
