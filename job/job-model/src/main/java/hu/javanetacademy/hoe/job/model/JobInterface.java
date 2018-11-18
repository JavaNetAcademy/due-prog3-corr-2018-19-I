/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.job.model;

import java.util.List;
import hu.javanetacademy.hoe.hero.dao.model.Hero;
/**
 *
 * @author gotriang
 */
public interface JobInterface {
 
    public Job create(Job pJob);
    public JobxHero createconnector(JobxHero pJobxHero);
    
    public Job modify(long pJobId, Job pJob, String originalName);
    public JobxHero modifyconnector(long pJobxHeroId, JobxHero pJobxHero);
    
    public Job delete(long pJobId);
    public JobxHero deleteconnector(long pJobxHeroId);

    public Job get(long pJobId);
    public JobxHero getconnector(long pHeroId);

    public List<Job> getJobList();
    public List<Hero> getHeroList(long pJobId);
    
   public boolean existsByName(String pJobName);
   
}
