package hu.javanetacademy.hoe.skills.web;

import hu.javanetacademy.hoe.hero.dao.model.Hero;
import hu.javanetacademy.hoe.hero.service.object.HeroService;
import hu.javanetacademy.hoe.job.model.JobxHero;
import hu.javanetacademy.hoe.job.service.JobService;
import hu.javanetacademy.hoe.skills.dao.model.HeroSkill;
import hu.javanetacademy.hoe.skills.dao.model.SkillBase;
import hu.javanetacademy.hoe.skills.sercice.object.HeroSkillsServiceImpl;
import hu.javanetacademy.hoe.skills.sercice.object.SkillsServiceImpl;
import hu.javanetacademy.hoe.user.dao.model.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Kovacs Maria
 */
@WebServlet(name = "HeroSkills", urlPatterns = {"/heroskills"})
public class HeroSkillsServlet extends HttpServlet {

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
        User user = (User) request.getSession().getAttribute("user");
        //mi van ha nincs bejelentkezve?
        HeroService heroServ = new HeroService();
        List<Hero> heroList = heroServ.getHeroByUser(user.getId());
        if (heroList == null || heroList.isEmpty()) {
            request.setAttribute("message","Még nincs hősöd!");
            getServletContext().getRequestDispatcher("/skills/error.jsp").include(request, response);
        } else {
            request.setAttribute("heroList", heroList);
            getServletContext().getRequestDispatcher("/skills/heroskills.jsp").include(request, response);
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
        HeroSkillsServiceImpl hSkillServ = new HeroSkillsServiceImpl();
        HeroService heroServ = new HeroService();
        Hero  selectedHero = heroServ.get(Long.parseLong(request.getParameter("selectedHeroId")));
        List<HeroSkill> actualSkills = hSkillServ.skillsByHero(selectedHero.getId());
        request.setAttribute("actualSkills", actualSkills);
        SkillsServiceImpl skillServ = new SkillsServiceImpl();
        JobService jobServ = new JobService();
        List<SkillBase> availableSkills = new ArrayList<>();
        try {
            JobxHero heroJob = jobServ.getconnector(selectedHero.getId());
            availableSkills = skillServ.availableSkills(selectedHero.getId(), (long) heroJob.getLevel(), heroJob.getJobId());
        } catch (UnsupportedOperationException ex) {
            availableSkills = skillServ.notUsedByHero(selectedHero.getId());
        }
        request.setAttribute("availableSkills", availableSkills);
        request.setAttribute("selectedHero", selectedHero);
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
