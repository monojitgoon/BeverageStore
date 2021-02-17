package de.uniba.dsg.dsam.model;

/**
*
* @author Monojit Goon
*/
public class TrialPackage extends Incentive  {
	public TrialPackage(int id, String name) {
		super( id , name ,"Trial");
	 }
	
    public TrialPackage (String name,String type ) {
	super(name,"Trial");
    }
    @Override
    public String getType() {
	return "Trial";
    }

}
