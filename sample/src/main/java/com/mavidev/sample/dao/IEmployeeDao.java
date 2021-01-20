package com.mavidev.sample.dao;

import java.util.List;

import com.mavidev.sample.dao.entity.Employee;


public interface IEmployeeDao {
	public List<Employee> getAll();
	public Employee findByEmpNo(Long empNo);
	public Employee save(Employee employee);
	public Employee update(Employee employee);
	public Employee delete(Employee employee);
}
