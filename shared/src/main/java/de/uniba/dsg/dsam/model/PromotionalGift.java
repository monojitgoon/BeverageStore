package de.uniba.dsg.dsam.model;

/**
*
* @author Monojit Goon
*/
public class PromotionalGift extends Incentive {

	
	
	public PromotionalGift(int id, String name) {
		super( id , name ,"Promotional");
	 }
	
	public PromotionalGift(String name, String type) {
		super( name,"Promotional");
	 }
	
    @Override
    public String getType() {
	return "Promotional";
    }
}
