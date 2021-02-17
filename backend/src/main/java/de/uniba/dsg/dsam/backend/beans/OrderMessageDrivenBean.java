package de.uniba.dsg.dsam.backend.beans;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import de.uniba.dsg.dsam.model.CustomerOrder;
/**
*
* @author Monojit Goon
*/
@MessageDriven(
		mappedName = "BeverageStoreQueue",
		activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class OrderMessageDrivenBean implements MessageListener {
	private static final Logger logger = Logger.getLogger(OrderMessageDrivenBean.class.getName());
	// COMMENT
	// Use container's dependency injection for the functionality you need.

	/**
	 * Default constructor.
	 */
	public OrderMessageDrivenBean() {

	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {

		if (message != null && message instanceof ObjectMessage) {
			ObjectMessage objectMessage = (ObjectMessage) message;
			if (objectMessage instanceof CustomerOrder) {
				// TODO implement
				logger.info("customerorder in mdb.");
			}
		}
	}

}
