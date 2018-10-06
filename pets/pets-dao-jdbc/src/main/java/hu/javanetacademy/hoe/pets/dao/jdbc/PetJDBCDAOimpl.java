package hu.javanetacademy.hoe.pets.dao.jdbc;

import hu.javanetacademy.hoe.pets.dao.model.Pet;
import hu.javanetacademy.hoe.pets.dao.model.PetDAOInterface;
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
 * @author Heyzel (Horvath Gergely)
 */
public class PetJDBCDAOimpl implements PetDAOInterface {

    private Connection con;

    public PetJDBCDAOimpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        } catch (Exception e) {
            System.exit(100);
        }
    }

    @Override
    public Pet create(Pet pPet) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO pet (name,description,heroid) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pPet.getName());
            ps.setString(2, pPet.getDescription());
            ps.setLong(3, pPet.getHeroid());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pPet.setId(rs.getLong(1));
                return pPet;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PetJDBCDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Pet modify(long pOldPetId, Pet pNewPet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pet delete(long pPetId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pet get(long pPetId) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id,name,description,heroid FROM pet WHERE id=?");
            ps.setLong(1, pPetId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Pet res = new Pet();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setHeroid(rs.getLong(4));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PetJDBCDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Pet> getForHero(long pHeroId) {
        List<Pet> resAll = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id,name,description,heroid FROM pet WHERE heroid=? ORDER BY name");
            ps.setLong(1, pHeroId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pet res = new Pet();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setHeroid(rs.getLong(4));
                resAll.add(res);
            }
        } catch (SQLException ex) {
        }
        return resAll;
    }
    
//    @Override
//    public Pet getByNameFromUser(String pPetName, long pHeroId) {
//        try {
//            PreparedStatement ps = con.prepareStatement("SELECT id,name,description,heroid FROM hero WHERE name=? AND heroid=?");
//            ps.setString(1, pPetName);
//            ps.setLong(2, pHeroId);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                Pet res = new Pet();
//                res.setId(rs.getLong(1));
//                res.setName(rs.getString(2));
//                res.setDescription(rs.getString(3));
//                res.setUserid(rs.getLong(4));
//                return res;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(PetJDBCDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
}
