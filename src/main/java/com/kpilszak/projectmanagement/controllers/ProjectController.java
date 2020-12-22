package com.kpilszak.projectmanagement.controllers;

import com.kpilszak.projectmanagement.entities.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @GetMapping("/new")
    public String displayProjectForm(Model model) {

        Project project = new Project();

        model.addAttribute("project", project);

        return "new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {

    }
}
