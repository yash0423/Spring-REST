package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.Dao.EmployeeDao;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Transactional
	public List<Employee> getAllEmployees(){
		return employeeDao.getAllEmployees();
	}
	
	@Transactional
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
		return employeeDao.getEmployeeById(id);
	}
	@Transactional
	public void updateEmployee(int id, @Valid Employee employee) throws EmployeeNotFoundException {
		employeeDao.updateEmployee(id, employee);
	}
	@Transactional
	public ArrayList<Employee> deleteEmployee(int id) throws EmployeeNotFoundException{
		return employeeDao.deleteEmployee(id);
	}
}
