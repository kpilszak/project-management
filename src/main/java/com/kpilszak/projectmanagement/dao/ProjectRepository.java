package com.kpilszak.projectmanagement.dao;

import com.kpilszak.projectmanagement.dto.ChartData;
import com.kpilszak.projectmanagement.dto.TimeChartData;
import com.kpilszak.projectmanagement.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

	@Override
	List<Project> findAll();
	
	@Query(nativeQuery = true, value = "SELECT stage as label, COUNT(*) as value " +
			                                   "FROM project " +
			                                   "GROUP BY stage")
	List<ChartData> getProjectStatus();

	@Query(nativeQuery = true, value = "SELECT name as projectName, start_date as startDate, end_date as endDate " +
	"FROM project")
	List<TimeChartData> getTimeData();
}
