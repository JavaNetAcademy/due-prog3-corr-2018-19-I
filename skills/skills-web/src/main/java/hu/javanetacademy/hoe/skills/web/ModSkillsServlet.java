/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.skills.web;

import hu.javanetacademy.hoe.job.service.JobService;
import hu.javanetacademy.hoe.skills.dao.model.Skill;
import hu.javanetacademy.hoe.skills.sercice.object.SkillsServiceImpl;
import hu.javanetacademy.hoe.skills.sercice.object.exceptions.SkillsException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kovacs Maria
 */
@WebServlet(name = "ModSkillsServlet", urlPatterns = {"/modskills"})
public class ModSkillsServlet extends HttpServlet {

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
        SkillsServiceImpl skillServ = new SkillsServiceImpl();
        Skill sk = skillServ.get(Long.parseLong(request.getParameter("skillId")));
        request.setAttribute("modSk", sk);
        JobService jobServ = new JobService();
        request.setAttribute("jobList", jobServ.getJobList());
        getServletContext().getRequestDispatcher("/skills/modskills.jsp").include(request, response);
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
        Skill newSkill = new Skill();
        Map<String, String> messages = new HashMap<>();
        boolean modOk = false;
        newSkill.setId(Long.parseLong(request.getParameter("skillId")));
        newSkill.setName(request.getParameter("pname"));
        newSkill.setDescription(request.getParameter("pdescription"));
        newSkill.setOffensive(Boolean.valueOf(request.getParameter("poffensive")));
        try {
            newSkill.setValueInCombat(Long.parseLong(request.getParameter("pvalueInCombat")));
        } catch (NumberFormatException ex) {
            messages.put("pvalueInCombat", "Nem megfelelő számformátum.");
        }
        try {
            newSkill.setReqLevel(Long.parseLong(request.getParameter("preqLevel")));
        } catch (NumberFormatException ex) {
            messages.put("preqLevel", "Nem megfelelő számformátum.");
        }
        SkillsServiceImpl skillServ = new SkillsServiceImpl();
        try {
            List<Long> jobIds = new ArrayList<>();
            String[] temp = request.getParameterValues("JobIds");
            if (temp != null) {
                for (String temp1 : temp) {
                    jobIds.add(Long.parseLong(temp1));
                }
            }
            newSkill.setReqJobIds(jobIds);
            skillServ.modify(newSkill.getId(), newSkill);
            modOk = true;
        } catch (SkillsException ex) {
            switch(ex.errCode){
                case 0:
                     messages.put("pname", ex.getMessage());
                     break;
                case 1:
                     messages.put("pname", ex.getMessage());
                     break;
                case 2:
                     messages.put("pvalueInCombat", ex.getMessage());
                     break;
                case 3:
                     messages.put("preqLevel", ex.getMessage());
                     break;
                case 4:
                     messages.put("JobIds", ex.getMessage());
                     break;                
            }
        }
        String modMessage;
        if (modOk) {
            modMessage = "Sikeres módosítás";
        } else {
            modMessage = "Nem sikerült módosítani";
        }
        request.setAttribute("messages", messages);
        request.setAttribute("modMessage", modMessage);
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
