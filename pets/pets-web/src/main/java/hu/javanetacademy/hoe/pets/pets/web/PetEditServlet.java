package hu.javanetacademy.hoe.pets.pets.web;

import hu.javanetacademy.hoe.hero.dao.model.Hero;
import hu.javanetacademy.hoe.hero.service.object.HeroService;
import hu.javanetacademy.hoe.pets.dao.model.Pet;
import hu.javanetacademy.hoe.pets.pets.service.object.PetsService;
import hu.javanetacademy.hoe.user.dao.model.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Heyzel (Horvath Gergely)
 */
@WebServlet(name = "PetEditServlet", urlPatterns = {"/petedit"})
public class PetEditServlet extends HttpServlet {

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
        
        PetsService petsService = new PetsService();
        HeroService heroService = new HeroService();
        
        User user = (User)request.getSession().getAttribute("user");
        Pet pet = petsService.get(Long.parseLong(request.getParameter("petid")));
        
        if (user != null) {
            request.setAttribute("heroList", heroService.getHeroByUser(user.getId()));
        }
        
        ArrayList<Hero> heroes = (ArrayList<Hero>)request.getAttribute("heroList");
        if (heroes == null || heroes.size() == 0) {
            getServletContext().getRequestDispatcher("/pets/noheroes.jsp").include(request, response);
        }
        else {
            request.setAttribute("pet", pet);
            getServletContext().getRequestDispatcher("/pets/edit.jsp").include(request, response);
        }
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
        long petid = Long.parseLong(request.getParameter("petid"));
        String origName = request.getParameter("originalName");
        PetsService petsService = new PetsService();
        Pet pet = petsService.get(petid);
        
        pet.setName(request.getParameter("pname"));
        pet.setDescription(request.getParameter("pdesc"));
        pet.setHeroid(Long.parseLong(request.getParameter("hero")));
        
        petsService.modify(petid, origName, pet);

        response.sendRedirect("/pets");
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