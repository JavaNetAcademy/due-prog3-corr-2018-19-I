/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoebirodalmak.web;

import hu.javanetacademy.hoe.birodalmak.dao.model.Birodalmak;
import hu.javanetacademy.hoe.birodalmak.service.object.BirodalmakService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Laptop
 */
@WebServlet(name = "BirodalmakServlet", urlPatterns = {"/birodalmak"})
public class BirodalmakServlet extends HttpServlet {

   

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
        BirodalmakService hs = new BirodalmakService();
        request.setAttribute("birodalmak",hs.getHeroByUser(100));
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
        Birodalmak newBirodalmak = new Birodalmak();
        newBirodalmak.setName(request.getParameter("pname"));
        newBirodalmak.setDescription(request.getParameter("pdesc"));
        newBirodalmak.setUserid(100);
        newBirodalmak.setLevel(10);
        newBirodalmak.setVagyon(100);
        BirodalmakService hs = new BirodalmakService();
        hs.create(newBirodalmak);
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
