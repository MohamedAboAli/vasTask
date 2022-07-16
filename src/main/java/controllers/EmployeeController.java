package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.AccessCardDTO;
import dto.EmployeeDTO;
import services.AccessCardServices;
import services.EmployeeServices;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeServices employeeServices;


	@PostMapping("/createEmployee")
	public String createEmployee(@RequestBody EmployeeDTO dto) {
		try {
			String status = employeeServices.createEmployee(dto);
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
}
