package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.GateAndAccessCard;

@Repository
public interface GateAndAccessCardRep extends JpaRepository<GateAndAccessCard, Integer>{
	
	}