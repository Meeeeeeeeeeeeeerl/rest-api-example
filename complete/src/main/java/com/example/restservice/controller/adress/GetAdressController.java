package com.example.restservice.controller.adress;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.model.data.Adress;
import com.example.restservice.model.data.Employee;
import com.example.restservice.model.response.AdressResponse;
import com.example.restservice.storage.EmployeeStorage;

@RestController
@RequestMapping("/api/v1")
public class GetAdressController {

	@Autowired
	EmployeeStorage employees;
	
	//Get adress of a specific employee
	@GetMapping("/employee/{id}/adress")
	public ResponseEntity<?> getEmployee(@PathVariable int id) {
		if(employees.exists(id)) {
			return new ResponseEntity<AdressResponse>(new AdressResponse(employees.get(id).getAdress()), HttpStatus.OK);	
		} else {
			return new ResponseEntity<String>("No employee found with id = " + id, HttpStatus.NOT_FOUND);
		}
	}
}
