package hu.javanetacademy.hoe.weapons.web;

import hu.javanetacademy.hoe.hero.dao.model.Hero;
import hu.javanetacademy.hoe.hero.service.object.HeroService;
import hu.javanetacademy.hoe.user.dao.model.User;
import hu.javanetacademy.hoe.weapons.dao.model.Weapon;
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
@WebServlet(name = "DeleteWeaponsServlet", urlPatterns = {"/weapons/delete"})
public class DeleteWeaponsServlet extends HttpServlet {

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
        
        User user = (User)request.getSession().getAttribute("user");
        Weapon weapon = weaponService.get(Long.parseLong(request.getParameter("id")));
        if (user != null) {
            request.setAttribute("weapon", weapon);
            getServletContext().getRequestDispatcher("/weapons/delete.jsp").include(request, response);
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
        long weaponId = Long.parseLong(request.getParameter("id"));
        WeaponsService ws = new WeaponsService();
        
        ws.delete(weaponId);

        response.sendRedirect("/weapons");
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
