package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Car;
import model.Employee;

@Repository
public interface EmployeeRep  extends JpaRepository<Employee, Integer>{
	
	public Employee findByCar(Car car);
	}
