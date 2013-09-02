package fr.treeptik.employeemanager.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.ListDataModel;

import fr.treeptik.employeemanager.exception.ServiceException;
import fr.treeptik.employeemanager.model.Employee;
import fr.treeptik.employeemanager.service.EmployeeService;

@ManagedBean(name="employeeMB")
public class EmployeeManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{employeeService}")
	private EmployeeService employeeService;
	
	private Employee employee = new Employee();
	
	private ListDataModel<Employee> employees;
	
	public String create() throws ServiceException {
		employeeService.save(employee);
		return "index";
	}
	
	public String formUpdate() throws ServiceException {
		employee = employeeService.findById(employees.getRowData().getId());
		return "update";
	}
	
	public String update() throws ServiceException {
		System.out.println(employee);
		employeeService.update(employee);
		return "index";
	}
	
	public String delete() throws ServiceException {
		employeeService.remove(employees.getRowData().getId());
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

	public ListDataModel<Employee> getEmployees() throws ServiceException {
		employees = new ListDataModel<Employee>(employeeService.findAll());
		return employees;
	}

	public void setEmployees(ListDataModel<Employee> employees) {
		this.employees = employees;
	}

}
