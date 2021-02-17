package de.uniba.dsg.dsam.persistence;

import java.util.List;

import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.model.CustomerOrder;
import de.uniba.dsg.dsam.persistence.exception.DsamPersistenceException;

public interface SalesManagement {
	
	 public void create(CustomerOrder customerOrder) throws DsamPersistenceException;
	 public List<CustomerOrder> getAllOrders();
	void createOrder(CustomerOrder order);

}
