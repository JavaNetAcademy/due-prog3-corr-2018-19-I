package hu.javanetacademy.hoe.speciesspecialproperty.web;

import hu.javanetacademy.hoe.species.model.Species;
import hu.javanetacademy.hoe.species.service.SpeciesService;
import hu.javanetacademy.hoe.speciesspecialproperty.dao.model.SpeciesSpecialProperty;
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
@WebServlet(name = "modsspropertyservlet", urlPatterns = { "/modssproperty" })
public class modsspropertyservlet extends HttpServlet {

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
            List<SpeciesSpecialProperty> sspropertyList = sspservice.getSpeciesSpecialPropertyList();

            if (sspropertyList == null || sspropertyList.isEmpty()){
                getServletContext().getRequestDispatcher("/speciesspecialproperty/error.jsp").include(request, response);
            }
            else{
                request.setAttribute("sspropertyList", sspropertyList);
                getServletContext().getRequestDispatcher("/speciesspecialproperty/modssproperty.jsp").include(request, response);
            }
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
            
            if (request.getParameter("selectSsp") != null){
                
                speciesspecialpropertyService sspservice1 = new speciesspecialpropertyService();
                SpeciesSpecialProperty actualProperty = sspservice1.getById(Long.parseLong(request.getParameter("selectedSspId")));

                request.setAttribute("actualProperty", actualProperty);

                SpeciesService speciesservice = new SpeciesService();
                List<Species> speciesList = speciesservice.getSpeciesList();

                request.setAttribute("speciesList", speciesList);
                
            } else if (request.getParameter("modifySsp") != null){
                
                SpeciesSpecialProperty modSsp = new SpeciesSpecialProperty();
                modSsp.setName(request.getParameter("sspname"));
                modSsp.setDescription(request.getParameter("sspdesc"));
                modSsp.setSpeciesid(Long.parseLong(request.getParameter("selectedSpeciesId")));
                modSsp.setLevel(Integer.parseInt(request.getParameter("ssplevel")));
                modSsp.setDefense(Integer.parseInt(request.getParameter("sspdefense")));
                modSsp.setDamage(Integer.parseInt(request.getParameter("sspdamage")));   

                speciesspecialpropertyService sspservice2 = new speciesspecialpropertyService();
                sspservice2.modify(Long.parseLong(request.getParameter("modSspId")), modSsp);
                
                request.setAttribute("actualProperty", null);
            }
            
            doGet(request, response);
        }
}
