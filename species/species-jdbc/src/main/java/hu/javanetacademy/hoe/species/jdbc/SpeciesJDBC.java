package hu.javanetacademy.hoe.species.jdbc;

import hu.javanetacademy.hoe.species.model.Species;
import hu.javanetacademy.hoe.species.model.SpeciesxHero;
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
public class SpeciesJDBC {
 
    private Connection con;

    public SpeciesJDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        } catch (Exception e) {
            System.exit(100);
        }
    }

    
    public Species create(Species pSpecies) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO species (name,description) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pSpecies.getName());
            ps.setString(2, pSpecies.getDescription());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pSpecies.setId(rs.getLong(1));
                return pSpecies;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SpeciesJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public Species modify(long pSpeciesId, Species pSpecies, String originalName) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE species SET name=?,description=? WHERE id=?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pSpecies.getName());
            ps.setString(2, pSpecies.getDescription());
            ps.setLong(3, pSpeciesId);
            ps.executeUpdate();
            return pSpecies;
        } catch (SQLException ex) {
            Logger.getLogger(SpeciesJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public Species delete(long pSpeciesId) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM species WHERE id=?", Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, pSpeciesId);
            ps.executeUpdate();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(SpeciesJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public Species get(long pSpeciesId) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id,name,description FROM species WHERE id=?");
            ps.setLong(1, pSpeciesId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Species res = new Species();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SpeciesJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public List<Hero> getHeroList(long pSpeciesId) {
        List<Hero> resAll = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id,name FROM hero WHERE speciesid=? ORDER BY name");
            ps.setLong(1, pSpeciesId);
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

    public List<Species> getSpeciesList() {
      List<Species> resAll = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id,name,description FROM species ORDER BY name");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Species res = new Species();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2)); 
                res.setDescription(rs.getString(3));
                
                resAll.add(res);
            }
        } catch (SQLException ex) {
        }
        return resAll;
    }
    
    
    public boolean existsByName(String pSpeciesName) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT name=? FROM species WHERE name=?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pSpeciesName);
            ps.setString(2, pSpeciesName);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SpeciesJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
    public SpeciesxHero createconnector(SpeciesxHero pSpeciesxHero) {
     try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO speciesxhero (heroid,speciesid) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, pSpeciesxHero.getHeroId());
            ps.setLong(2, pSpeciesxHero.getSpeciesId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pSpeciesxHero.setId(rs.getLong(1));
                return pSpeciesxHero;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SpeciesJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public SpeciesxHero modifyconnector(long pSpeciesxHeroId, SpeciesxHero pSpeciesxHero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public SpeciesxHero deleteconnector(long pSpeciesxHeroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public SpeciesxHero getconnector(long pSpeciesxHeroId) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean existsByHeroId(String pHeroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
 
}
