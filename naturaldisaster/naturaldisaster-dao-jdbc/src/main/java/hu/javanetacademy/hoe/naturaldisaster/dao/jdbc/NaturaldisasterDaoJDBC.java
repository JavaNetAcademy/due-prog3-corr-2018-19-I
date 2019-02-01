/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.naturaldisaster.dao.jdbc;

/**
 *
 * @author Barna
 */
import hu.javanetacademy.hoe.naturaldisaster.dao.model.NaturaldisasterDao;
import hu.javanetacademy.hoe.naturaldisaster.dao.model.Naturaldisaster;
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


public class NaturaldisasterDaoJDBC implements NaturaldisasterDao {
    private Connection con;
    
    public NaturaldisasterDaoJDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        } catch (Exception e) {
            System.exit(100);
        }
    }
    
    @Override
    public Naturaldisaster create(Naturaldisaster naturaldisaster) {
        try {
            PreparedStatement ps = con.prepareStatement(

                    "INSERT INTO naturaldisaster;(name, description, effect, deadlyto) "
                    + "VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, naturaldisaster.getName());
            ps.setString(2, naturaldisaster.getDescription());
            ps.setString(3, naturaldisaster.getEffect());
            ps.setString(4, naturaldisaster.getDeadlyto());            

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                naturaldisaster.setId(rs.getLong(1));
                return naturaldisaster;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NaturaldisasterDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     @Override
    public Naturaldisaster getByName(String name) {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT id, name, description, effect, deadlyto "
                    + "FROM naturaldisaster WHERE name=?");
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Naturaldisaster naturaldisaster = new Naturaldisaster();
                naturaldisaster.setId(rs.getLong(1));
                naturaldisaster.setName(rs.getString(2));
                naturaldisaster.setDescription(rs.getString(3));
                naturaldisaster.setEffect(rs.getString(4));
                naturaldisaster.setDeadlyto(rs.getString(5));
                return naturaldisaster;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NaturaldisasterDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public List<Naturaldisaster> getAll() {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT id, name, description, effect, deadlyto "
                    + "FROM naturaldisaster");

            ResultSet rs = ps.executeQuery();
            List<Naturaldisaster> res = new ArrayList<>();

            while (rs.next()) {
                Naturaldisaster naturaldisaster = new Naturaldisaster();
                naturaldisaster.setId(rs.getLong(1));
                naturaldisaster.setName(rs.getString(2));
                naturaldisaster.setDescription(rs.getString(3));
                naturaldisaster.setEffect(rs.getString(4));
                naturaldisaster.setDeadlyto(rs.getString(5));
                
                res.add(naturaldisaster);
            }
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(NaturaldisasterDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
