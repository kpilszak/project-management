package com.kpilszak.projectmanagement.controllers;

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
    
    public ProjectController(final ProjectRepository projectRepository) {this.projectRepository = projectRepository;}
    
    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }
    
    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        projectRepository.save(project);
        return "redirect:/projects/new";
    }
}
