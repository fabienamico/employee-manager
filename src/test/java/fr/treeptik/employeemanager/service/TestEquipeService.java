package fr.treeptik.employeemanager.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.employeemanager.exception.ServiceException;
import fr.treeptik.employeemanager.model.Employe;
import fr.treeptik.employeemanager.model.Equipe;
import fr.treeptik.employeemanager.model.Departement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class TestEquipeService {

	@Autowired
	private EmployeService employeeService;
	
	@Autowired
	private EquipeService equipeService;
	
	@Autowired
	private DepartementService serviceService;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testSave() {
		
		try {
			Employe employeeChef = employeeService.save(new Employe(null, "Benoit", "Thomas", "toto", "toto", null));
			
			Departement service = serviceService.save(new Departement(null, "service1", employeeChef));
			
			Equipe equipe = equipeService.save(new Equipe(null, "equipe1", service, employeeChef));
			
			employeeService.save(new Employe(null, "Benoit2", "Thomas2", "toto2", "toto2", equipe));

			Assert.assertTrue(true);
		} catch (ServiceException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
}
