/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.empires.web;

import hu.javanetacademy.hoe.empires.dao.model.Empires;
import hu.javanetacademy.hoe.empires.service.object.EmpiresService;
import hu.javanetacademy.hoe.user.dao.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Laptop
 */
@WebServlet(name = "EmpiresServlet", urlPatterns = {"/empires"})
public class EmpiresServlet extends HttpServlet {

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
        EmpiresService hs = new EmpiresService();
        
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("empiresList", hs.getByUser(user.getId()));
        getServletContext().getRequestDispatcher("/empires/index.jsp").include(request, response);
        
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
        User user = (User) request.getSession().getAttribute("user");
        Empires newEmpires = new Empires();
        newEmpires.setName(request.getParameter("pname"));
        newEmpires.setDescription(request.getParameter("pdescription")); 
         newEmpires.setUserid(user.getId());
        //newEmpires.setUserid(Long.parseLong(request.getParameter("puserid")));
        newEmpires.setLevel(Long.parseLong(request.getParameter("plevel")));
        newEmpires.setProperty(Long.parseLong(request.getParameter("pproperty")));
        EmpiresService hs = new EmpiresService();
        hs.create(newEmpires);
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
