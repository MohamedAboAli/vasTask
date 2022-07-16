package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.AccessCardDTO;
import services.AccessCardServices;

@RestController
@RequestMapping("/accessCard")
public class AccessCardController {
	
	@Autowired
	AccessCardServices accessCardServices;

	@PostMapping("/createAccessCard")
	public String createAccessCard(@RequestBody AccessCardDTO dto) {
		try {
			String status = accessCardServices.createAccessCard(dto);
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@PutMapping("/passingThrougGate")
	public ResponseEntity<String> passingThrougGate(@RequestBody AccessCardDTO dto) {
		try {
			String status = accessCardServices.passingThrougGate(dto);
			return new ResponseEntity<String>(status, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Failed", HttpStatus.BAD_REQUEST);
		}
	}

}
