package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.AccessCard;
import model.Car;
import model.Employee;

@Repository
public interface AccessCardRep extends JpaRepository<AccessCard, Integer> {

	public AccessCard findByCar(Car car);
	public AccessCard findByCarAndEmployee(Car car,Employee emp);
}
