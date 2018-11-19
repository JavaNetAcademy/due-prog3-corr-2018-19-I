package hu.javanetacademy.hoe.job.jdbc;

import hu.javanetacademy.hoe.job.model.Job;
import hu.javanetacademy.hoe.job.model.JobxHero;
import hu.javanetacademy.hoe.hero.dao.model.Hero;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author gotriang
 */
public class JobJDBC {
 
    private Connection con;

    public JobJDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        } catch (Exception e) {
            System.exit(100);
        }
    }

    
    public Job create(Job pJob) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO job (name,description) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pJob.getName());
            ps.setString(2, pJob.getDescription());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pJob.setId(rs.getLong(1));
                return pJob;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public Job modify(long pJobId, Job pJob, String originalName) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE job SET name=?,description=? WHERE id=?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pJob.getName());
            ps.setString(2, pJob.getDescription());
            ps.setLong(3, pJobId);
            ps.executeUpdate();
            return pJob;
        } catch (SQLException ex) {
            Logger.getLogger(JobJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public Job delete(long pJobId) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM job WHERE id=?", Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, pJobId);
            ps.executeUpdate();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(JobJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public Job get(long pJobId) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id,name,description FROM job WHERE id=?");
            ps.setLong(1, pJobId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Job res = new Job();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public List<Hero> getHeroList(long pJobId) {
        List<Hero> resAll = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id,name FROM hero WHERE jobid=? ORDER BY name");
            ps.setLong(1, pJobId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hero res = new Hero();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                resAll.add(res);
            }
        } catch (SQLException ex) {
        }
        return resAll;
    }

    public List<Job> getJobList() {
      List<Job> resAll = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id,name,description FROM job ORDER BY name");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Job res = new Job();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2)); 
                res.setDescription(rs.getString(3));
                
                resAll.add(res);
            }
        } catch (SQLException ex) {
        }
        return resAll;
    }
    
    
    public boolean existsByName(String pJobName) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT name=? FROM job WHERE name=?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pJobName);
            ps.setString(2, pJobName);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
    public JobxHero createconnector(JobxHero pJobxHero) {
     try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO jobxhero (heroid,jobid,level,xp) VALUES(?,?,1,1)", Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, pJobxHero.getHeroId());
            ps.setLong(2, pJobxHero.getJobId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pJobxHero.setId(rs.getLong(1));
                return pJobxHero;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public JobxHero modifyconnector(long pJobxHeroId, JobxHero pJobxHero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public JobxHero deleteconnector(long pJobxHeroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public JobxHero getconnector(long pJobxHeroId) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean existsByHeroId(String pHeroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
 
}
