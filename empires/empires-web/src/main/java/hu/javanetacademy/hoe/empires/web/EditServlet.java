package hu.javanetacademy.hoe.empires.web;


import hu.javanetacademy.hoe.empires.dao.model.Empires;
import hu.javanetacademy.hoe.empires.service.object.EmpiresService;
import hu.javanetacademy.hoe.user.dao.model.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Laptop
 */
@WebServlet(name = "EditServlet", urlPatterns = {"/edit"})
public class EditServlet extends HttpServlet {

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
        
       EmpiresService empiresService = new EmpiresService();
                 
      Empires empires = empiresService.get(Long.parseLong(request.getParameter("empiresid")));          
       request.setAttribute("empires", empires);
        
        getServletContext().getRequestDispatcher("/empires/edit.jsp").include(request, response);



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
        long empiresid = Long.parseLong(request.getParameter("empiresid"));
        EmpiresService empiresService = new EmpiresService();
        Empires empires = empiresService.get(empiresid);
        
       empires.setName(request.getParameter("pname"));
       empires.setDescription(request.getParameter("pdescription"));      
       
        empiresService.modify(empiresid, empires);

        response.sendRedirect("/empires");
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