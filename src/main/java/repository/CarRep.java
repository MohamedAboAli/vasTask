package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Car;

@Repository
public interface CarRep extends JpaRepository<Car, Integer>{

}

