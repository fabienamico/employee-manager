package fr.treeptik.employeemanager.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.employeemanager.dao.EquipeDAO;
import fr.treeptik.employeemanager.model.Equipe;

@Repository
public class EquipeJPAImpl extends GenericJPAImpl<Equipe, Integer> implements EquipeDAO {

}
