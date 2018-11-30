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

@WebServlet(name = "CulturalBuildingEditServlet", urlPatterns = { "/buildings/cultural/edit" })
public class CulturalBuildingEditServlet extends HttpServlet {

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
        String origName = request.getParameter("originalName");
        CulturalBuildingService culturalBuildingService = new CulturalBuildingService();
        CulturalBuilding culturalBuilding = culturalBuildingService.getById(cbuildingId);
        
        culturalBuilding.setName(request.getParameter("pname"));
        culturalBuilding.setDescription(request.getParameter("pdesc"));
        
        culturalBuildingService.modify(origName, culturalBuilding);

        response.sendRedirect("/buildings/cultural");

		culturalBuilding.setName(request.getParameter("pname"));
		culturalBuilding.setDescription(request.getParameter("pdesc"));
		culturalBuildingService.create(culturalBuilding);
        doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        CulturalBuildingService culturalBuildingService = new CulturalBuildingService();
        CulturalBuilding cbuilding = culturalBuildingService.getById(Long.parseLong(request.getParameter("cbuildingId")));
        request.setAttribute("cbuilding", cbuilding);
        getServletContext().getRequestDispatcher("/culturalbuilding/edit.jsp").include(request, response);
	}
	
}
