package com.example.restservice.storage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.restservice.model.data.Adress;
import com.example.restservice.model.data.Employee;
import com.example.restservice.model.response.EmployeeResponse;

@Component("employeeStorage")
public class EmployeeStorage {
	
	private Map<Integer, Employee> _employees = new HashMap<Integer, Employee>();
	
    @PostConstruct
    public void init() throws Exception {
        Employee jack = new Employee(1, "Jack Daniels", 2100, new GregorianCalendar(1989, Calendar.JANUARY, 3).getTime(), "Duererstr. 13", "68163", "Mannheim", "Germany");
        Employee peter = new Employee(2, "Peter Pan", 2300, new GregorianCalendar(1993, Calendar.JUNE, 17).getTime(), "Maxstr. 42", "13337", "Berlin", "Germany");
        Employee david = new Employee(3, "David Davidson", 2600, new GregorianCalendar(1985, Calendar.MAY, 22).getTime(), "Straßenstr. 2", "01008", "Bobheim", "Germany");
 
        _employees.put(jack.getId(), jack);
        _employees.put(peter.getId(), peter);
        _employees.put(david.getId(), david);
    }
	
    public void add(Employee employee) {
    	_employees.put(employee.getId(), employee);
    }
    
    public Employee get(int id) {
    	return _employees.get(id);
    }
    
    public Employee delete(int id) {
    	return _employees.remove(id);
    }

    public boolean exists(int id) {
    	if(_employees.containsKey(id)) return true;
    	return false;
    }
    
    public ArrayList<Employee> getAllEmployees() {
    	return (ArrayList<Employee>) _employees.values();
    }   
    
    public ArrayList<EmployeeResponse> getAllEmployeeResponses() {
    	
    	ArrayList<EmployeeResponse> list = new ArrayList<EmployeeResponse>();
    	for(int i = 1; i < _employees.size() + 1; i++) {
    		list.add(new EmployeeResponse(_employees.get(i)));
    	}
    	return list;
    } 
}