package de.uniba.dsg.dsam.persistence;

import java.util.List;

import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.persistence.exception.DsamPersistenceException;

/**
*
* @author Lucky Sutradhar
*/

public interface BeverageManagement {

    public void create(Beverage beverage) throws DsamPersistenceException;
	 public List<Beverage> getAllBeverages();
	 public void addIncentive(int bev_id, int inc_id) ;

}
