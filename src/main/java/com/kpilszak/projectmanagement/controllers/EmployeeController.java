package com.kpilszak.projectmanagement.controllers;

import com.kpilszak.projectmanagement.entities.Employee;
import com.kpilszak.projectmanagement.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	final EmployeeService employeeService;
	
	public EmployeeController(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employees = employeeService.getAll();
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
		employeeService.save(employee);
		return "redirect:/employees/new";
	}

	@GetMapping("/update")
	public String displayEmployeeUpdateForm(@RequestParam("id") long id, Model model) {

		Employee employee = employeeService.findByEmployeeId(id);

		model.addAttribute("employee", employee);

		return "employees/new-employee";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") long id, Model model) {
		Employee employee = employeeService.findByEmployeeId(id);

		employeeService.delete(employee);

		return "redirect:/employees";
	}
}
