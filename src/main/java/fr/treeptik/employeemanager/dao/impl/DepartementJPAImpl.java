package fr.treeptik.employeemanager.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.employeemanager.dao.DepartementDAO;
import fr.treeptik.employeemanager.model.Departement;

@Repository
public class DepartementJPAImpl extends GenericJPAImpl<Departement, Integer> implements DepartementDAO {

}
