package com.mavidev.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mavidev.sample.dao.entity.Employee;
import com.mavidev.sample.service.EmployeeService;

@RestController
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/employee/list", method = RequestMethod.GET)
	public List<Employee> getAllEmployee() {

		return employeeService.getAll();
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public Employee findByEmpNo(@PathVariable("id") Long id) {

		return employeeService.findByEmpNo(id);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public Employee save(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	@RequestMapping(value = "employee/delete", method = RequestMethod.POST)
	public Employee delete(@RequestBody Employee employee) {
		return employeeService.delete(employee);
	}

}
