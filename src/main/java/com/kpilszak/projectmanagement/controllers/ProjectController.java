package com.kpilszak.projectmanagement.controllers;

import com.kpilszak.projectmanagement.dao.EmployeeRepository;
import com.kpilszak.projectmanagement.dao.ProjectRepository;
import com.kpilszak.projectmanagement.entities.Employee;
import com.kpilszak.projectmanagement.entities.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    final ProjectRepository projectRepository;
    final EmployeeRepository employeeRepository;
    
    public ProjectController(final ProjectRepository projectRepository, final EmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }
    
    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }
    
    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project project = new Project();
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("project", project);
        model.addAttribute("employees", employees);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        projectRepository.save(project);
        return "redirect:/projects";
    }
}
