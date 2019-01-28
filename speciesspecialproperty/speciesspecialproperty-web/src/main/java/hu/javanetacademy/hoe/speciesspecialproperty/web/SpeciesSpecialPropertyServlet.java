package hu.javanetacademy.hoe.speciesspecialproperty.web;

import hu.javanetacademy.hoe.species.model.Species;
import hu.javanetacademy.hoe.speciesspecialproperty.dao.model.SpeciesSpecialProperty;
import hu.javanetacademy.hoe.species.service.SpeciesService;
import hu.javanetacademy.hoe.speciesspecialproperty.service.object.speciesspecialpropertyService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
  * @author sviktor75 / Szabó Viktor / vts4gv
 */
@WebServlet(name = "SpeciesSpecialPropertyServlet", urlPatterns = { "/speciesspecialproperty" })
public class SpeciesSpecialPropertyServlet extends HttpServlet {

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //response.getWriter().print("Fajok spéci tulajdonságainál vagyok.");
        
        SpeciesService speciesservice = new SpeciesService();
        List<Species> speciesList = speciesservice.getSpeciesList();
        
        if (speciesList == null || speciesList.isEmpty()){
            getServletContext().getRequestDispatcher("/speciesspecialproperty/error.jsp").include(request, response);
        }
        else{
            request.setAttribute("speciesList", speciesList);
            getServletContext().getRequestDispatcher("/speciesspecialproperty/adminindex.jsp").include(request, response);
        }
        
//request.setAttribute("test", "valami");
        
	}
        
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        speciesspecialpropertyService sspservice = new speciesspecialpropertyService();
        List<SpeciesSpecialProperty> actualPropertys = sspservice.getBySpecies(Long.parseLong(request.getParameter("selectedSpeciesId")));
        
        request.setAttribute("actualPropertys", actualPropertys);
        
        SpeciesService speciesservice = new SpeciesService();
        Species selectedSpecies = speciesservice.get(Long.parseLong(request.getParameter("selectedSpeciesId")));
        
        request.setAttribute("selectedSpecies", selectedSpecies);
        
        
        
        request.setAttribute("preSelectedSpeciesId", Long.parseLong(request.getParameter("selectedSpeciesId")));
        
        request.setAttribute("valami", Long.parseLong(request.getParameter("selectedSpeciesId")));
//        request.setAttribute("nempre", request.getParameter("selectedSpeciesId"));

        doGet(request, response);
        }
}
