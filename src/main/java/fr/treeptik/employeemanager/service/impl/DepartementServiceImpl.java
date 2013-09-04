package fr.treeptik.employeemanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.employeemanager.dao.DepartementDAO;
import fr.treeptik.employeemanager.model.Departement;
import fr.treeptik.employeemanager.service.DepartementService;

@Service("departementService")
public class DepartementServiceImpl extends GenericServiceImpl<Departement, Integer, DepartementDAO> implements DepartementService {

	@Autowired
	private DepartementDAO dao;
	
	@Override
	protected DepartementDAO getDao() {
		return dao;
	}

}
