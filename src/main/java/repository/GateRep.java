package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Gate;

@Repository
public interface GateRep extends JpaRepository<Gate, Integer>{

}
