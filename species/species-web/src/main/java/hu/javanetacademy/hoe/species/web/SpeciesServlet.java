/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.species.web;

import hu.javanetacademy.hoe.species.model.Species;
import hu.javanetacademy.hoe.species.service.SpeciesService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gotriang
 */
@WebServlet(name = "SpeciesServlet", urlPatterns = {"/species"})
public class SpeciesServlet extends HttpServlet {

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
        SpeciesService hs = new SpeciesService();
        request.setAttribute("speciesList", hs.getSpeciesList());
        getServletContext().getRequestDispatcher("/species/index.jsp").include(request, response);

       // getServletContext().getRequestDispatcher("/species/list.jsp").include(request, response);

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
        Species newSpecies = new Species();
        newSpecies.setName(request.getParameter("pname"));
        newSpecies.setDescription(request.getParameter("pdescription"));
        SpeciesService hs = new SpeciesService();
        hs.create(newSpecies);
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
