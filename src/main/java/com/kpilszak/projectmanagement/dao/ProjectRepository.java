package com.kpilszak.projectmanagement.dao;

import com.kpilszak.projectmanagement.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
