package hu.javanetacademy.hoe.skills.web;

import hu.javanetacademy.hoe.skills.dao.model.HeroSkill;
import hu.javanetacademy.hoe.skills.sercice.object.HeroSkillsServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Kovacs Maria
 */
@WebServlet(name = "ImproveSkillServlet", urlPatterns = {"/improveskill"})
public class ImproveSkillServlet extends HttpServlet {


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
        HeroSkillsServiceImpl hSkillServ = new HeroSkillsServiceImpl();
        HeroSkill temp = hSkillServ.get(Long.parseLong(request.getParameter("selectedSkillId")), Long.parseLong(request.getParameter("selectedHeroId")));
        temp.setSkillLevel(temp.getSkillLevel()+1);
        hSkillServ.modifyLevel(temp);
        getServletContext().getRequestDispatcher("/heroskills").forward(request, response);
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
