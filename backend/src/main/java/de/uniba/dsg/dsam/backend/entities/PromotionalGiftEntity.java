package de.uniba.dsg.dsam.backend.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Promotional gift")
public class PromotionalGiftEntity extends IncentiveEntity {

	private String incentivetype = "Promotional";

	public PromotionalGiftEntity() {
		super();
	    }

    public PromotionalGiftEntity(String name) {
	super(name);
    }
    @Override
    public String getType() {
	return this.incentivetype;
    }

}
