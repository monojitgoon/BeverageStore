package de.uniba.dsg.dsam.backend.beans;

import de.uniba.dsg.dsam.persistence.exception.*;
import de.uniba.dsg.dsam.backend.entities.BeverageEntity;
import de.uniba.dsg.dsam.backend.entities.IncentiveEntity;
import de.uniba.dsg.dsam.backend.entities.PromotionalGiftEntity;
import de.uniba.dsg.dsam.backend.entities.TrialPackageEntity;
import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.model.Incentive;
import de.uniba.dsg.dsam.model.PromotionalGift;
import de.uniba.dsg.dsam.model.TrialPackage;
import de.uniba.dsg.dsam.persistence.IncentiveManagement;

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
 * @author Monojit Goon
 */
@Stateless
@Remote(IncentiveManagement.class)
public class IncentiveManagementBean implements IncentiveManagement {

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
	public IncentiveManagementBean() {
		// this is just for demonstrating logging
		logger.info("Created IncentiveManagementBean");
	}

	@Override
	public void create(Incentive incentive) throws DsamPersistenceException {
		// COMMNET
		// server side validation is a MUST
		if (incentive.getType() == "Promotional") {
			IncentiveEntity et = new PromotionalGiftEntity(incentive.getName());
			em.persist(et);
		} else if (incentive.getType() == "Trial") {
			IncentiveEntity et = new TrialPackageEntity(incentive.getName());
			em.persist(et);
		}

	}

	
	@Override
	public List<Incentive> getAllIncentives() {	
		
		List<Incentive> divs = convert(em.createNamedQuery("IncentiveEntity.findAll").getResultList());

		if (divs == null) {
			return new ArrayList<Incentive>();
		} else {
			return divs;
		}
	}

	private List<Incentive> convert(List<IncentiveEntity> incentives) {
		List<Incentive> ret = new ArrayList<Incentive>();

		if (incentives != null) {
			for (IncentiveEntity r : incentives) {
				ret.add(ConvertIncentiveEntitytoModel(r));
			}
		}

		return ret;
	}

	private Incentive ConvertIncentiveEntitytoModel(IncentiveEntity i){
	  //  System.out.println(i.getName() + i.getType() + "inside convertion");

	    Incentive incentive;

		switch (i.getType()) {
		case "Promotional gift":
			incentive = new PromotionalGift(i.getId() , i.getName());
			break;
		case "Trial package":
			incentive = new TrialPackage(i.getId() , i.getName());
			break;
		default:
			throw new IllegalArgumentException("There is no incentive type to the argument: " + i.getType());
		}
		return incentive;
	}
	
	  public static IncentiveEntity convertIncentiveModelToEntity(Incentive incentive) {
			IncentiveEntity entity;
			switch (incentive.getType()) {
			    case "Promotional gift":
				entity = new PromotionalGiftEntity(incentive.getName());
				break;
			    case "Trial package":
				entity = new TrialPackageEntity(incentive.getName());
				break;
			    default:
			    	throw new IllegalArgumentException("There is no incentive type to the argument: " + incentive.getType());
			}
			return entity;
		    }
	@Override
	public Incentive getIncentive(int incentive_id) {
		IncentiveEntity d = em.find(IncentiveEntity.class, new Integer(incentive_id));
		
			return ConvertIncentiveEntitytoModel(d);
		
	}
	@Override
	public void updateIncentive(String incentive_name, int incentive_id) {
		IncentiveEntity div = select(incentive_id);
		div.setName(incentive_name);
		
		// this is just for demonstrating logging
		logger.info("Done Incentive Update");
	}
	
	private IncentiveEntity select(int incentive_id) {
		IncentiveEntity d = em.find(IncentiveEntity.class, new Integer(incentive_id));
		if(d == null)
			return null;
		else{
			return d;
		}
	}
	@Override
	public void deleteIncentive(int incentieve_id){

		IncentiveEntity div = select(incentieve_id);
		System.out.println(div.getName() + "before deletion");
		em.remove(div);	
	}
}
