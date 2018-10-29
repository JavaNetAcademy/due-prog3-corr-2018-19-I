package hu.javanetacademy.hoe.settlements.web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@WebServlet(name = "SettlementsServlet", urlPatterns = {"/settlements"})
public class SettlementsServlet extends HttpServlet {

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
        
        SettlementsService settlementsService = new SettlementsService();
        EmpiresService empiresService = new EmpiresService();
        
        // belépett User empires-inak kiszedése
        User user = (User)request.getSession().getAttribute("user");
        if (user != null) {
            request.setAttribute("empiresList", empiresService.getByUser(user.getId()));
        }
        
        // empiresList feltöltése <select> listához
        ArrayList<Empires> empires = (ArrayList<Empires>)request.getAttribute("empiresList");
        if (empires == null || empires.size() == 0) {
            getServletContext().getRequestDispatcher("/settlements/noempires.jsp").include(request, response);
        }
        else {
            request.setAttribute("settlementsList", settlementsService.getByEmpire(1)); // TODO make heroid selectable
            getServletContext().getRequestDispatcher("/settlements/index.jsp").include(request, response);
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
        Settlements newSettlements = new Settlements();
        newSettlements.setName(request.getParameter("pname"));
        newSettlements.setDescription(request.getParameter("pdesc"));
        newSettlements.setEmpireid(Long.parseLong(request.getParameter("empires")));

        // a létrehozott új Settlements-el meghívni a create függvényt, amiben még van egy ellenőrzés, hogy létezik-e már Settlements ilyen névvel
        SettlementsService settlementsService = new SettlementsService();
        settlementsService.create(newSettlements);
        
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