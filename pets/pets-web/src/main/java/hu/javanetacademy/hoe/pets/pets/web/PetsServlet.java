package hu.javanetacademy.hoe.pets.pets.web;

import hu.javanetacademy.hoe.pets.dao.model.Pet;
import hu.javanetacademy.hoe.pets.pets.service.object.PetsService;
// import hu.javanetacademy.hoe.user.dao.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Heyzel (Horvath Gergely)
 */
@WebServlet(name = "PetsServlet", urlPatterns = {"/pets"})
public class PetsServlet extends HttpServlet {

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
        // TODO get pets for the hero instead of the user

        // PetsService petsService = new PetsService();
        // User user = (User)request.getSession().getAttribute("user");
        // request.setAttribute("heroes", petsService.getForHero(user.getId()));
        
        PetsService petsService = new PetsService();
        request.setAttribute("petList", petsService.getForHero(1)); // TODO make heroid selectable

        getServletContext().getRequestDispatcher("/pets/index.jsp").include(request, response);
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
        // TODO set heroid instead of userid
        // User user = (User)request.getSession().getAttribute("user");
        Pet newPet = new Pet();
        newPet.setName(request.getParameter("pname"));
        newPet.setDescription(request.getParameter("pdesc"));
        // newPet.setHeroid(user.getId());
        PetsService petsService = new PetsService();
        petsService.create(newPet);
        doGet(request, response);
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