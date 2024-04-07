package com.blind.team.junit;

import org.junit.Test;

import com.blind.team.domain.Employee;
import com.blind.team.service.NameListService;
import com.blind.team.service.TeamException;

public class NameListServiceTest {
	@Test
	public void testGetAllEmployees() {
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		for(int i = 0;i<employees.length;i++) {
			System.out.println(employees[i]);
		}
	}
	@Test
	public void testGetEmployee() {
		NameListService service = new NameListService();
		int id = 101;
		
		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee);
		}catch(TeamException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
