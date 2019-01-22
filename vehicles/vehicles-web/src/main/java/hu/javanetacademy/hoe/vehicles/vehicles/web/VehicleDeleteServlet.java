package hu.javanetacademy.hoe.vehicles.vehicles.web;

import hu.javanetacademy.hoe.hero.dao.model.Hero;
import hu.javanetacademy.hoe.hero.service.object.HeroService;
import hu.javanetacademy.hoe.vehicles.dao.model.Vehicle;
import hu.javanetacademy.hoe.vehicles.service.object.VehicleServiceObjectImpl;
import hu.javanetacademy.hoe.user.dao.model.User;
import hu.javanetacademy.hoe.vehicles.dao.jdbc.VehicleDaoJDBCImpl;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VehicleDeleteServlet", urlPatterns = {"/vehicledelete"})
public class VehicleDeleteServlet extends HttpServlet {

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

        VehicleServiceObjectImpl vehiclesService = new VehicleServiceObjectImpl();
        Vehicle vehicle = vehiclesService.getById(Long.parseLong(request.getParameter("vehicleid")));

        request.setAttribute("vehicle", vehicle);
        getServletContext().getRequestDispatcher("/vehicles/delete.jsp").include(request, response);
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
        long vehicleid = Long.parseLong(request.getParameter("vehicleid"));

        VehicleServiceObjectImpl vehiclesService = new VehicleServiceObjectImpl();
        vehiclesService.delete(vehicleid);

        response.sendRedirect("/vehicles");
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
