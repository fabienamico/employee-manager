package fr.treeptik.employeemanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.employeemanager.dao.EquipeDAO;
import fr.treeptik.employeemanager.model.Equipe;
import fr.treeptik.employeemanager.service.EquipeService;

@Service("equipeService")
public class EquipeServiceImpl extends GenericServiceImpl<Equipe, Integer, EquipeDAO> implements EquipeService {

	@Autowired
	private EquipeDAO dao;
	
	@Override
	protected EquipeDAO getDao() {
		return dao;
	}

}
