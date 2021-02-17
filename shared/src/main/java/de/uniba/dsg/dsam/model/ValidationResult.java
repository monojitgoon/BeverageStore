package de.uniba.dsg.dsam.model;

import java.io.Serializable;

/**
 * Simple class for capturing the result of validating user input. 
 * Note: Client-side data validation is a matter of user experience,
 * 		 Server-side data validation is a matter of consistency!
 * ==> Client-side validation is a CAN, server-side is a MUST!
 * 
 * @author Monojit
 */
public final class ValidationResult implements Serializable{
	public enum ResultType{
		OK, NOTOK	
	}
	
	private ResultType type = null;
	private String errMsg = null;
	
	/**
	 * @return the type
	 */
	public ResultType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(ResultType type) {
		this.type = type;
	}
	/**
	 * @return the errMsg
	 */
	public String getErrMsg() {
		return errMsg;
	}
	/**
	 * @param errMsg the errMsg to set
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	
}
