package de.uniba.dsg.dsam.backend.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import de.uniba.dsg.dsam.backend.entities.BeverageEntity;
import de.uniba.dsg.dsam.backend.entities.CustomerOrderEntity;
import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.model.CustomerOrder;
import de.uniba.dsg.dsam.persistence.SalesManagement;
import de.uniba.dsg.dsam.persistence.exception.DsamPersistenceException;

@Stateless
public class SalesManagementBean implements SalesManagement {
	

	private static final Logger logger = Logger.getLogger(IncentiveManagementBean.class.getName());

	// COMMENT
	// Any time a transaction ends (typically after each client method call) all
	// managed entities
	// become detached!
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	@Override
    public void createOrder(CustomerOrder order) {
		CustomerOrderEntity entity = convertOrderModelToEntity(order);
        em.persist(entity);
    }
    
    @Override
    public List<CustomerOrder> getAllOrders() {
		List<CustomerOrder> divs = convert(em.createNamedQuery("CustomerOrderEntity.findAll").getResultList());

		if (divs == null) {
			return new ArrayList<CustomerOrder>();
		} else {
			return divs;
		}
	}
    
    private List<CustomerOrder> convert(List<CustomerOrderEntity> bvs) {
		List<CustomerOrder> ret = new ArrayList<CustomerOrder>();

		if (bvs != null) {
			for (CustomerOrderEntity r : bvs) {
				ret.add(convertOrderEntityToModel(r));
			}
		}

		return ret;
	}
    public static CustomerOrderEntity convertOrderModelToEntity(CustomerOrder order) {
    	CustomerOrderEntity entity = new CustomerOrderEntity(order.getIssueDate(), order.getOrderItems());
    	return entity;
        }

        public static CustomerOrder convertOrderEntityToModel(CustomerOrderEntity entity)  {
        	CustomerOrder order = new CustomerOrder(entity.getId(), entity.getIssuedate(), entity.getOrderItems());
        	return order;
        }

		@Override
		public void create(CustomerOrder customerOrder) throws DsamPersistenceException {
			// TODO Auto-generated method stub
			
		}
}
