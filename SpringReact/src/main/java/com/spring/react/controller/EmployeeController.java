package com.spring.react.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.react.service.EmployeeService;
import com.spring.react.model.Employee;

@RestController
public class EmployeeController {
	
	
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/test")
	public String getMessage() {
		return "Hi , from Akash App";
	}
	
	@GetMapping("/employees")
    public List<Employee> getAllEmployees() {
		
        return empService.getAllEmployees();
    }
	
    @PostMapping("/employeesLoad")
    public Employee createEmployee(@RequestBody Employee employee) {
      
         return empService.LoadEmployees(employee);
    }


}
