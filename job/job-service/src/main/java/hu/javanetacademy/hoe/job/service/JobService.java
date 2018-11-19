package hu.javanetacademy.hoe.job.service;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.job.jdbc.JobJDBC;
import hu.javanetacademy.hoe.job.model.Job;
import hu.javanetacademy.hoe.job.model.JobxHero;
import hu.javanetacademy.hoe.hero.dao.model.Hero;
import java.util.List;

/**
 * @author gotriang
 */
public class JobService {
  
    private JobJDBC dao = new JobJDBC();

    
    public Job create(Job pJob) {
        boolean exists = dao.existsByName(pJob.getName());
        if (exists == false) {
            return dao.create(pJob);
        } else {
            throw new CustomException();
        }
    }

    
    public Job modify(long pJobId, Job pJob, String originalJobName) {
         boolean exists = false;
        String jobName = pJob.getName(); // ha if-en belül job.getName()-et hívtam nem működik jól
        
        // ha csak description-t frissítünk nem kell vizsgálni, hogy létezik-e már a név
        if (!jobName.equals(originalJobName)) {
            exists = dao.existsByName(pJob.getName());
        }
        
        if (exists == false) {
            return dao.modify(pJobId, pJob, originalJobName);
        } else {
            throw new CustomException();
        }
    }
    
     public Job delete(long pJobId) {
        return dao.delete(pJobId);
    }

    
    public Job get(long pJobId) {
        return dao.get(pJobId);
    }

    
    public List<Hero> getHeroList(long pJobId) {
        return dao.getHeroList(pJobId);
    }
    
    public List<Job> getJobList() {
        return dao.getJobList();
    }

    
    public JobxHero createconnector(JobxHero pJobxHero) {
      
            return dao.createconnector(pJobxHero);
       
    }

    
    public JobxHero modifyconnector(long pJobxHeroId, JobxHero pJobxHero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public JobxHero deleteconnector(long pJobxHeroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public JobxHero getconnector(long pHeroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public boolean existsByName(String pJobName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public boolean existsByHeroId(String pHeroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
