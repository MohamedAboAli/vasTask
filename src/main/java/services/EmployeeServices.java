package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.EmployeeDTO;
import mapper.EmployeeMapper;
import model.Car;
import model.Employee;
import repository.CarRep;
import repository.EmployeeRep;

@Service
public class EmployeeServices {

	@Autowired
	private EmployeeRep employeeRep;

	@Autowired
	private CarRep carRep;

	@Autowired
	private EmployeeMapper employeeMapper;

	public String createEmployee(EmployeeDTO dto) {
		try {
			Employee employee = null;
			if (dto.getCarId() != null) {
				Car car = carRep.getById(dto.getCarId());
				employee = employeeRep.findByCar(car);
			}
			if (employee == null) {
				employee = employeeMapper.toEntity(dto);
				employeeRep.save(employee);
				return "sucess";
			} else {
				return "this car already registerd for other employee";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
}
