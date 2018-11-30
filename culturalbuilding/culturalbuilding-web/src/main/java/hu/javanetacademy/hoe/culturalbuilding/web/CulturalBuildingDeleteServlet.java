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

@WebServlet(name = "CulturalBuildingDeleteServlet", urlPatterns = { "/buildings/cultural/delete" })
public class CulturalBuildingDeleteServlet extends HttpServlet {
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
		long cbuildingId = Long.parseLong(request.getParameter("cbuildingId"));
        CulturalBuildingService culturalBuildingService = new CulturalBuildingService();
        culturalBuildingService.delete(cbuildingId);
        response.sendRedirect("/buildings/cultural");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CulturalBuildingService culturalBuildingService = new CulturalBuildingService();
	    CulturalBuilding culturalBuilding = culturalBuildingService.getById(Long.parseLong(request.getParameter("cbuildingId")));
       request.setAttribute("cbuilding", culturalBuilding);
       getServletContext().getRequestDispatcher("/culturalbuilding/delete.jsp").include(request, response);
	}
	
}
