package hu.javanetacademy.hoe.ssp.dao.jdbc;

import hu.javanetacademy.hoe.ssp.dao.model.Ssp;
import hu.javanetacademy.hoe.ssp.dao.model.SspDAOInterface;
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
 *
 * @author user
 */
public class SspJDBCDAOImpl implements SspDAOInterface {

    // Kapcsolat létrehozása az adatbázissal
    private Connection con;

    public SspJDBCDAOImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql.autodl.de/hoe?useSSL=false", "hoe", "hoe");
        } catch (Exception e) {
            System.exit(100);
        }
    }

    @Override
    public Ssp create(Ssp pSsp) {
           try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO ssp (name,description,speciesid,level,damage,defense) VALUES(?,?,?,1,1,1)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pSsp.getName());
            ps.setString(2, pSsp.getDescription());
            ps.setLong(3, pSsp.getSpeciesid());
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
    public Ssp get(long pSspId) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id,name,description,speciesid,level,damage,defense FROM ssp WHERE id=?");
            ps.setLong(1, pSspId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Ssp res = new Ssp();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setSpeciesid(rs.getLong(4));
                res.setLevel(rs.getInt(5));
                res.setDamage(rs.getInt(6));
                res.setDefense(rs.getInt(7));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SspJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Ssp delete(long pSspId) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM ssp WHERE id=?", Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, pSspId);
            ps.executeUpdate();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(SspJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Ssp modify(long pOldSspId, Ssp pNewSsp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ssp> getForSpecies(long pSpeciesId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existByName(String pSspName, long pSpeciesId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
