package hu.javanetacademy.hoe.factories.web;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.factories.dao.model.Factories;
import hu.javanetacademy.hoe.factories.service.object.FactoriesService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jrajmund
 */
@WebServlet(name = "FactoriesEditServlet", urlPatterns = {"/factoriesedit"})
public class FactoriesEditServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        FactoriesService fs = new FactoriesService();
        long selected = Long.parseLong(request.getParameter("selectedFactory"));
        if (request.getParameter("delete") != null) {
            fs.delete(selected);
            response.sendRedirect("/factories");
        }
        if (request.getParameter("modify") != null) {
            try {
                if (request.getParameter("newfname") != null || request.getParameter("newfdesc") != null) {
                    Factories factory = fs.get(selected);
                    if (!request.getParameter("newfname").equals("")) {
                        factory.setName(request.getParameter("newfname"));
                    }
                    if (!request.getParameter("newfdesc").equals("")) {
                        factory.setDescription(request.getParameter("newfdesc"));
                    }
                    fs.modify(selected, factory);
                    response.sendRedirect("/factories");
                }
            } catch (CustomException ex) {
                request.setAttribute("errormessage", ex.getMessage());
                request.getRequestDispatcher("").forward(request, response);
            }
        }
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

