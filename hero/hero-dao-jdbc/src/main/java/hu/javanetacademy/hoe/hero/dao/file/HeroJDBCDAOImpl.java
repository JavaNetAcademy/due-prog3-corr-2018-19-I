package hu.javanetacademy.hoe.hero.dao.file;

import hu.javanetacademy.hoe.hero.dao.model.Hero;
import hu.javanetacademy.hoe.hero.dao.model.HeroDAOInterface;
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
 * @author krisztian
 */
public class HeroJDBCDAOImpl implements HeroDAOInterface{

    private  Connection con;

    public HeroJDBCDAOImpl() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        }
        catch(Exception e){
            System.exit(100);
        }
    }
    
    
    
    @Override
    public Hero create(Hero pHero) {        
        try {
            PreparedStatement ps =con.prepareStatement("INSERT INTO hero(name,description,userid) VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pHero.getName());
            ps.setString(2, pHero.getDescription());
            ps.setLong(3, pHero.getUserid());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                pHero.setId(rs.getLong(1));
                return pHero;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HeroJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;        
    }

    @Override
    public Hero modify(long pOldHeroId, Hero pNewHero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Hero delete(long pHeroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Hero get(long pHeroId) {
        try{
            PreparedStatement ps =con.prepareStatement("SELECT id,name,description,userid FROM hero WHERE id=?");
            ps.setLong(1, pHeroId);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                Hero res = new Hero();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setUserid(rs.getLong(4));
                return res;
            }
        }catch (SQLException ex) {
            Logger.getLogger(HeroJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   
    }           

    @Override
    public List<Hero> getByUser(long pUserId){ 
        List<Hero> resAll = new ArrayList<>();
        try{
            PreparedStatement ps =con.prepareStatement("SELECT id,name,description,userid FROM hero WHERE userid=? ORDER BY name");
            ps.setLong(1, pUserId);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Hero res = new Hero();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setUserid(rs.getLong(4));
                resAll.add(res);
            }
        }
        catch (SQLException ex) {}
        return resAll;
    }

    @Override
    public Hero getByNameFromUser(String pHeroName, long pUserId) {
    try{
            PreparedStatement ps =con.prepareStatement("SELECT id,name,description,userid FROM hero WHERE name=? AND userid=?");
            ps.setString(1, pHeroName);
            ps.setLong(2, pUserId);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                Hero res = new Hero();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setUserid(rs.getLong(4));
                return res;
            }
        }catch (SQLException ex) {
            Logger.getLogger(HeroJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
