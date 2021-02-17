package de.uniba.dsg.dsam.backend.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the incentive database table.
 * 
 */
@Entity
@DiscriminatorColumn(name = "incentivetype", discriminatorType = DiscriminatorType.STRING)
@Table(name="incentive")
@NamedQuery(name="IncentiveEntity.findAll", query="SELECT i FROM IncentiveEntity i")
public abstract class IncentiveEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;

	private String incentivetype;

	private String name;
	private Integer version;
	
	public IncentiveEntity() {
	}
	public IncentiveEntity(int id, String name, String incentivetype) {
		this.id = id;
		this.name = name;
		this.incentivetype = incentivetype;
	}
	public IncentiveEntity(String name, String incentivetype) {
		this.name = name;
		this.incentivetype = incentivetype;
	}	
	public IncentiveEntity(String name) {
		this.name = name;
	}	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIncentivetype() {
		return this.incentivetype;
	}

    public abstract String getType();

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}


}