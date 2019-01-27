package hu.javanetacademy.hoe.speciesspecialproperty.dao.jdbc;

import hu.javanetacademy.hoe.speciesspecialproperty.dao.model.SpeciesSpecialProperty;
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
import hu.javanetacademy.hoe.speciesspecialproperty.dao.model.SpeciesSpecialPropertyDao;

/**
  * @author sviktor75 / Szabó Viktor / vts4gv
 */
public class SspJDBCDAOImpl implements SpeciesSpecialPropertyDao {

    // Kapcsolat létrehozása az adatbázissal
    private Connection con;

    public SspJDBCDAOImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        } catch (Exception e) {
            System.exit(100);
        }
    }

    @Override
    public SpeciesSpecialProperty create (SpeciesSpecialProperty pSsp){
           try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO speciesspecialproperty (name,description,speciesid,level,damage,defense) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pSsp.getName());
            ps.setString(2, pSsp.getDescription());
            ps.setLong(3, pSsp.getSpeciesid());
            ps.setInt(4, pSsp.getLevel());
            ps.setInt(5, pSsp.getDamage());
            ps.setInt(6, pSsp.getDefense());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pSsp.setId(rs.getLong(1));
                return pSsp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SspJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   
    }
    
    @Override
    public SpeciesSpecialProperty getById(long pSspId){
        try{
            PreparedStatement ps =con.prepareStatement("SELECT id,name,description,speciesid,level,damage,defense FROM speciesspecialproperty WHERE id=?");
            ps.setLong(1,pSspId);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
               SpeciesSpecialProperty res=new SpeciesSpecialProperty();
               res.setId(rs.getLong(1));
               res.setName(rs.getString(2));
               res.setDescription(rs.getString(3));
               res.setSpeciesid(rs.getLong(4));
               res.setLevel(rs.getInt(5));
               res.setDamage(rs.getInt(6));
               res.setDefense(rs.getInt(7));
            return res;
        }
        }catch (SQLException ex) {
            Logger.getLogger(SspJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   
    }
    
    @Override
    public SpeciesSpecialProperty getByName(String pSspName){
        try{
            PreparedStatement ps =con.prepareStatement("SELECT id,name,description,speciesid,level,damage,defense FROM speciesspecialproperty WHERE name=?");
            ps.setString(1,pSspName);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
               SpeciesSpecialProperty res=new SpeciesSpecialProperty();
               res.setId(rs.getLong(1));
               res.setName(rs.getString(2));
               res.setDescription(rs.getString(3));
               res.setSpeciesid(rs.getLong(4));
               res.setLevel(rs.getInt(5));
               res.setDamage(rs.getInt(6));
               res.setDefense(rs.getInt(7));
            return res;
        }
        }catch (SQLException ex) {
            Logger.getLogger(SspJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   
    }
    
    
    @Override
    public SpeciesSpecialProperty delete (long specialPropertyId) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM speciesspecialproperty WHERE id=?", Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, specialPropertyId);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SspJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

/*
        @Override
    public PropertyLevelAttribute modify(long pSspId) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE speciesspecialproperty set name,description,speciesid,level,damage,defense WHERE id=?");
            ps.setLong(1, pSspId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                PropertyLevelAttribute res = new PropertyLevelAttribute();
                res.setName(rs.getString(1));
                res.setDescription(rs.getString(2));
                res.setSpeciesid(rs.getLong(3));
                res.setLevel(rs.getInt(4));
                res.setDamage(rs.getInt(5));
                res.setDefense(rs.getInt(6));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SspJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    */
    
    @Override
    public List<SpeciesSpecialProperty> getBySpecies(long pSpeciesId){
        List<SpeciesSpecialProperty> result = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id,name,description,speciesid,level,damage,defense FROM speciesspecialproperty WHERE speciesid=?");
            ps.setLong(1, pSpeciesId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SpeciesSpecialProperty res = new SpeciesSpecialProperty();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setSpeciesid(rs.getLong(4));
                res.setLevel(rs.getInt(5));
                res.setDamage(rs.getInt(6));
                res.setDefense(rs.getInt(7));
                result.add(res);
               }
        } catch (SQLException ex) {
            Logger.getLogger(SspJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<SpeciesSpecialProperty> getSpeciesSpecialPropertyList(){
        List<SpeciesSpecialProperty> result = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM speciesspecialproperty");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SpeciesSpecialProperty res = new SpeciesSpecialProperty();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setSpeciesid(rs.getLong(4));
                res.setLevel(rs.getInt(5));
                res.setDamage(rs.getInt(6));
                res.setDefense(rs.getInt(7));
                result.add(res);
               }
        } catch (SQLException ex) {
            Logger.getLogger(SspJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}