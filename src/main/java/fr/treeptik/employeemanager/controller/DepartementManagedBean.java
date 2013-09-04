package fr.treeptik.employeemanager.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import fr.treeptik.employeemanager.exception.ServiceException;
import fr.treeptik.employeemanager.model.Departement;
import fr.treeptik.employeemanager.model.Employe;
import fr.treeptik.employeemanager.service.DepartementService;
import fr.treeptik.employeemanager.service.EmployeService;

@ManagedBean(name="departementMB")
public class DepartementManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{departementService}")
	private DepartementService departementService;
	
	@ManagedProperty(value="#{employeService}")
	private EmployeService employeService;
	
	private Departement departement = new Departement();
	
	private ListDataModel<Departement> departements;
	
	private List<SelectItem> employes;

	
	public DepartementManagedBean() {
		departement.setResponsable(new Employe());
	}
	
	
	private void initDepartements() throws ServiceException {
		departements = new ListDataModel<Departement>(departementService.findAll());
	}
	
	public String create() throws ServiceException {
		departementService.save(departement);
		return "index";
	}

	public String initUpdate() throws ServiceException {
		departement = departementService.findById(departements.getRowData().getId());
		return "update";
	}
	
	public String update() throws ServiceException {
		departementService.update(departement);
		return "index";
	}
	
	public String delete() throws ServiceException {
		departementService.remove(departements.getRowData().getId());
		initDepartements();
		return "index";
	}
	
	public DepartementService getDepartementService() {
		return departementService;
	}

	public void setDepartementService(DepartementService departementService) {
		this.departementService = departementService;
	}
	
	public EmployeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public ListDataModel<Departement> getDepartements() throws ServiceException {
		if (departements == null) {
			initDepartements();
		}
		return departements;
	}

	public void setDepartements(ListDataModel<Departement> departements) {
		this.departements = departements;
	}
	
	public List<SelectItem> getEmployes() throws ServiceException {
		employes = new ArrayList<SelectItem>();
		for (Employe e : employeService.findAll()) {
			employes.add(new SelectItem(e.getId(), e.getLabel()));
		}
		return employes;
	}
	
}
