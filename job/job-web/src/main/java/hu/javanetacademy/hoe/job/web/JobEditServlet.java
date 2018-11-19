package hu.javanetacademy.hoe.job.web;


import hu.javanetacademy.hoe.job.model.Job;
import hu.javanetacademy.hoe.job.service.JobService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gotriang
 */
@WebServlet(name = "JobEditServlet", urlPatterns = {"/jobedit"})
public class JobEditServlet extends HttpServlet {

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
        
       JobService jobService = new JobService();
                 
      Job job = jobService.get(Long.parseLong(request.getParameter("jobid")));          
       request.setAttribute("job", job);
        
        getServletContext().getRequestDispatcher("/job/jobedit.jsp").include(request, response);



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
        long jobid = Long.parseLong(request.getParameter("jobid"));
        String originalJobName = request.getParameter("originalJobName");
        JobService jobService = new JobService();
        Job job = jobService.get(jobid);
        
       job.setName(request.getParameter("pname"));
       job.setDescription(request.getParameter("pdescription"));      
       
        jobService.modify(jobid, job, originalJobName);

        response.sendRedirect("/job");
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