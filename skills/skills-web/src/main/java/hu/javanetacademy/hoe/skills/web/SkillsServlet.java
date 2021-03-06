package hu.javanetacademy.hoe.skills.web;

import hu.javanetacademy.hoe.job.model.Job;
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
            request.setAttribute("message", "A képességek használata foglalkozásokhoz kötött. Így legalább egy munkának léteznie kell.");
            getServletContext().getRequestDispatcher("/skills/error.jsp").include(request, response);
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
            skillServ.create(newSkill);
            inputOk = true;
        } catch (SkillsException ex) {
            switch (ex.errCode) {
                case 0:
                    messages.put("pname", ex.getMessage());
                    break;
                case 1:
                    messages.put("pname", ex.getMessage());
                    break;
                case 2:
                    if (messages.get("pvalueInCombat") == null) {
                        messages.put("pvalueInCombat", ex.getMessage());
                    }
                    break;
                case 3:
                    if (messages.get("preqLevel") == null) {
                        messages.put("preqLevel", ex.getMessage());
                    }
                    break;
                case 4:
                    messages.put("JobIds", ex.getMessage());
                    break;
            }
        }
        if (!inputOk) {
            request.setAttribute("userinput", newSkill);
        }
        request.setAttribute("messages", messages);
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
