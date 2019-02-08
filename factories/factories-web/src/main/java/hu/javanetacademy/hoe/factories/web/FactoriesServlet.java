package hu.javanetacademy.hoe.factories.web;

import hu.javanetacademy.hoe.empires.dao.model.Empires;
import hu.javanetacademy.hoe.empires.service.object.EmpiresService;
import hu.javanetacademy.hoe.factories.dao.model.Factories;
import hu.javanetacademy.hoe.factories.service.object.FactoriesService;
import hu.javanetacademy.hoe.user.dao.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jrajmund
 */
@WebServlet(name = "FactoriesServlet", urlPatterns = {"/factories"})
public class FactoriesServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        EmpiresService empireService = new EmpiresService();
        FactoriesService fs = new FactoriesService();
        User loggedInUser = (User) request.getSession().getAttribute("user");
        if (loggedInUser != null) {
            request.setAttribute("empiresList", empireService.getByUser(loggedInUser.getId()));
        }
        ArrayList<Empires> empires = (ArrayList<Empires>) request.getAttribute("empiresList");
        if (empires == null || empires.isEmpty()) {
            getServletContext().getRequestDispatcher("/factories/errornoempire.jsp").include(request, response);
        } else {
            request.setAttribute("factories", fs.getByUser(loggedInUser.getId()));
            //request.setAttribute("empirelevel", fs.getByLevel(1));
            getServletContext().getRequestDispatcher("/factories/index.jsp").include(request, response);
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
        Factories newFactory = new Factories();
        //newFactory.setName(request.getParameter("pname"));
        if (request.getParameter("pname") == null || request.getParameter("pname").isEmpty()) {
            throw new RuntimeException("Nincs név!");
        } else {
            newFactory.setName(request.getParameter("pname"));
        }
        //newFactory.setDescription(request.getParameter("pdesc"));
        if (request.getParameter("pdesc") == null || request.getParameter("pdesc").isEmpty()) {
            throw new RuntimeException("Nincs leírás!");
        } else {
            newFactory.setDescription(request.getParameter("pdesc"));
        }
        newFactory.setEmpireid(Long.parseLong(request.getParameter("pemp")));
        User loggedInUser = (User) request.getSession().getAttribute("user");
        newFactory.setUserid(loggedInUser.getId());
        FactoriesService fs = new FactoriesService();
        fs.create(newFactory);
        doGet(request, response);
        response.sendRedirect("/factories");
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
