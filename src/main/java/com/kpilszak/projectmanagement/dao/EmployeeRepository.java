package com.kpilszak.projectmanagement.dao;

import com.kpilszak.projectmanagement.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
