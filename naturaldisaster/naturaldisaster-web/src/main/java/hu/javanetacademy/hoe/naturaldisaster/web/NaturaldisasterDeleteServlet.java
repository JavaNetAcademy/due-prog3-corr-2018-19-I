/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.naturaldisaster.web;
import hu.javanetacademy.hoe.naturaldisaster.dao.model.Naturaldisaster;
import hu.javanetacademy.hoe.naturaldisaster.service.NaturaldisasterService;
import hu.javanetacademy.hoe.naturaldisaster.dao.jdbc.NaturaldisasterDaoJDBC;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Barna
 */
@WebServlet(name = "VehicleDeleteServlet", urlPatterns = {"/vehicledelete"})
public class NaturaldisasterDeleteServlet extends HttpServlet {
        
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

        NaturaldisasterService naturalService = new NaturaldisasterService();
        Naturaldisaster naturaldisaster = naturalService.getbyName("name");

        request.setAttribute("naturaldisaster", naturaldisaster);
        getServletContext().getRequestDispatcher("/naturaldisaster/delete.jsp").include(request, response);
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
        String disasterName = request.getParameter("name");

        NaturaldisasterService naturalService = new NaturaldisasterService();
        naturalService.Delete(disasterName);

        response.sendRedirect("/naturaldisaster");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
