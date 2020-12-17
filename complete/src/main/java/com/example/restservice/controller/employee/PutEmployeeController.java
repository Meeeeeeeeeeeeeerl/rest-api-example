package com.example.restservice.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.model.data.Employee;
import com.example.restservice.storage.EmployeeStorage;

@RestController
@RequestMapping("/api/v1")
public class PutEmployeeController {

	@Autowired
	EmployeeStorage employees;
	
	//puts employee into specified location
	@PutMapping("/employee/{id}")
	public ResponseEntity<String> putEmployee(@PathVariable int id, @RequestBody Employee employee) {
		
		if(employees.exists(id)) {
			// get employee from storage
			Employee _employee = employees.get(id);
			
			// update new values
			_employee.setName(employee.getName());
			_employee.setSalary(employee.getSalary());
			_employee.setBirthday(employee.getBirthday());
			
			// save again to employee storage
			employees.add(_employee);
			
			return new ResponseEntity<String>("Update successful!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Not employee found with id = " + id, HttpStatus.NOT_FOUND);
		}
	}
}
