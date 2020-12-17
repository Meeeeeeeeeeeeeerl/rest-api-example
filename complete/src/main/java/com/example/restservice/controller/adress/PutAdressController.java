package com.example.restservice.controller.adress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.model.data.Adress;
import com.example.restservice.model.data.Employee;
import com.example.restservice.storage.EmployeeStorage;

@RestController
@RequestMapping("/api/v1")
public class PutAdressController {

	@Autowired
	EmployeeStorage employees;
	
	//Update adress of specific employee
	@PutMapping("/employee/{id}/adress")
	public ResponseEntity<String> putEmployee(@PathVariable int id, @RequestBody Adress adress) {
		
		if(employees.exists(id)) {
			// get employee from storage
			Employee _employee = employees.get(id);
			
			// update new values
			_employee.getAdress().setStreet(adress.getStreet());
			_employee.getAdress().setPostCode(adress.getPostCode());
			_employee.getAdress().setCity(adress.getCity());
			_employee.getAdress().setCountry(adress.getCountry());
			
			// save again to employee storage
			employees.add(_employee);
			
			return new ResponseEntity<String>("Update successful!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No employee found with id = " + id, HttpStatus.NOT_FOUND);
		}
	}
}
