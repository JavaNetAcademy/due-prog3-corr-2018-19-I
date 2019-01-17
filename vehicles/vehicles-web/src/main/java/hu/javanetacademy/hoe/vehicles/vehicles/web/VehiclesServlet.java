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

@WebServlet(name = "VehiclesServlet", urlPatterns = {"/fostos"})
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
        throw new ServletException("nem adja");
//        response.getWriter().print("aham");
//        System.out.println("== INDUL ==");
//
//        response.setContentType("text/html;charset=UTF-8");
//
//        VehicleServiceObjectImpl vehiclesService = new VehicleServiceObjectImpl();
//        List<Vehicle> allVehicles = vehiclesService.GetAll();
//        request.setAttribute("vehicleList", allVehicles);
//
//        getServletContext().getRequestDispatcher("/vehicles/index.jsp").include(request, response);
//
////        Logger.getLogger(VehicleDaoJDBCImpl.class.getName()).log(Level.INFO, null, "== LEFUT ==");
//        System.out.println("== LEFUT ==");


//
//        // heroList feltöltése <select> listához
//        ArrayList<Hero> heroes = (ArrayList<Hero>)request.getAttribute("heroList");
//        if (heroes == null || heroes.size() == 0) {
//            getServletContext().getRequestDispatcher("/vehicles/noheroes.jsp").include(request, response);
//        }
//        else {
//            request.setAttribute("vehicleList", vehiclesService.getForHero(1)); // TODO make heroid selectable
//            getServletContext().getRequestDispatcher("/vehicles/index.jsp").include(request, response);
//        }
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
//        Vehicle newVehicle = new Vehicle();
//        newVehicle.setName(request.getParameter("pname"));
//        newVehicle.setDescription(request.getParameter("pdesc"));
//        newVehicle.setHeroid(Long.parseLong(request.getParameter("hero")));
//
//        // a létrehozott új Vehicle-el meghívni a create függvényt, amiben még van egy ellenőrzés, hogy létezik-e már Vehicle ilyen névvel
//        VehiclesService vehiclesService = new VehiclesService();
//        vehiclesService.create(newVehicle);

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
