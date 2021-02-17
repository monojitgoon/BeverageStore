package de.uniba.dsg.dsam.model;

import java.io.Serializable;
/**
*
* @author Monojit Goon
*/
public abstract class Incentive  implements Serializable {
	private Integer id;

	private String incentivetype;

	private String name;

	public Incentive() {
		super();
	}
	public Incentive(int id, String name, String incentivetype) {
		super();
		this.id = id;
		this.name = name;
		this.incentivetype = incentivetype;
	}	
	public Incentive(String name, String incentivetype) {
		super();
		this.name = name;
		this.incentivetype = incentivetype;
	}	
	public Incentive(String name) {
		super();
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
}
