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
import fr.treeptik.employeemanager.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class TestEmployeeService {

	@Autowired
	private EmployeeService employeeService;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testSave() {
		
		Employee employee = new Employee(null, "Benoit", "Thomas", "toto", "toto");
		
		try {
			employeeService.save(employee);
			Assert.assertTrue(true);
		} catch (ServiceException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
}
