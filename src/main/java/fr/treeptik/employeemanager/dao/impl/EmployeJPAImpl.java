package fr.treeptik.employeemanager.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.employeemanager.dao.EmployeDAO;
import fr.treeptik.employeemanager.model.Employe;

@Repository
public class EmployeJPAImpl extends GenericJPAImpl<Employe, Integer> implements EmployeDAO {

}
