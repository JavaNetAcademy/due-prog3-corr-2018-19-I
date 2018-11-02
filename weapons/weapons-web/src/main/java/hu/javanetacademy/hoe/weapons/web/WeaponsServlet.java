package hu.javanetacademy.hoe.weapons.web;

import hu.javanetacademy.hoe.hero.dao.model.Hero;
import hu.javanetacademy.hoe.hero.service.object.HeroService;
import hu.javanetacademy.hoe.user.dao.model.User;
import hu.javanetacademy.hoe.weapons.service.object.WeaponsService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Richard
 */
@WebServlet(name = "WeaponServlet", urlPatterns = {"/weapons"})
public class WeaponsServlet extends HttpServlet {

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
        
        WeaponsService weaponService = new WeaponsService();
        HeroService heroService = new HeroService();
        
        User user = (User)request.getSession().getAttribute("user");
        if (user != null) {
            request.setAttribute("heroList", heroService.getHeroByUser(user.getId()));
        }
        
        ArrayList<Hero> heroes = (ArrayList<Hero>)request.getAttribute("heroList");
        if (heroes == null || heroes.size() == 0) {
            getServletContext().getRequestDispatcher("/weapons/noheroes.jsp").include(request, response);
        }
        else {
            // TODO (richardpaj): legyen ez valaszthato, hogy milyen heroid-hez
            // toltodnek be a fegyverek
            request.setAttribute("weapons", weaponService.getForHero(3));
            getServletContext().getRequestDispatcher("/weapons/index.jsp").include(request, response);
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
