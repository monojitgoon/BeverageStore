package de.uniba.dsg.dsam.client;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.uniba.dsg.dsam.persistence.exception.*;
import de.uniba.dsg.dsam.persistence.SalesManagement;
import de.uniba.dsg.dsam.model.Beverage;
/**
*
* @author Monojit Goon
*/
public class CustomerOrderServlet extends HttpServlet {
	private static final Logger logger = Logger.getLogger(CustomerOrderServlet.class.getName());

	@EJB
	private SalesManagement salesManagementBean;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//List<Beverage> beverages = beverageManagementBean.getAllBeverages();
		// TODO Auto-generated method stub
		request.setAttribute("orderList", salesManagementBean.getAllOrders());
		// redirect to JSP presentation
		request.getRequestDispatcher("/CustomerOrder.jsp").forward(request, response);
		/*for (Beverage bv : beverages)
		{
			System.out.println(bv.getManufacturer() ");
		}
		logger.severe(beverageManagementBean.getAllBeverages().toString());
*/	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {

	}
}
