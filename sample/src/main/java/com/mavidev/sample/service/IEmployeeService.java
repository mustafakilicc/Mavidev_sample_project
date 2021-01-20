package com.mavidev.sample.service;

import java.util.List;

import com.mavidev.sample.dao.entity.Employee;

public interface IEmployeeService {
	public List<Employee> getAll();
	public Employee findByEmpNo(Long empNo);
	public Employee save(Employee employee);
	public Employee update(Employee employee);
	public Employee delete(Employee employee);

}
