package fr.treeptik.employeemanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.employeemanager.dao.EmployeDAO;
import fr.treeptik.employeemanager.model.Employe;
import fr.treeptik.employeemanager.service.EmployeService;

@Service("employeService")
public class EmployeServiceImpl extends GenericServiceImpl<Employe, Integer, EmployeDAO> implements EmployeService {

	@Autowired
	private EmployeDAO dao;
	
	@Override
	protected EmployeDAO getDao() {
		return dao;
	}

}
