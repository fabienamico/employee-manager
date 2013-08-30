package fr.treeptik.employeemanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.employeemanager.dao.EmployeeDAO;
import fr.treeptik.employeemanager.model.Employee;
import fr.treeptik.employeemanager.service.EmployeeService;

@Service
public class EmployeeServiceImpl extends GenericServiceImpl<Employee, Integer, EmployeeDAO> implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;
	
	@Override
	protected EmployeeDAO getDao() {
		return dao;
	}

}
