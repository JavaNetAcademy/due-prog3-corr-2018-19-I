package hu.javanetacademy.hoe.empires.dao.jdbc;

import hu.javanetacademy.hoe.empires.dao.model.Empires;
import hu.javanetacademy.hoe.empires.dao.model.EmpiresDaoInterface;
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
 * @author Laptop
 */
public class EmpiresDaoJDBCImpl implements EmpiresDaoInterface {

    private Connection con;

    public EmpiresDaoJDBCImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        } catch (Exception e) {
            System.exit(100);
        }
    }

    @Override
    public Empires create(Empires pEmpires) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO empires(name,description,userid,level,property) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pEmpires.getName());
            ps.setString(2, pEmpires.getDescription());
            ps.setLong(3, pEmpires.getUserid());
            ps.setLong(4, pEmpires.getLevel());
            ps.setLong(5, pEmpires.getProperty());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pEmpires.setId(rs.getLong(1));
                return pEmpires;

            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpiresDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Empires modify(long pOldEmpiresId, Empires pNewEmpires) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE empires SET (name,description,userid,level,property) VALUES(?,?,?,?,?) where id=?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pNewEmpires.getName());
            ps.setString(2, pNewEmpires.getDescription());
            ps.setLong(3, pNewEmpires.getUserid());
            ps.setLong(4, pNewEmpires.getLevel());
            ps.setLong(5, pNewEmpires.getProperty());
            ps.executeUpdate();
            return pNewEmpires;
        } catch (SQLException ex) {
            Logger.getLogger(EmpiresDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Empires delete(long pEmpiresId) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM empires WHERE id=?", Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, pEmpiresId);
            ps.executeUpdate();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(EmpiresDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Empires get(long pEmpiresId) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id,name,description,userid,level,property FROM empires WHERE id=?");
            ps.setLong(1, pEmpiresId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Empires res = new Empires();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setUserid(rs.getLong(4));
                res.setLevel(rs.getLong(5));
                res.setProperty(rs.getLong(6));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpiresDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Empires> getByUser(long pUserId) {
        List<Empires> resAll = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id,name,description,userid,level,property FROM empires WHERE userid=? ORDER BY name");
            ps.setLong(1, pUserId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Empires res = new Empires();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setUserid(rs.getLong(4));
                res.setLevel(rs.getLong(5));
                res.setProperty(rs.getLong(6));
                resAll.add(res);
            }
        } catch (SQLException ex) {
        }
        return resAll;
    }

    @Override
    public boolean existsByName(String pEmpiresName, long pUserId) {
                     
        try {
            PreparedStatement ps = con.prepareStatement("SELECT name=? FROM empires WHERE name=? AND userid=?");
            ps.setString(1, pEmpiresName);
            ps.setString(2, pEmpiresName);
            ps.setLong(3, pUserId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpiresDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
