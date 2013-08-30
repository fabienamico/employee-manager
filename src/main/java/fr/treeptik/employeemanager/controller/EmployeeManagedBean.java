package fr.treeptik.employeemanager.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.treeptik.employeemanager.exception.ServiceException;
import fr.treeptik.employeemanager.model.Employee;
import fr.treeptik.employeemanager.service.EmployeeService;

@ManagedBean(name="employeeMB")
public class EmployeeManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{employeeService}")
	private EmployeeService employeeService;
	
	private Employee employee = new Employee();
	
	public String create() throws ServiceException {
		employeeService.save(employee);
		return "index";
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
