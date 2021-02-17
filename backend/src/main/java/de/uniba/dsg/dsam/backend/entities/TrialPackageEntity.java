
package de.uniba.dsg.dsam.backend.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Trial package")
public class TrialPackageEntity extends IncentiveEntity {

	private String incentivetype = "Trial";
	
	public TrialPackageEntity() {
		super();
	}

    public TrialPackageEntity(String name) {
	super(name);
    }
    @Override
    public String getType() {
	return this.incentivetype;
    }

}
