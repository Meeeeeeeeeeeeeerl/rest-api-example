package com.example.restservice.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.model.data.Employee;
import com.example.restservice.model.response.EmployeeResponse;
import com.example.restservice.storage.EmployeeStorage;

@RestController
@RequestMapping("/api/v1")
public class PostEmployeeController {

	@Autowired
	EmployeeStorage employees;

	//Adds a new employee
	@PostMapping("/employee")
	public ResponseEntity<EmployeeResponse> postEmployee(@RequestBody Employee employee) {
		employees.add(employee);
		return new ResponseEntity<EmployeeResponse>(new EmployeeResponse(employee), HttpStatus.CREATED);
	}

}
