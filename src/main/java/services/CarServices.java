package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.CarDTO;
import mapper.CarMapper;
import model.AccessCard;
import model.Car;
import model.Employee;
import repository.AccessCardRep;
import repository.CarRep;
import repository.EmployeeRep;

@Service
public class CarServices {

	@Autowired
	private CarRep carRep;

	@Autowired
	private CarMapper carMapper;

	@Autowired
	private EmployeeRep employeeRep;

	@Autowired
	private AccessCardRep accessCardRep;

	public String createCar(CarDTO dto) {
		try {
			Employee emp = null;
			Car car = carMapper.toEntity(dto);
			if (dto.getEmployeeId() != null) {
				emp = employeeRep.getById(dto.getEmployeeId());
				emp.setCar(car);
			}
			carRep.save(car);
			return "sucess";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}

	public String updateCarInfo(CarDTO dto) {
		try {
			Employee employee = null;
			AccessCard accessCard = null;
			Car car = carRep.getById(dto.getId());
			if (dto.getEmployeeId() != null)
				employee = employeeRep.getById(dto.getEmployeeId());
			if (dto.getAccessCardId() != null)
				accessCard = accessCardRep.getById(dto.getAccessCardId());
			if (accessCard != null)
				accessCard.setCar(car);
			// car.setEmployee(employee);
			if (employee != null) {
				employee.setCar(car);
				employeeRep.save(employee);
			}
			if (dto.getBrand() != null)
				car.setBrand(dto.getBrand());
			if (dto.getModel() != null)
				car.setModel(dto.getModel());
			if (dto.getPlateNumber() != null)
				car.setPlateNumber(dto.getPlateNumber());
			carRep.save(car);
			return "sucess";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}

	public String deleteCar(CarDTO dto) {
		try {
			Car car = carRep.getById(dto.getId());
			if (car.getEmployee() != null) {
				Employee emp = employeeRep.getById(car.getEmployee().getId());
				emp.setCar(null);
			}
			if (car.getAccessCard() != null) {
				AccessCard accessCard = accessCardRep.getById(car.getAccessCard().getId());
				accessCard.setCar(null);
			}
			carRep.delete(car);
			return "sucess";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}

	}

	public CarDTO getCarInfo(Integer carId) {
		try {
			CarDTO carDTO = null;
			Car car = carRep.getById(carId);
			carDTO = carMapper.toDto(car);
			return carDTO;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

}
