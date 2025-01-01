package com.s23.springsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.s23.springsecurity.entity.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {

}
