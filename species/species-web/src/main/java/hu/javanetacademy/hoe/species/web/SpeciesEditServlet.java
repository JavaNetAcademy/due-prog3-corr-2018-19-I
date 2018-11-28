package hu.javanetacademy.hoe.species.web;


import hu.javanetacademy.hoe.species.model.Species;
import hu.javanetacademy.hoe.species.service.SpeciesService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gotriang
 */
@WebServlet(name = "SpeciesEditServlet", urlPatterns = {"/speciesedit"})
public class SpeciesEditServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
       SpeciesService speciesService = new SpeciesService();
                 
      Species species = speciesService.get(Long.parseLong(request.getParameter("speciesid")));          
       request.setAttribute("species", species);
        
        getServletContext().getRequestDispatcher("/species/speciesedit.jsp").include(request, response);



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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long speciesid = Long.parseLong(request.getParameter("speciesid"));
        String originalSpeciesName = request.getParameter("originalSpeciesName");
        SpeciesService speciesService = new SpeciesService();
        Species species = speciesService.get(speciesid);
        
       species.setName(request.getParameter("pname"));
       species.setDescription(request.getParameter("pdescription"));      
       
        speciesService.modify(speciesid, species, originalSpeciesName);

        response.sendRedirect("/species");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}