package hu.javanetacademy.hoe.hero.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.javanetacademy.hoe.hero.dao.model.Hero;
import hu.javanetacademy.hoe.hero.service.object.HeroService;
import hu.javanetacademy.hoe.user.dao.model.User;

import hu.javanetacademy.hoe.job.model.Job;
import hu.javanetacademy.hoe.job.model.JobxHero;
import hu.javanetacademy.hoe.job.service.JobService;

import hu.javanetacademy.hoe.species.model.Species;
import hu.javanetacademy.hoe.species.model.SpeciesxHero;
import hu.javanetacademy.hoe.species.service.SpeciesService;

/**
 * @author krisztian
 */
@WebServlet(name = "HeroServlet", urlPatterns = { "/hero" })
public class HeroServlet extends HttpServlet {

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
	// + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
               
		JobService jobservice = new JobService();
		request.setAttribute("jobList", jobservice.getJobList());
		
                SpeciesService speciesservice = new SpeciesService();
		request.setAttribute("speciesList", speciesservice.getSpeciesList());
		
                 HeroService hs = new HeroService();
                User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("heroList", hs.getHeroByUser(user.getId()));
		getServletContext().getRequestDispatcher("/hero/index.jsp").include(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		Hero newHero = new Hero();
             
		JobxHero newJobxHero = new JobxHero();
		newJobxHero.setJobId(Long.parseLong(request.getParameter("job")));
                
                SpeciesxHero newSpeciesxHero = new SpeciesxHero();
		newSpeciesxHero.setSpeciesId(Long.parseLong(request.getParameter("species")));
            
                
                newHero.setName(request.getParameter("pname"));
		newHero.setDescription(request.getParameter("pdescription"));
		
		newHero.setUserid(user.getId());
		HeroService hs = new HeroService();
		hs.create(newHero, newJobxHero, newSpeciesxHero);
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
