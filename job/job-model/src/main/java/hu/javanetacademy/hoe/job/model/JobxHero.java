/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.job.model;

/**
 *
 * @author gotriang
 */
public class JobxHero  {
    protected long id,heroid,jobid;
    protected int level,xp;
  

    public JobxHero() {
    }

    public JobxHero(long id, long heroid, long jobid, int level, int xp) {
         this.id = id;
        this.heroid = heroid;
        this.jobid = jobid;
        this.level = level;
        this.xp = xp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHeroid() {
        return heroid;
    }

    public void setHeroid(long heroid) {
        this.heroid = heroid;
    }

    public long getJobid() {
        return jobid;
    }

    public void setJobid(long jobid) {
        this.jobid = jobid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    
   
    
}
