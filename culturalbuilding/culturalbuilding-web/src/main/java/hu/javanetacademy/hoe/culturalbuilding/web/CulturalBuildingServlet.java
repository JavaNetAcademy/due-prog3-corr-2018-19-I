package hu.javanetacademy.hoe.culturalbuilding.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.javanetacademy.hoe.culturalbuilding.dao.model.CulturalBuilding;
import hu.javanetacademy.hoe.culturalbuilding.service.CulturalBuildingService;

/**
*
* @author Soos Gabor
*
*/

@WebServlet(name = "CulturalBuildingServlet", urlPatterns = { "/buildings/cultural" })
public class CulturalBuildingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final CulturalBuildingService culturalBuildingService;

	public CulturalBuildingServlet() {
		culturalBuildingService = new CulturalBuildingService();
	}

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CulturalBuilding culturalBuilding = new CulturalBuilding();
		culturalBuilding.setName(request.getParameter("pname"));
		culturalBuilding.setDescription(request.getParameter("pdesc"));
		culturalBuildingService.create(culturalBuilding);
        doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cbuildingList", culturalBuildingService.getAll());
        getServletContext().getRequestDispatcher("/culturalbuilding/index.jsp").include(request, response);
	}
	
}
