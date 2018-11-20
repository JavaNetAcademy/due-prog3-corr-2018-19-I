package hu.javanetacademy.hoe.factories.dao.jdbc;

import hu.javanetacademy.hoe.factories.dao.model.Factories;
import hu.javanetacademy.hoe.factories.dao.model.FactoriesDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
