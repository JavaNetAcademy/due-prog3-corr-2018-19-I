package hu.javanetacademy.hoe.speciesspecialproperty.web;

import hu.javanetacademy.hoe.speciesspecialproperty.dao.model.SpeciesSpecialProperty;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
  * @author sviktor75 / Szabó Viktor / vts4gv
 */
@WebServlet(name = "sspservice", urlPatterns = { "/ssp" })
public class SpeciesSpecialPropertyServlet extends HttpServlet {

       

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        response.getWriter().print("Fajok spéci tulajdonságainál vagyok.");
       
            
                
	}
        
        
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        
        
        }

}
