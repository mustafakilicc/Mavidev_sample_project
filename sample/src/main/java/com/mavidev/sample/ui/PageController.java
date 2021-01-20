package com.mavidev.sample.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mavidev.sample.dao.entity.Employee;
import com.mavidev.sample.service.EmployeeService;

@Controller
@RequestMapping("/pages")
public class PageController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainPage() {
		return "index.html";
	}

	@RequestMapping(value = "/employee/list", method = RequestMethod.GET)
	public String getAllEmployee(Model model) {
		List<Employee> employees = employeeService.getAll();
		model.addAttribute("employees", employees);
		return "thyme_employee_list";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String getBookSavePage(Employee employee) {

		return "thyme_employee_save";
	}

	@RequestMapping(value = "employee", method = RequestMethod.POST)
	public String save(Employee employee, BindingResult result, Model model) {

		employeeService.save(employee);
		model.addAttribute("employees", employeeService.getAll());

		return "thyme_employee_list";
	}

}
