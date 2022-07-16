package mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dto.AccessCardDTO;
import dto.EmployeeDTO;
import model.AccessCard;
import model.Car;
import model.Employee;
import model.Gate;
import model.GateAndAccessCard;
import repository.AccessCardRep;
import repository.CarRep;
import repository.EmployeeRep;
import repository.GateAndAccessCardRep;
import repository.GateRep;

@Component
public class AccessCardMapper {

	@Autowired
	private EmployeeRep employeeRep;

	@Autowired
	private GateRep gateRep;

	@Autowired
	private GateAndAccessCardRep gateAndAccessCardRep;

	
	@Autowired
	private CarRep carRep;

	@Autowired
	private AccessCardRep accessCardRep;

	public AccessCardDTO toDto(AccessCard accesscard) {
		AccessCardDTO dto = new AccessCardDTO();
		if (accesscard != null) {
			dto.setId(accesscard.getId());
			dto.setNumber(accesscard.getNumber());
			dto.setEmployeeId(accesscard.getEmployee().getId());
			dto.setCarId(accesscard.getCar().getId());

		}
		return dto;
	}

	public AccessCard toEntity(AccessCardDTO dto) {
		AccessCard accessCard = new AccessCard();
		Employee emp = null;

		Car car = null;
		if (dto.getEmployeeId() != null) {
			emp = employeeRep.getById(dto.getEmployeeId());
		}
		if (dto.getCarId() != null) {
			car = carRep.getById(dto.getCarId());
		}
		accessCard.setCar(car);
		accessCard.setEmployee(emp);
		accessCard.setNumber(dto.getNumber());
				
		return accessCard;
	}

}
