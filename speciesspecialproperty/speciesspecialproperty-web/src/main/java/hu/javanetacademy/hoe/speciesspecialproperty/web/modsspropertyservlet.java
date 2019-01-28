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

        speciesspecialpropertyService sspservice1 = new speciesspecialpropertyService();
        List<SpeciesSpecialProperty> sspropertyList = sspservice1.getSpeciesSpecialPropertyList();

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

            long selectedSspId = Long.parseLong(request.getParameter("selectedSspId"));

            speciesspecialpropertyService sspservice2 = new speciesspecialpropertyService();
            SpeciesSpecialProperty actualProperty = sspservice2.getById(selectedSspId);

            request.setAttribute("actualProperty", actualProperty);

            SpeciesService speciesservice = new SpeciesService();
            List<Species> speciesList = speciesservice.getSpeciesList();

            request.setAttribute("speciesList", speciesList);
            request.setAttribute("preSelectedSspropertyId", selectedSspId);
            request.setAttribute("preSelectedSpeciesId", actualProperty.getSpeciesid());
            
        } else if (request.getParameter("modifySsp") != null){

            SpeciesSpecialProperty modSsp = new SpeciesSpecialProperty();
            modSsp.setName(request.getParameter("sspname"));
            modSsp.setDescription(request.getParameter("sspdesc"));
            modSsp.setSpeciesid(Long.parseLong(request.getParameter("selectedSpeciesId")));
            modSsp.setLevel(Integer.parseInt(request.getParameter("ssplevel")));
            modSsp.setDefense(Integer.parseInt(request.getParameter("sspdefense")));
            modSsp.setDamage(Integer.parseInt(request.getParameter("sspdamage")));   
            
            long spricc = Long.parseLong(request.getParameter("selectedSspId"));
/*            
            request.setAttribute("siker1", spricc);
            request.setAttribute("siker2", request.getParameter("sspname"));
            request.setAttribute("siker3", request.getParameter("sspdesc"));
            request.setAttribute("siker4", request.getParameter("selectedSpeciesId"));
            request.setAttribute("siker5", request.getParameter("ssplevel"));
            request.setAttribute("siker6", request.getParameter("sspdefense"));
            request.setAttribute("siker7", request.getParameter("sspdamage"));
*/
            speciesspecialpropertyService sspservice3 = new speciesspecialpropertyService();
            sspservice3.modify(spricc, modSsp);

            request.setAttribute("actualProperty", null);
        }
        doGet(request, response);
    }
}
