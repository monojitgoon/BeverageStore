package de.uniba.dsg.dsam.backend.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.uniba.dsg.dsam.model.Beverage;


/**
 * The persistent class for the customerorder database table.
 * 
 */
@Entity
@Table(name="customerorder")
@NamedQuery(name="CustomerOrderEntity.findAll", query="SELECT c FROM CustomerOrderEntity c")
public class CustomerOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CUSTOMERORDER_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUSTOMERORDER_ID_GENERATOR")
	private Integer id;

	@Column(name="beverage_id")
	private Integer beverageId;

	@Temporal(TemporalType.DATE)
	private Date issuedate;

	private Integer version;
    private List<Beverage> orderItems = new ArrayList<Beverage>();

	public CustomerOrderEntity() {
	}
	 public CustomerOrderEntity(Date issueDate, List<Beverage> orderItems) {
 		this.issuedate = issueDate;
 		this.orderItems = orderItems;
 }
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBeverageId() {
		return this.beverageId;
	}

	public void setBeverageId(Integer beverageId) {
		this.beverageId = beverageId;
	}

	public Date getIssuedate() {
		return this.issuedate;
	}

	public void setIssuedate(Date issuedate) {
		this.issuedate = issuedate;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	public List<Beverage> getOrderItems() {
        return orderItems;
    }
}