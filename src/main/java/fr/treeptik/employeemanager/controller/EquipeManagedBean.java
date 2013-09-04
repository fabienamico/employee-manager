package fr.treeptik.employeemanager.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import fr.treeptik.employeemanager.exception.ServiceException;
import fr.treeptik.employeemanager.model.Departement;
import fr.treeptik.employeemanager.model.Employe;
import fr.treeptik.employeemanager.model.Equipe;
import fr.treeptik.employeemanager.service.DepartementService;
import fr.treeptik.employeemanager.service.EmployeService;
import fr.treeptik.employeemanager.service.EquipeService;

@ManagedBean(name="equipeMB")
public class EquipeManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{equipeService}")
	private EquipeService equipeService;

	@ManagedProperty(value="#{employeService}")
	private EmployeService employeService;
	
	@ManagedProperty(value="#{departementService}")
	private DepartementService departementService;
	
	private Equipe equipe = new Equipe();
	
	private ListDataModel<Equipe> equipes;
	
	private List<SelectItem> employes;

	private List<SelectItem> departements;

	
	public EquipeManagedBean() {
		equipe.setChef(new Employe());
		equipe.setDepartement(new Departement());
	}
	
	
	private void initEquipes() throws ServiceException {
		equipes = new ListDataModel<Equipe>(equipeService.findAll());
	}
	
	public String create() throws ServiceException {
		equipeService.save(equipe);
		return "index";
	}
	
	public String initUpdate() throws ServiceException {
		equipe = equipeService.findById(equipes.getRowData().getId());
		return "update";
	}
	
	public String update() throws ServiceException {
		equipeService.update(equipe);
		return "index";
	}
	
	public String delete() throws ServiceException {
		equipeService.remove(equipes.getRowData().getId());
		initEquipes();
		return "index";
	}
	
	
	public EquipeService getEquipeService() {
		return equipeService;
	}

	public void setEquipeService(EquipeService equipeService) {
		this.equipeService = equipeService;
	}

	public EmployeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}

	public DepartementService getDepartementService() {
		return departementService;
	}

	public void setDepartementService(DepartementService departementService) {
		this.departementService = departementService;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public ListDataModel<Equipe> getEquipes() throws ServiceException {
		if (equipes == null) {
			initEquipes();
		}
		return equipes;
	}

	public void setEquipes(ListDataModel<Equipe> equipes) {
		this.equipes = equipes;
	}

	public List<SelectItem> getEmployes() throws ServiceException {
		employes = new ArrayList<SelectItem>();
		for (Employe e : employeService.findAll()) {
			employes.add(new SelectItem(e.getId(), e.getLabel()));
		}
		return employes;
	}

	public List<SelectItem> getDepartements() throws ServiceException {
		departements = new ArrayList<SelectItem>();
		for (Departement d : departementService.findAll()) {
			departements.add(new SelectItem(d.getId(), d.getNom()));
		}
		return departements;
	}
	
}
