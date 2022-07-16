package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GateAndAccessCardKey implements Serializable {

    @Column(name = "accesscard_id")
    private Integer accesscardid;

    @Column(name = "gate_id")
    private Integer gateid;

	public Integer getAccesscardid() {
		return accesscardid;
	}

	public void setAccesscardid(Integer accesscardid) {
		this.accesscardid = accesscardid;
	}

	public Integer getGateid() {
		return gateid;
	}

	public void setGateid(Integer gateid) {
		this.gateid = gateid;
	}

	

    
	
    

}