package fr.treeptik.employeemanager.dao;

import java.util.List;

import fr.treeptik.employeemanager.exception.DAOException;

public interface GenericDAO <T, PK> {

	T save(T entite) throws DAOException;
	T update(T entite) throws DAOException;
	void remove(PK id) throws DAOException;
	T findById(PK id) throws DAOException;
	List<T> findAll() throws DAOException;
	
}
