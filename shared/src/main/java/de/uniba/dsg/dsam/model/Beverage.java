package de.uniba.dsg.dsam.model;

import java.io.Serializable;
/**
*
* @author Lucky Sutradhar
*/


/**
 * A beverage can only have a maximum of one assigned incentive, while an incentive can be used on multiple beverages.
 */
public final class Beverage implements Serializable{

    private int id;

    private String manufacturer;
    private String name;

    /**
     * the amount of bottles in a unit.
     */
    private int quantity;

    /**
     * the whole unit price.
     */
    private double price;

    private Incentive incentive;
    
    public Beverage() {
		super();
	}

    public Beverage(int id, String manufacturer, String name, int quantity, double price, Incentive incentive) {
    	super();
    	this.id=id;
	    this.manufacturer = manufacturer;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.incentive = incentive;

    }

    public String getManufacturer() {
	return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getQuantity() {
	return quantity;
    }

    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    public Incentive getIncentive() {
	return incentive;
    }

    public void setIncentive(Incentive incentive) {
	this.incentive = incentive;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }
   
}
