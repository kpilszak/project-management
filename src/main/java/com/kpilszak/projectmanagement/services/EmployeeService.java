package com.kpilszak.projectmanagement.services;

import com.kpilszak.projectmanagement.dao.EmployeeRepository;
import com.kpilszak.projectmanagement.dto.EmployeeProject;
import com.kpilszak.projectmanagement.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
	public List<EmployeeProject> employeeProjects() {
		return employeeRepository.employeeProjects();
	}

	public Employee findByEmployeeId(long id) {
		return employeeRepository.findByEmployeeId(id);
	}

	public void delete(Employee employee) {
		employeeRepository.delete(employee);
	}
}
