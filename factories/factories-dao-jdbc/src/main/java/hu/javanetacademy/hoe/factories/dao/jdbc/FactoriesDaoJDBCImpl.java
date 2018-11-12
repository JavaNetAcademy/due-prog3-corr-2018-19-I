package hu.javanetacademy.hoe.factories.dao.jdbc;

import hu.javanetacademy.hoe.factories.dao.model.Factories;
import hu.javanetacademy.hoe.factories.dao.model.FactoriesDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Factories modify(long pOldFactoryId, Factories pNewFactory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Factories delete(long pFactoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Factories get(long pFactoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Factories> getByEmpire(long pEmpireId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existsByName(String pFactoryName, long pEmpireId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
