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
import de.uniba.dsg.dsam.persistence.*;
import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.model.Incentive;

/**
*
* @author Lucky Sutradhar
*/

public class AssignIncentiveServlet extends HttpServlet {
	private static final Logger logger = Logger.getLogger(AssignIncentiveServlet.class.getName());

	@EJB
	private IncentiveManagement incentiveManagementBean;
	@EJB
	private BeverageManagement beverageManagementBean;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//List<Beverage> beverages = beverageManagementBean.getAllBeverages();
		// TODO Auto-generated method stub
		if(request.getParameter("beverage_id") != null) {
			try {
				int id = Integer.valueOf(request.getParameter("beverage_id"));

				// add data for JSP
				request.setAttribute("bev_id", id);
				request.setAttribute("IncentiveList", incentiveManagementBean.getAllIncentives());
				// redirect to JSP presentation
				request.getRequestDispatcher("/addIncentivetoBeverage.jsp").forward(request, response);
			} catch(NumberFormatException e) {
				logger.severe("Invalid data for division id: Must be int" + e);
			} 			
		}
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
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			int bev_id = Integer.valueOf(req.getParameter("bev_id"));
			int inc_id = Integer.valueOf(req.getParameter("inc_id"));
			
			beverageManagementBean.addIncentive(bev_id, inc_id);
		} catch(NumberFormatException e) {
			logger.severe("Invalid data for beverage id or incentive id: Must be int" + e);
		} 
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {

	}
}
