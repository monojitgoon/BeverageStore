package de.uniba.dsg.dsam.backend.entities;

import java.io.Serializable;
import javax.persistence.*;
import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.model.AggBeverage;


/**
 * The persistent class for the beverage database table.
 * 
 */
@Entity
@Table(name="beverage")
@NamedQuery(name="BeverageEntity.findAll", query="Select b From BeverageEntity b")
//@NamedQuery(name="BeverageEntity.find", query="Select d From Division d where d.id = :theid")

public class BeverageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;

	private String manufacturer;

	private String name;

	private double price;

	private Integer quantity;

	private Integer version;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private IncentiveEntity incentive;

	public BeverageEntity() {
	}
	
	public BeverageEntity(String manufacturer, String name, int quantity, double price, IncentiveEntity incentive) {
		this.manufacturer = manufacturer;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.incentive = incentive;
	    }
	
	public BeverageEntity ConvertBeverageModeltoEntity(Beverage beverage) {
		BeverageEntity entity = new BeverageEntity(beverage.getManufacturer(), beverage.getName(),
				beverage.getQuantity(), beverage.getPrice(), null);
		    	return entity;
		
	}	

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public IncentiveEntity getIncentive() {
		return this.incentive;
	}

	public void setIncentive(IncentiveEntity incentive) {
		this.incentive = incentive;
	}

}