package de.uniba.dsg.dsam.backend.beans;

import de.uniba.dsg.dsam.persistence.exception.*;
import de.uniba.dsg.dsam.backend.entities.BeverageEntity;
import de.uniba.dsg.dsam.backend.entities.IncentiveEntity;
import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.model.Incentive;
import de.uniba.dsg.dsam.model.PromotionalGift;
import de.uniba.dsg.dsam.model.TrialPackage;
import de.uniba.dsg.dsam.persistence.BeverageManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.activation.UnsupportedDataTypeException;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceException;
/**
*
* @author Lucky Sutradhar
*/
@Stateless
public class BeverageManagementBean implements BeverageManagement {
	private static final Logger logger = Logger.getLogger(IncentiveManagementBean.class.getName());

	// COMMENT
	// Any time a transaction ends (typically after each client method call) all
	// managed entities
	// become detached!
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public BeverageManagementBean() {
		// this is just for demonstrating logging
		logger.info("Created BeverageManagementBean");
	}

	@Override
	public List<Beverage> getAllBeverages() {
		List<Beverage> divs = convert(em.createNamedQuery("BeverageEntity.findAll").getResultList());

		if (divs == null) {
			return new ArrayList<Beverage>();
		} else {
			return divs;
		}
	}
	

	
	private List<Beverage> convert(List<BeverageEntity> bvs) {
		List<Beverage> ret = new ArrayList<Beverage>();

		if (bvs != null) {
			for (BeverageEntity r : bvs) {
				ret.add(ConvertBeverageEntitytoModel(r));
			}
		}

		return ret;
	}

	 public Beverage ConvertBeverageEntitytoModel(BeverageEntity entity) {
		    //System.out.println(entity.getName() + "inside convertion");

		 Beverage beverage = new Beverage(entity.getId(), entity.getManufacturer(), entity.getName(), entity.getQuantity(),
					entity.getPrice(), null);
			    	return beverage;

		}
	
	@Override
	public void create(Beverage beverage) throws DsamPersistenceException {
		// COMMNET
		// server side validation is a MUST
		BeverageEntity entity = new BeverageEntity(beverage.getManufacturer(), beverage.getName(),
				beverage.getQuantity(), beverage.getPrice(), null);
		em.persist(entity);

	}
	
	@Override
	public void addIncentive(int bev_id, int inc_id){
		System.out.println("testing add");
		BeverageEntity bev = select(bev_id);
		System.out.println(bev.getManufacturer() + "testing");
		IncentiveEntity entity = selectIncentive(inc_id);
		System.out.println(entity.getId() + "testing");
		bev.setIncentive(entity);

	}
	
	private IncentiveEntity selectIncentive(int incentive_id) {
		IncentiveEntity d = em.find(IncentiveEntity.class, new Integer(incentive_id));
		if(d == null)
			return null;
		else{
			return d;
		}
	}
	private BeverageEntity select(int bev_id) {
		BeverageEntity d = em.find(BeverageEntity.class, new Integer(bev_id));
		if(d == null)
			return null;
		else{
			return d;
		}
	}
	
}
