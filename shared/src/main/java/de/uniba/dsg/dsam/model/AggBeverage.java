package de.uniba.dsg.dsam.model;

import java.io.Serializable;

/**
 * Provides an AGGregated view on a division.
 * 
 * @author Lucky Sutradhar
 *
 */
public final class AggBeverage implements Serializable {
	public static final double INVALID_VALUE = -1;
	
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

    private String incentivename;
	
	public AggBeverage(){
		
	}

	/**
	 * @param id
	 * @param name
	 * @param manufacturer
	 * @param quantity
	 * @param price
	 * @param incentivename
	 */
	public AggBeverage(int id, String name, String manufacturer, int quantity, double price, String incentivename) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.price = price;
		this.incentivename = incentivename;
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

	    public String getIncentiveName() {
		return incentivename;
	    }

	    public void setIncentiveName(String incentivename) {
		this.incentivename = incentivename;
	    }

	    public int getId() {
		return id;
	    }

	    public void setId(int id) {
		this.id = id;
	    }
	
}
