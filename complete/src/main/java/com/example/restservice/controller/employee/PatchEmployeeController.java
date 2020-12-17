package com.example.restservice.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.model.data.Employee;
import com.example.restservice.storage.EmployeeStorage;

@RestController
@RequestMapping("/api/v1")
public class PatchEmployeeController {

	@Autowired 
	EmployeeStorage employees;
	
	//Update salary of specified employee
	@PatchMapping("/employee")
	public ResponseEntity patchSalaryUpdate(@RequestBody Employee employee){
		
		if(employees.exists(employee.getId())) {
			// get employee from storage
			Employee _employee = employees.get(employee.getId());
			
			// update new values
			_employee.setSalary(employee.getSalary());
			
			// save again to employee storage
			employees.add(_employee);
			
			return new ResponseEntity("Update successful!", HttpStatus.OK);
		} else {
			return new ResponseEntity("No employee found with id = " + employee.getId(), HttpStatus.NOT_FOUND);
		}
	}
}
