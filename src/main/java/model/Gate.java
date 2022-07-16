package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gate")
public class Gate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "gate")
	List<GateAndAccessCard> gateAndAccessCard;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<GateAndAccessCard> getGateAndAccessCard() {
		return gateAndAccessCard;
	}

	public void setGateAndAccessCard(List<GateAndAccessCard> gateAndAccessCard) {
		this.gateAndAccessCard = gateAndAccessCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
