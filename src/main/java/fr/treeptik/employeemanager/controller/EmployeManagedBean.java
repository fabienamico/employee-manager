package fr.treeptik.employeemanager.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import fr.treeptik.employeemanager.exception.ServiceException;
import fr.treeptik.employeemanager.model.Employe;
import fr.treeptik.employeemanager.model.Equipe;
import fr.treeptik.employeemanager.service.EmployeService;
import fr.treeptik.employeemanager.service.EquipeService;

@ManagedBean(name="employeMB")
public class EmployeManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{employeService}")
	private EmployeService employeService;
	
	@ManagedProperty(value="#{equipeService}")
	private EquipeService equipeService;
	
	private Employe employe = new Employe();
	
	private ListDataModel<Employe> employes;
	
	private List<SelectItem> equipes;
	
	
	public EmployeManagedBean() {
		employe.setEquipe(new Equipe());
	}
	
	
	private void initEmployes() throws ServiceException {
		employes = new ListDataModel<Employe>(employeService.findAll());
	}
	
	public String create() throws ServiceException {
		if (employe.getEquipe().getId() == 0) {
			employe.setEquipe(null);
		}
		employeService.save(employe);
		return "index";
	}
	
	public String initUpdate() throws ServiceException {
		employe = employeService.findById(employes.getRowData().getId());
		return "update";
	}
	
	public String update() throws ServiceException {
		if (employe.getEquipe().getId() == 0) {
			employe.setEquipe(null);
		}
		employeService.update(employe);
		return "index";
	}
	
	public String delete() throws ServiceException {
		employeService.remove(employes.getRowData().getId());
		initEmployes();
		return "index";
	}
	
	
	public EmployeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}

	public EquipeService getEquipeService() {
		return equipeService;
	}

	public void setEquipeService(EquipeService equipeService) {
		this.equipeService = equipeService;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public ListDataModel<Employe> getEmployes() throws ServiceException {
		// pour eviter d'avoir 3 requetes a chaque appel de la liste
		if (employes == null) {
			initEmployes();
		}
		return employes;
	}

	public void setEmployees(ListDataModel<Employe> employees) {
		this.employes = employees;
	}

	public List<SelectItem> getEquipes() throws ServiceException {
		equipes = new ArrayList<SelectItem>();
		for (Equipe equipe : equipeService.findAll()) {
			equipes.add(new SelectItem(equipe.getId(), equipe.getNom()));
		}
		return equipes;
	}

	public void setEquipes(List<SelectItem> equipes) {
		this.equipes = equipes;
	}

}
