package hu.javanetacademy.hoe.skills.web;

import hu.javanetacademy.hoe.skills.sercice.object.SkillsServiceImpl;
import hu.javanetacademy.hoe.skills.sercice.object.exceptions.SkillsException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Kovacs Maria
 */
@WebServlet(name = "DelSkillServlet", urlPatterns = {"/delskill"})
public class DelSkillServlet extends HttpServlet {

    

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
         SkillsServiceImpl skillServ = new SkillsServiceImpl();
         boolean delOk =true;
         String delMessage ="Sikeres törles";
         try {
             skillServ.delete(Long.parseLong(request.getParameter("skillId")));         
        } catch (SkillsException ex){
            delMessage="Nem törölhető! "+ex.message;
            delOk=false;
        } 
         request.setAttribute("delMessage", delMessage);
         getServletContext().getRequestDispatcher("/skills/modskills.jsp").forward(request,response);
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
