package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.AccessCardDTO;
import dto.CarDTO;
import services.CarServices;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarServices carServices;
	
	@PostMapping("/createCar")
	public String createCar(@RequestBody CarDTO dto) {
		try {
			String status = carServices.createCar(dto);
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@DeleteMapping("/deleteCar")
	public String deleteCar(@RequestBody CarDTO dto) {
		try {
			String status = carServices.deleteCar(dto);
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@GetMapping("/getCarInfo/{carId}")
	public CarDTO getCarInfo(@PathVariable Integer carId) {
		try {
			return carServices.getCarInfo(carId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	

	@PostMapping("/updateCarInfo")
	public String updateCarInfo(@RequestBody CarDTO dto) {
		try {
			String status = carServices.updateCarInfo(dto);
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
