package hu.javanetacademy.hoe.speciesspecialproperty.web;

import hu.javanetacademy.hoe.species.service.SpeciesService;
import hu.javanetacademy.hoe.speciesspecialproperty.service.object.speciesspecialpropertyService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
  * @author sviktor75 / Szabó Viktor / vts4gv
 */
@WebServlet(name = "newsspropertyservlet", urlPatterns = { "/newssproperty" })
public class newsspropertyservlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        speciesspecialpropertyService sspservice = new speciesspecialpropertyService();
        request.setAttribute("ssplist", sspservice.getSpeciesList());
        
        SpeciesService speciesservice = new SpeciesService();
        request.setAttribute("speciesList", speciesservice.getSpeciesList());
        
        getServletContext().getRequestDispatcher("/speciesspecialproperty/newssproperty.jsp").include(request, response);
        

	}
        
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        
        
        }

}
