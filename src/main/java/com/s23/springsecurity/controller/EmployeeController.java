package com.s23.springsecurity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s23.springsecurity.dto.EmployeeDTO;
import com.s23.springsecurity.entity.Employee;
import com.s23.springsecurity.repo.EmployeeRepo;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("/emp")
@RestController
public class EmployeeController {

	EmployeeRepo empRepo;
	
	public EmployeeController(EmployeeRepo employeeRepo) {
		this.empRepo = employeeRepo;
	}
	
	//Registers a new Employee in the DB
	@PostMapping("/register")
	public Employee registerEmployee(@RequestBody Employee newEmp) {
		return empRepo.save(newEmp);
	}
	
	List<EmployeeDTO> employees = new ArrayList<>();
	{
		populateEmployees();
		System.out.println("Default empList populated...");
	}
	
	@GetMapping("/getAll")
	public List<EmployeeDTO> getAllEmployeeData() {
		return employees;
	}
	
	// Saves user in memory
	@PostMapping("/save")
	public EmployeeDTO addEmployee(@RequestBody EmployeeDTO newEmp) {
		return saveEmployee(newEmp);
	}
	
	// This API will provide the CRSF token which generated (for the requesting client) after Authentication.
	@GetMapping("/getCsrf")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	private void populateEmployees() {
		employees.add(new EmployeeDTO(101, "Saswat", 14500.00));
		employees.add(new EmployeeDTO(102, "Sarita", 22600.00));
		employees.add(new EmployeeDTO(103, "Adi", 6800.00));
		employees.add(new EmployeeDTO(104, "Sanu", 21500.00));
	}
	
	private EmployeeDTO saveEmployee(EmployeeDTO newEmp) {
		employees.add(newEmp);
		return employees.get(employees.size()-1);
	}
	
}
