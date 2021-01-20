package com.mavidev.sample.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mavidev.sample.dao.entity.Employee;

@Repository("employeeDao")
public class EmployeeDao implements IEmployeeDao {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Employee> getAll() {

		Session session = entityManager.unwrap(Session.class);
		Query<Employee> query = session.createQuery("SELECT emp FROM Employee emp", Employee.class);
		List<Employee> result = query.getResultList();
		return result;
	}

	public Employee findByEmpNo(Long empNo) {

		Session session = entityManager.unwrap(Session.class);
		Query<Employee> query = session.createQuery("select emp From Employee emp where emp.empNo=:emp_no");
		query.setParameter("emp_no", empNo);
		Employee emp = query.getSingleResult();
		return emp;
	}

	public Employee save(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.save(employee);
		return employee;
	}

	public Employee update(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.update(employee);
		return employee;
	}

	public Employee delete(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		Employee emp = session.get(Employee.class, employee.getEmpNo());
		session.delete(emp);
		return emp;
	}

	public Long findMaxEmpNo() {

		Session session = entityManager.unwrap(Session.class);
		Query<Long> query = session.createQuery("SELECT MAX(emp.empNo) FROM Employee emp", Long.class);
		Long maxEmpNo = query.getSingleResult();

		return maxEmpNo;
	}

}
