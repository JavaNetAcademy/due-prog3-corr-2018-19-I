package hu.javanetacademy.hoe.factories.dao.jdbc;

import hu.javanetacademy.hoe.factories.dao.model.Factories;
import hu.javanetacademy.hoe.factories.dao.model.FactoriesDao;
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
 * @author jrajmund
 */
public class FactoriesDaoJDBCImpl implements FactoriesDao {

    private Connection con;

    public FactoriesDaoJDBCImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        } catch (Exception ex) {
//            Logger.getLogger(FactoriesDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);                      
            System.exit(100);
        }
    }

    @Override
    public Factories create(Factories pFactory) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO factories (name, description, userid, empireid) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pFactory.getName());
            ps.setString(2, pFactory.getDescription());
            ps.setLong(3, pFactory.getUserid());
            ps.setLong(4, pFactory.getEmpireid());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pFactory.setId(rs.getLong(1));
                return pFactory;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FactoriesDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean existsById(Factories pFactory) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id, empireid FROM factories WHERE id=? AND empireid=?");
            ps.setLong(1, pFactory.getId());
            ps.setLong(2, pFactory.getEmpireid());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FactoriesDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Factories> getByUser(long pUserId) {
        List<Factories> lf = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id, name, description, userid, empireid FROM factories WHERE userid=? ORDER BY id");
            ps.setLong(1, pUserId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Factories factories = new Factories();
                factories.setId(rs.getLong(1));
                factories.setName(rs.getString(2));
                factories.setDescription(rs.getString(3));
                factories.setUserid(rs.getLong(4));
                factories.setEmpireid(rs.getLong(5));
                lf.add(factories);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FactoriesDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lf;
    }

    @Override
    public Factories delete(long pFactoryId) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM factories WHERE id=?");
            ps.setLong(1, pFactoryId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FactoriesDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Factories modify(long pOldFactoryId, Factories pNewFactory) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE factories SET name=?, description=? WHERE id=?");
            ps.setString(1, pNewFactory.getName());
            ps.setString(2, pNewFactory.getDescription());
            ps.setLong(3, pOldFactoryId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FactoriesDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean existsByNameDescId(Factories pFactory) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id, name, description FROM factories WHERE id=? AND name=? AND description=?");
            ps.setLong(1, pFactory.getId());
            ps.setString(2, pFactory.getName());
            ps.setString(3, pFactory.getDescription());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FactoriesDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Factories get(long pFactoryId) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id, name, description, userid, empireid FROM factories WHERE id=?");
            ps.setLong(1, pFactoryId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Factories factory = new Factories();
                factory.setId(rs.getLong(1));
                factory.setName(rs.getString(2));
                factory.setDescription(rs.getString(3));
                factory.setUserid(rs.getLong(4));
                factory.setEmpireid(rs.getLong(5));
                return factory;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FactoriesDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
