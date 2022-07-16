package services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.AccessCardDTO;
import mapper.AccessCardMapper;
import mapper.CarMapper;
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

@Service
public class AccessCardServices {

	@Autowired
	AccessCardRep accessCardRep;

	@Autowired
	private AccessCardMapper accessCardMapper;

	@Autowired
	private GateRep gateRep;

	@Autowired
	private CarRep carRep;

	@Autowired
	private EmployeeRep employeeRep;

	@Autowired
	private GateAndAccessCardRep gateAndAccessCardRep;

	public String createAccessCard(AccessCardDTO dto) {
		try {
			Car car = carRep.getById(dto.getCarId());
			Employee emp = employeeRep.getById(dto.getEmployeeId());
			AccessCard accessCard = accessCardRep.findByCarAndEmployee(car, emp);
			if (accessCard == null) {
				accessCard = accessCardMapper.toEntity(dto);
				accessCardRep.save(accessCard);
				return "sucess";
			} else {
				return "only one access card for each employee and car";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}

	public String passingThrougGate(AccessCardDTO dto) {
		try {
			Gate gate = gateRep.getById(dto.getGateId());

			Car car = carRep.getById(dto.getCarId());

			AccessCard accessCard = accessCardRep.findByCar(car);
			GateAndAccessCard lastTimegateAndAccessCard = null;
			GateAndAccessCard gateAndAccessCard = new GateAndAccessCard();
			gateAndAccessCard.setCreateDate(LocalDateTime.now());
			gateAndAccessCard.setGate(gate);
			gateAndAccessCard.setAccessCard(accessCard);
			if (accessCard.getGateAndAccessCard().size() > 0) {
				lastTimegateAndAccessCard = accessCard.getGateAndAccessCard()
						.get(accessCard.getGateAndAccessCard().size() - 1);

				if (gateAndAccessCard.getCreateDate()
						.isAfter(lastTimegateAndAccessCard.getCreateDate().plusMinutes(1))) {
					accessCard.setCredit(accessCard.getCredit() - 4);
				}
			} else {
				accessCard.setCredit(accessCard.getCredit() - 4);
			}
			gateAndAccessCardRep.save(gateAndAccessCard);
			accessCard.getGateAndAccessCard().add(gateAndAccessCard);

			accessCardRep.save(accessCard);
			return "remaining Balance ="+accessCard.getCredit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}

	public AccessCardRep getAccessCardRep() {
		return accessCardRep;
	}

	public void setAccessCardRep(AccessCardRep accessCardRep) {
		this.accessCardRep = accessCardRep;
	}

	public AccessCardMapper getAccessCardMapper() {
		return accessCardMapper;
	}

	public void setAccessCardMapper(AccessCardMapper accessCardMapper) {
		this.accessCardMapper = accessCardMapper;
	}

	public GateRep getGateRep() {
		return gateRep;
	}

	public void setGateRep(GateRep gateRep) {
		this.gateRep = gateRep;
	}

	public GateAndAccessCardRep getGateAndAccessCardRep() {
		return gateAndAccessCardRep;
	}

	public void setGateAndAccessCardRep(GateAndAccessCardRep gateAndAccessCardRep) {
		this.gateAndAccessCardRep = gateAndAccessCardRep;
	}

}
