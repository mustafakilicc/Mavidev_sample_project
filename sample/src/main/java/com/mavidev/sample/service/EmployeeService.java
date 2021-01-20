package com.mavidev.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mavidev.sample.dao.EmployeeDao;
import com.mavidev.sample.dao.entity.Employee;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Transactional
	public List<Employee> getAll() {

		return employeeDao.getAll();
	}

	@Transactional
	public Employee findByEmpNo(Long empNo) {

		return employeeDao.findByEmpNo(empNo);
	}

	@Transactional
	public Employee save(Employee employee) {

		Long maxId = employeeDao.findMaxEmpNo() + 1;
		employee.setEmpNo(maxId);
		return employeeDao.save(employee);
	}

	@Transactional
	public Employee update(Employee employee) {

		return employeeDao.update(employee);
	}

	@Transactional
	public Employee delete(Employee employee) {

		return employeeDao.delete(employee);
	}

}
