package com.kpilszak.projectmanagement.controllers;

import com.kpilszak.projectmanagement.dao.EmployeeRepository;
import com.kpilszak.projectmanagement.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	final EmployeeRepository employeeRepository;
	
	public EmployeeController(final EmployeeRepository employeeRepository) {this.employeeRepository = employeeRepository;}
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		employeeRepository.save(employee);
		return "redirect:/employees/new";
	}
}
