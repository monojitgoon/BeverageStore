package de.uniba.dsg.dsam.persistence;

import java.util.List;

import de.uniba.dsg.dsam.model.Incentive;
import de.uniba.dsg.dsam.persistence.exception.DsamPersistenceException;

/**
*
* @author Monojit Goon
*/

public interface IncentiveManagement {
	
	public void create(Incentive incentive) throws DsamPersistenceException;
	
	 public List<Incentive> getAllIncentives();
	
	 public Incentive getIncentive(int incentive_id);
	 
	 public void updateIncentive(String incentive_name, int incentive_id);
	 
	 public void deleteIncentive(int incentive_id);

}
