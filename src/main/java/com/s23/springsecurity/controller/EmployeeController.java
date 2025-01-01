package com.s23.springsecurity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s23.springsecurity.dto.Employee;

@RequestMapping("/emp")
@RestController
public class EmployeeController {

	List<Employee> employees = new ArrayList<>();
	{
		populateEmployees();
		System.out.println("Default empList populated...");
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAllEmployeeData() {
		return employees;
	}
	
	@PostMapping("/save")
	public Employee addEmployee(Employee newEmp) {
		return saveEmployee(newEmp);
	}
	
	private void populateEmployees() {
		employees.add(new Employee(101, "Saswat", 14500.00));
		employees.add(new Employee(102, "Sarita", 22600.00));
		employees.add(new Employee(103, "Adi", 6800.00));
		employees.add(new Employee(104, "Sanu", 21500.00));
	}
	
	private Employee saveEmployee(Employee newEmp) {
		employees.add(newEmp);
		return employees.get(employees.size()-1);
	}
	
}
