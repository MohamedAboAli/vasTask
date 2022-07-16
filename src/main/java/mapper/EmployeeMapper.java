package mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dto.EmployeeDTO;
import model.AccessCard;
import model.Car;
import model.Employee;
import repository.AccessCardRep;
import repository.CarRep;
import repository.EmployeeRep;

@Component
public class EmployeeMapper {

	@Autowired
	private EmployeeRep employeeRep;

	@Autowired
	private CarRep carRep;

	@Autowired
	private AccessCardRep accessCardRep;

	public EmployeeDTO toDto(Employee emp) {
		EmployeeDTO dto = new EmployeeDTO();
		if (emp != null) {
			dto.setId(emp.getId());
			dto.setName(emp.getName());
			dto.setAge(emp.getAge());
			dto.setPosition(emp.getPosition());
			dto.setCarId(emp.getCar().getId());
			dto.setAccessCardId(emp.getAccessCard().getId());
		}
		return dto;
	}

	public Employee toEntity(EmployeeDTO dto) {
		Employee emp = new Employee();
		AccessCard accessCard = null;
		Car car = null;
		if (dto.getCarId() != null) {
			car = carRep.getById(dto.getCarId());
		}
		if (dto.getAccessCardId() != null) {
			accessCard = accessCardRep.getById(dto.getAccessCardId());
		}

		if (dto.getId() != null) {
			emp.setId(dto.getId());
		}
		emp.setAge(dto.getAge());
		emp.setName(dto.getName());
		emp.setPosition(dto.getPosition());
		emp.setAccessCard(accessCard);
		emp.setCar(car);

		return emp;
	}
}
