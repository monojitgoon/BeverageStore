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
import de.uniba.dsg.dsam.model.TrialPackage;
import de.uniba.dsg.dsam.model.Incentive;
import de.uniba.dsg.dsam.model.PromotionalGift;
import de.uniba.dsg.dsam.persistence.IncentiveManagement;

/**
*
* @author Monojit Goon
*/
/**
 * Servlet implementation class IncentiveServlet
 */
public class IncentiveServlet extends HttpServlet {
	private static final Logger logger = Logger.getLogger(IncentiveServlet.class.getName());

	@EJB
	private IncentiveManagement incentiveManagementBean;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("incentive_id") != null) {
			try {
				int id = Integer.valueOf(request.getParameter("incentive_id"));
				// get division DTO
				Incentive incentive = incentiveManagementBean.getIncentive(id);

				// add data for JSP
				request.setAttribute("incentive", incentive);

				request.getRequestDispatcher("/editIncentive.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				logger.severe("Invalid data for division id: Must be int" + e);
			}
		} else

		{
			// List<Incentive> beverages = incentiveManagementBean.getAllIncentives();
			request.setAttribute("incentivesList", incentiveManagementBean.getAllIncentives());
			// redirect to JSP presentation
			request.getRequestDispatcher("/Incentive.jsp").forward(request, response);
			/*
			 * for (Incentive bv : beverages) { System.out.println(bv.getName()
			 * +"kuttar baccha"); }
			 * logger.severe(incentiveManagementBean.getAllIncentives().toString());
			 */
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (request.getParameter("incentive_id") != null) {
			try {
				int id = Integer.valueOf(request.getParameter("incentive_id"));
				String name = request.getParameter("incentive_name").trim();

				incentiveManagementBean.updateIncentive(name, id);
			} catch (NumberFormatException e) {
				logger.severe("Invalid data for id or number of employees: Must be int" + e);
			}
		} else {
			try {
				String name = request.getParameter("incentive_name").trim();
				String type = request.getParameter("incentive_type").trim();

				Incentive incentive;
				switch (type) {
				case "Promotional gift":
					incentive = new PromotionalGift(name, type);
					break;
				case "Trial package":
					incentive = new TrialPackage(name, type);
					break;
				default:
					throw new IllegalArgumentException("There is no incentive type to the argument: " + type);
				}
				incentiveManagementBean.create(incentive);
			} catch (NumberFormatException e) {
				logger.severe("Invalid data for number of employees: Must be int " + e);
			} catch (DsamPersistenceException e) {
				logger.severe("Error creating division" + e);
			}
		}
		// redirect
		response.sendRedirect("/frontend/incentives");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int incentive_id = Integer.valueOf(request.getParameter("incentive_id"));
		
			incentiveManagementBean.deleteIncentive(incentive_id);
		} catch(NumberFormatException e) {
			logger.severe("Invalid data for division id: Must be int" + e);
		}
	}

}
