package hu.javanetacademy.hoe.hero.web;


import hu.javanetacademy.hoe.hero.dao.model.Hero;
import hu.javanetacademy.hoe.hero.dao.model.HeroDAOInterface;
import hu.javanetacademy.hoe.hero.service.object.HeroService;
import hu.javanetacademy.hoe.user.dao.model.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gotriang
 */
@WebServlet(name = "HeroEditServlet", urlPatterns = {"/heroedit"})
public class HeroEditServlet extends HttpServlet {

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
        
       HeroService heroService = new HeroService();
      Hero hero = heroService.get(Long.parseLong(request.getParameter("heroid")));          
       request.setAttribute("hero", hero);
        
        getServletContext().getRequestDispatcher("/hero/heroedit.jsp").include(request, response);



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
        long heroid = Long.parseLong(request.getParameter("heroid"));
        String originalHeroName = request.getParameter("originalHeroName");
        HeroService heroService = new HeroService();
        Hero hero = heroService.get(heroid);
        
       hero.setName(request.getParameter("pname"));
       hero.setDescription(request.getParameter("pdescription"));      
       
        heroService.modify(heroid, hero);

        response.sendRedirect("/hero");
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