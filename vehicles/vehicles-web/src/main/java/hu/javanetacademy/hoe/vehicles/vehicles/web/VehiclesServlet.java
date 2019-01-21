package hu.javanetacademy.hoe.vehicles.vehicles.web;

import hu.javanetacademy.hoe.hero.dao.model.Hero;
import hu.javanetacademy.hoe.hero.service.object.HeroService;
import hu.javanetacademy.hoe.vehicles.dao.model.Vehicle;
import hu.javanetacademy.hoe.vehicles.service.object.VehicleServiceObjectImpl;
import hu.javanetacademy.hoe.user.dao.model.User;
import hu.javanetacademy.hoe.vehicles.dao.jdbc.VehicleDaoJDBCImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VehiclesServlet", urlPatterns = {"/vehicles"})
public class VehiclesServlet extends HttpServlet {

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
        List<Vehicle> allVehicles = vehiclesService.getAll();
        request.setAttribute("vehicleList", allVehicles);

        getServletContext().getRequestDispatcher("/vehicles/index.jsp").include(request, response);
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
        Vehicle newVehicle = new Vehicle();
        newVehicle.setName(request.getParameter("pname"));
        newVehicle.setDescription(request.getParameter("pdescription"));
        newVehicle.setAvgSpeed(Long.parseLong(request.getParameter("pavgspeed")));
        newVehicle.setMaxSpeed(Long.parseLong(request.getParameter("pmaxspeed")));
        newVehicle.setMaxSpeedTimeout(Long.parseLong(request.getParameter("pmaxspeedtimeout")));
        newVehicle.setMaxLoad(Long.parseLong(request.getParameter("pmaxload")));
        newVehicle.setCrew(Long.parseLong(request.getParameter("pcrew")));
        newVehicle.setPrice(Long.parseLong(request.getParameter("pprice")));

        VehicleServiceObjectImpl vehiclesService = new VehicleServiceObjectImpl();
        vehiclesService.create(newVehicle);

        doGet(request, response);
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
