package hu.javanetacademy.hoe.settlements.web;

import hu.javanetacademy.hoe.empires.dao.model.Empires;
import hu.javanetacademy.hoe.empires.service.object.EmpiresService;
import hu.javanetacademy.hoe.settlements.dao.model.Settlements;
import hu.javanetacademy.hoe.settlements.service.object.SettlementsService;
import hu.javanetacademy.hoe.user.dao.model.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Prototype_ (Szabó Zoltán)
 */
@WebServlet(name = "SettlementsDeleteServlet", urlPatterns = {"/settlementsdelete"})
public class SettlementsDeleteServlet extends HttpServlet {
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
        
        SettlementsService ss = new SettlementsService();
        EmpiresService es = new EmpiresService();
        
        User user = (User)request.getSession().getAttribute("user");
        Settlements settlements = ss.get(Long.parseLong(request.getParameter("settlementsid")));
        
        if (user != null) {
            request.setAttribute("empiresList", es.getByUser(user.getId()));
        }
        
        ArrayList<Empires> empire = (ArrayList<Empires>)request.getAttribute("empiresList");
        if (empire == null || empire.size() == 0) {
            getServletContext().getRequestDispatcher("/settlements/noempires.jsp").include(request, response);
        }
        else {
            Empires empires = new Empires();
            try {
                empires = es.get(settlements.getEmpireid());
            }
            catch (Exception e) {
                empires = null;
            }
            
            // Ha nem létezik már a hős, de a pet mégis, akkor se szálljon el
            if (empires != null) {
                request.setAttribute("empiresName", empires.getName());
            } else {
                request.setAttribute("empiresName", "");
            }
            
            request.setAttribute("settlements", settlements);
            getServletContext().getRequestDispatcher("/settlements/delete.jsp").include(request, response);
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
        long settlementsid = Long.parseLong(request.getParameter("settlementsid"));
        SettlementsService settlementsService = new SettlementsService();
        
        settlementsService.delete(settlementsid);

        response.sendRedirect("/settlements");
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
