package com.example.restservice.controller.employee;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.model.data.Employee;
import com.example.restservice.model.response.EmployeeResponse;
import com.example.restservice.storage.EmployeeStorage;

@RestController
@RequestMapping("/api/v1")
public class GetEmployeeController {

	@Autowired
	EmployeeStorage employees;
	
	//Get employee by id
	@GetMapping("/employee/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable int id) {
		if(employees.exists(id)) {
			return new ResponseEntity<EmployeeResponse>(new EmployeeResponse(employees.get(id)), HttpStatus.OK);	
		} else {
			return new ResponseEntity<String>("No employee found with id = " + id, HttpStatus.NOT_FOUND);
		}
	}

	//Get all employees
	@GetMapping("/employee")
	public ResponseEntity<Collection<EmployeeResponse>> getAllEmployees() {
		return new ResponseEntity<Collection<EmployeeResponse>> (employees.getAllEmployeeResponses(), HttpStatus.OK);
	}
	
	
	
}
