/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.weapon.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.javanetacademy.hoe.weapons.dao.model.Weapon;
import hu.javanetacademy.hoe.weapons.dao.model.WeaponDAOInterface;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard
 */
public class WeaponDaoJDBCImpl implements WeaponDAOInterface {
    private Connection con;

    public WeaponDaoJDBCImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        } catch (Exception e) {
            System.exit(100);
        }
    }

    @Override
    public Weapon buy(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose																// Tools | Templates.
    }
    
    @Override
    public Weapon create(Weapon weapon) {        
        try {
            PreparedStatement ps =con.prepareStatement("INSERT INTO weapons(name,description,price,userid) VALUES(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, weapon.getName());
            ps.setString(2, weapon.getDescription());
            ps.setInt(3, weapon.getPrice());
            ps.setLong(4, weapon.getUserId());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                weapon.setId(rs.getLong(1));
                return weapon;
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeaponDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;        
    }
    
    @Override
    public Weapon update(long weaponId, Weapon weapon) {
        try {
            PreparedStatement ps =con.prepareStatement("UPDATE weapons SET name=?,description=?,price=? WHERE id=?",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, weapon.getName());
            ps.setString(2, weapon.getDescription());
            ps.setInt(3, weapon.getPrice());
            ps.setLong(4, weaponId);
            ps.executeUpdate();
            return weapon;
        } catch (SQLException ex) {
            Logger.getLogger(WeaponDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public Weapon delete(long weaponId) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM weapons WHERE id=?", Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, weaponId);
            ps.executeUpdate();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(WeaponDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public Weapon get(long weaponId) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id,name,description,price,userid FROM weapons WHERE id=?");
            ps.setLong(1, weaponId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Weapon res = new Weapon();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setPrice(rs.getInt(4));
                res.setUserId(rs.getLong(5));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeaponDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Weapon> getByUser(long pUserId) {
        List<Weapon> weapons = new ArrayList<>();
        try {
            PreparedStatement ps = con
                            .prepareStatement("SELECT id,name,description,price,userid FROM weapons WHERE userid=? ORDER BY name");
            ps.setLong(1, pUserId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Weapon res = new Weapon();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setPrice(rs.getInt(4));
                res.setUserId(rs.getLong(5));
                weapons.add(res);
            }
        } catch (SQLException e) {
        }

        return weapons;
    }
}
