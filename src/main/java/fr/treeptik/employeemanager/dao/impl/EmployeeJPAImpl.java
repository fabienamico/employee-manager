package fr.treeptik.employeemanager.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.employeemanager.dao.EmployeeDAO;
import fr.treeptik.employeemanager.model.Employee;

@Repository
public class EmployeeJPAImpl extends GenericJPAImpl<Employee, Integer> implements EmployeeDAO {

}
