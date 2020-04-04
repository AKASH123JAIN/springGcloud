package com.spring.react.service;

import java.util.ArrayList;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.react.model.Employee;
import com.spring.react.repository.EmployeeRepository;

import reactor.core.publisher.Flux;

@Service
public class EmployeeService {
	

	@Autowired
	EmployeeRepository empRepo;
	
	public Employee LoadEmployees(Employee emp) {
		
		empRepo.save(emp);
		return empRepo.getOne(emp.getId());
		
	}
	
	 public List<Employee> getAllEmployees() {
		 
		 List<Employee> testingList = new ArrayList<Employee>();
		 testingList = empRepo.findAll();
		/*
		 * List<String> testingNames = new ArrayList<String>(); for(int i =0 ;
		 * i<testingList.size(); i++) {
		 * testingNames.add(testingList.get(i).getFirstName());
		 * 
		 * }
		 */
		 
		 List<String> testingNames = testingList.stream().map(emp->emp.getFirstName()).collect(Collectors.toList());
		 System.out.println(testingNames);
		 
		 Flux<Integer> j = Flux.just(1, 2, 3, 4, 5);

		 j.map(i -> i * 10)
		   .subscribe(System.out::println);

		 j.map(i -> i + 5)
		   .subscribe(System.out::println);
		 
		 
	        return empRepo.findAll();
	 }
	

}
