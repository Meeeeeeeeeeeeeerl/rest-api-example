package com.example.restservice.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.storage.EmployeeStorage;

@RestController
@RequestMapping("/api/v1")
public class DeleteEmployeeController {
	
    @Autowired
    EmployeeStorage employees;
    
    @DeleteMapping("/employee/{id}")
    public ResponseEntity deleteEmployee(@PathVariable int id){
    	
    	if(!employees.exists(id)) {
    		return new ResponseEntity("No employee found with id = " + id, HttpStatus.NOT_FOUND);
    	} else {
        	employees.delete(id);
            return new ResponseEntity("Deletion successful!", HttpStatus.OK);	
    	}
    }
}