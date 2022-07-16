package mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dto.CarDTO;
import dto.EmployeeDTO;
import model.AccessCard;
import model.Car;
import model.Employee;
import repository.AccessCardRep;
import repository.CarRep;
import repository.EmployeeRep;

@Component
public class CarMapper {

	@Autowired
	private EmployeeRep employeeRep;

	@Autowired
	private CarRep carRep;

	@Autowired
	private AccessCardRep accessCardRep;

	public CarDTO toDto(Car car) {
		CarDTO dto = new CarDTO();
		if (car != null) {
			dto.setId(car.getId());
			dto.setBrand(car.getBrand());
			dto.setModel(car.getModel());
			dto.setPlateNumber(car.getPlateNumber());
			if(car.getEmployee() != null){
			dto.setEmployeeId(car.getEmployee().getId());
			}
			if(car.getAccessCard() != null){
			dto.setAccessCardId(car.getAccessCard().getId());
		}}
		return dto;
	}

	public Car toEntity(CarDTO dto) {
		Car car = new Car();
		AccessCard accessCard = null;
		Employee emp = null;
		if (dto.getEmployeeId() != null) {
			emp = employeeRep.getById(dto.getEmployeeId());
		}
		if (dto.getAccessCardId() != null) {
			accessCard = accessCardRep.getById(dto.getAccessCardId());
		}
		if(dto.getId() != null) {
		car.setId(dto.getId());
		}
		car.setAccessCard(accessCard);
		car.setEmployee(emp);
		car.setBrand(dto.getBrand());
		car.setModel(dto.getModel());
		car.setPlateNumber(dto.getPlateNumber());

		return car;
	}

}
