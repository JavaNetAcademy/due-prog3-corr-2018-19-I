/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.naturaldisaster.web;

/**
 *
 * @author Barna
 */


import hu.javanetacademy.hoe.naturaldisaster.dao.model.Naturaldisaster;
import hu.javanetacademy.hoe.naturaldisaster.service.NaturaldisasterService;
import hu.javanetacademy.hoe.naturaldisaster.dao.jdbc.NaturaldisasterDaoJDBC;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Barna
 */
@WebServlet(name = "NaturaldisasterServlet", urlPatterns = {"/naturaldisaster"})
public class NaturaldisasterServlet extends HttpServlet {
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

        NaturaldisasterService naturaldisasterService = new NaturaldisasterService();
        List<Naturaldisaster> naturaldisasters = naturaldisasterService.getAll();
        request.setAttribute("naturaldisasterList", naturaldisasters);

        getServletContext().getRequestDispatcher("/naturaldisaster/index.jsp").include(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Naturaldisaster isnewnaturaldis = new Naturaldisaster();
        isnewnaturaldis.setName(request.getParameter("xname"));
        isnewnaturaldis.setDescription(request.getParameter("xdescription"));
        isnewnaturaldis.setEffect((request.getParameter("xeffect")));
        isnewnaturaldis.setDeadlyto((request.getParameter("xdeadlyto")));

        NaturaldisasterService naturalService = new NaturaldisasterService();
        naturalService.create(isnewnaturaldis);

        doGet(request, response);
    }
}
