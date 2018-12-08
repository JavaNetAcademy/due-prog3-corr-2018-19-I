package hu.javanetacademy.hoe.skills.skills.web;

import hu.javanetacademy.hoe.job.model.Job;
import hu.javanetacademy.hoe.job.service.JobService;
import hu.javanetacademy.hoe.skills.dao.model.Skill;
import hu.javanetacademy.hoe.skills.sercice.object.SkillsServiceImpl;
import hu.javanetacademy.hoe.skills.sercice.object.exceptions.NoJobForSkillException;
import hu.javanetacademy.hoe.skills.sercice.object.exceptions.NoNameForSkillException;
import hu.javanetacademy.hoe.skills.sercice.object.exceptions.NoRequiredLevelException;
import hu.javanetacademy.hoe.skills.sercice.object.exceptions.NoValueInCombatException;
import hu.javanetacademy.hoe.skills.sercice.object.exceptions.UsedSkillNameException;
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
 * @author Kovacs Maria
 */
@WebServlet(name = "SkillsServlet", urlPatterns = {"/skills"})
public class SkillsServlet extends HttpServlet {

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
        JobService jobServ = new JobService();
        List<Job> jobList = jobServ.getJobList();
        if (jobList == null || jobList.isEmpty()) {
            getServletContext().getRequestDispatcher("/skills/nojob.jsp").include(request, response);
        } else {

            SkillsServiceImpl skillServ = new SkillsServiceImpl();
            request.setAttribute("skillList", skillServ.getAll());

            request.setAttribute("jobList", jobServ.getJobList());
            getServletContext().getRequestDispatcher("/skills/adminindex.jsp").include(request, response);
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
        Skill newSkill = new Skill();
        Map<String, String> messages = new HashMap<>();
        boolean inputOk = false;
        request.setAttribute("messages", messages);
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
        } catch (NumberFormatException e) {
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
            skillServ.create(newSkill);
            inputOk = true;
        } catch (NoNameForSkillException ex) {
            messages.put("pname", ex.getMessage());
        } catch (UsedSkillNameException ex) {
            messages.put("pname", ex.getMessage());
        } catch (NoValueInCombatException ex) {
            messages.put("pvalueInCombat", ex.getMessage());
        } catch (NoRequiredLevelException ex) {
            messages.put("preqLevel", ex.getMessage());
        } catch (NoJobForSkillException ex) {
            messages.put("JobIds", ex.getMessage());
        }

        if (!inputOk) {
            request.setAttribute("userinput", newSkill);
        }

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
