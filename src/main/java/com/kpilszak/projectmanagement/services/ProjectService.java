package com.kpilszak.projectmanagement.services;

import com.kpilszak.projectmanagement.dao.ProjectRepository;
import com.kpilszak.projectmanagement.dto.ChartData;
import com.kpilszak.projectmanagement.entities.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

	private final ProjectRepository projectRepository;
	
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	public Project save(Project project) {
		return projectRepository.save(project);
	}
	
	public List<Project> getAll() {
		return projectRepository.findAll();
	}
	
	public List<ChartData> getProjectStatus() {
		return projectRepository.getProjectStatus();
	}
	
}
