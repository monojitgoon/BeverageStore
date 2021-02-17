package de.uniba.dsg.dsam.model;

import java.util.Date;
import java.util.List;
/**
*
* @author Lucky Sutradhar
*/
public class CustomerOrder {

    private int id;
	private Date issueDate;
    private List<Beverage> orderItems;
    
    public CustomerOrder() {
		super();
	}

    public CustomerOrder(int id, Date issueDate, List<Beverage> orderItems) {
    	super();
	    this.id = id;
		this.issueDate = issueDate;
		this.orderItems = orderItems;
    }
    
    public int getId() {
    	return id;
        }

    public void setId(int id) {
    	this.id = id;
        }
    public Date getIssueDate() {
    	return issueDate;
        }

    public void setIssueDate(Date IssueDate) {
    	this.issueDate = IssueDate;
        }
    public List<Beverage> getOrderItems() {
    	return orderItems;
        }

    public void setOrderItems(List<Beverage> orderItems) {
    	this.orderItems = orderItems;
        }
}
