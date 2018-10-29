package hu.javanetacademy.hoe.settlements.dao.jdbc;

import hu.javanetacademy.hoe.settlements.dao.model.Settlements;
import hu.javanetacademy.hoe.settlements.dao.model.SettlementsDaoInterface;
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
 *
 * @author Prototype_ (Szabó Zoltán)
 */
public class SettlementsDaoJDBCImpl implements SettlementsDaoInterface{
    
    private Connection con;

    public SettlementsDaoJDBCImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        } catch (Exception e) {
            System.exit(100);
        }
    }
    
    @Override
    public Settlements create(Settlements pSettlements) {
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO settlements(name,description,empireid) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pSettlements.getName());
            ps.setString(2, pSettlements.getDescription());
            ps.setLong(3, pSettlements.getEmpireid());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pSettlements.setId(rs.getLong(1));
                return pSettlements;

            }
        } catch (SQLException ex) {
            Logger.getLogger(SettlementsDaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Settlements modify(long psettlementsid, Settlements pSettlements) {
        try{
            PreparedStatement ps = con.prepareStatement("UPDATE settlements SET name=?,description=?,empireid=? WHERE id=?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pSettlements.getName());
            ps.setString(2, pSettlements.getDescription());
            ps.setLong(3, pSettlements.getEmpireid());
            ps.setLong(4, psettlementsid);
            ps.executeUpdate();
            return pSettlements;
        } catch (SQLException ex) {
            Logger.getLogger(SettlementsDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Settlements delete(long psettlementsid) {
        try{
            PreparedStatement ps = con.prepareStatement("DELETE FROM settlements WHERE id=?", Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, psettlementsid);
            ps.executeUpdate();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(SettlementsDaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Settlements get(long psettlementsid) {
        try{
            PreparedStatement ps = con.prepareStatement("SELECT id,name,description,empireid FROM settlements WHERE id=?");
            ps.setLong(1, psettlementsid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Settlements res = new Settlements();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setEmpireid(rs.getLong(4));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SettlementsDaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Settlements> getByEmpire(long pempiresId) {
        List<Settlements> resAll = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT id,name,description,empireid FROM settlements WHERE empireid=? ORDER BY name");
            ps.setLong(1, pempiresId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Settlements res = new Settlements();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setEmpireid(rs.getLong(4));
                resAll.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SettlementsDaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resAll;
    }

    @Override
    public boolean existsByName(String pSettlementsName, long pempiresId) {
        try{
            PreparedStatement ps = con.prepareStatement("SELECT name=? FROM settlements WHERE name=? AND empireid=?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pSettlementsName);
            ps.setString(2, pSettlementsName);
            ps.setLong(3, pempiresId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SettlementsDaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
