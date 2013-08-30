package fr.treeptik.employeemanager.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.employeemanager.dao.GenericDAO;
import fr.treeptik.employeemanager.exception.DAOException;
import fr.treeptik.employeemanager.exception.ServiceException;
import fr.treeptik.employeemanager.service.GenericService;

public abstract class GenericServiceImpl<T, PK, D extends GenericDAO<T, PK>> implements GenericService<T, PK> {

	protected abstract D getDao();

	@Override
	@Transactional
	public T save(T entite) throws ServiceException {
		try {
			getDao().save(entite);
			return entite;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}
	
	@Override
	@Transactional
	public T update(T entite) throws ServiceException {
		try {
			getDao().update(entite);
			return entite;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	@Transactional
	public void remove(PK id) throws ServiceException {
		try {
			getDao().remove(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}
	
	@Override
	public T findById(PK id) throws ServiceException {
		try {
			return getDao().findById(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<T> findAll() throws ServiceException {
		try {
			return getDao().findAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

}
