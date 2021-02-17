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
import de.uniba.dsg.dsam.persistence.BeverageManagement;
import de.uniba.dsg.dsam.model.Beverage;
/**
*
* @author Monojit Goon, Lucky Sutradhar
*/
public class BeveragesServlet extends HttpServlet {
	private static final Logger logger = Logger.getLogger(BeveragesServlet.class.getName());

	@EJB
	private BeverageManagement beverageManagementBean;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//List<Beverage> beverages = beverageManagementBean.getAllBeverages();
		// TODO Auto-generated method stub
		request.setAttribute("BeverageList", beverageManagementBean.getAllBeverages());
		// redirect to JSP presentation
		request.getRequestDispatcher("/Beverage.jsp").forward(request, response);
		/*for (Beverage bv : beverages)
		{
			System.out.println(bv.getManufacturer() ");
		}
		logger.severe(beverageManagementBean.getAllBeverages().toString());
*/	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			Beverage beverage=new Beverage();
			String name= req.getParameter("beverage_name").trim();
			String manufacturer= req.getParameter("manufacturer").trim();
			int quantity=Integer.valueOf(req.getParameter("quantity"));
			double price=Double.valueOf(req.getParameter("price"));
			beverage= new Beverage(0, manufacturer, name, quantity, price, null);
		
			beverageManagementBean.create(beverage);
		} catch(NumberFormatException e) {
			logger.severe("Quantity and Price: Must be number " + e);
		} catch (DsamPersistenceException e) {
			logger.severe("Error creating Beverage" + e);
		}
		
		// redirect
		res.sendRedirect("/frontend");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {

	}
}
