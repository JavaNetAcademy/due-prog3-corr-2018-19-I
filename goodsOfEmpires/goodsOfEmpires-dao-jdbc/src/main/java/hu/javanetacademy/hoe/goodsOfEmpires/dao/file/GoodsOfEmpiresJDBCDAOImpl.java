package hu.javanetacademy.hoe.goodsOfEmpires.dao.file;

import hu.javanetacademy.hoe.goodsOfEmpires.dao.model.GoodsOfEmpires;
import hu.javanetacademy.hoe.goodsOfEmpires.dao.model.GoodsOfEmpiresDAOInterface;
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
public class GoodsOfEmpiresJDBCDAOImpl implements GoodsOfEmpiresDAOInterface{

    private  Connection con;

    public GoodsOfEmpiresJDBCDAOImpl() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe1234");
        }
        catch(Exception e){
            System.exit(100);
        }
    }
    
    
    
    @Override
    public GoodsOfEmpires create(GoodsOfEmpires pGoodsOfEmpires) {        
        try {
            PreparedStatement ps =con.prepareStatement("INSERT INTO goodsOfEmpires(name,description,userid) VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pGoodsOfEmpires.getName());
            ps.setString(2, pGoodsOfEmpires.getDescription());
            ps.setLong(3, pGoodsOfEmpires.getGoodid());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                pGoodsOfEmpires.setId(rs.getLong(1));
                return pGoodsOfEmpires;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GoodsOfEmpiresJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;        
    }

    @Override
    public GoodsOfEmpires modify(long pOldGoodsOfEmpiresId, GoodsOfEmpires pNewGoodsOfEmpires) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GoodsOfEmpires delete(long pGoodsOfEmpiresId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GoodsOfEmpires get(long pGoodsOfEmpiresId) {
        try{
            PreparedStatement ps =con.prepareStatement("SELECT id,name,description,userid FROM goodsOfEmpires WHERE id=?");
            ps.setLong(1, pGoodsOfEmpiresId);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                GoodsOfEmpires res = new GoodsOfEmpires();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setGoodid(rs.getLong(4));
                return res;
            }
        }catch (SQLException ex) {
            Logger.getLogger(GoodsOfEmpiresJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   
    }           

    @Override
    public List<GoodsOfEmpires> getByUser(long pUserId){ 
        List<GoodsOfEmpires> resAll = new ArrayList<>();
        try{
            PreparedStatement ps =con.prepareStatement("SELECT id,name,description,goodid FROM goodsOfEmpires WHERE goodid=? ORDER BY name");
            ps.setLong(1, pUserId);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                GoodsOfEmpires res = new GoodsOfEmpires();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setGoodid(rs.getLong(4));
                resAll.add(res);
            }
        }
        catch (SQLException ex) {}
        return resAll;
    }

    @Override
    public GoodsOfEmpires getByNameFromUser(String pGoodsOfEmpiresName, long pUserId) {
    try{
            PreparedStatement ps =con.prepareStatement("SELECT id,name,description,goodid FROM GoodsOfEmpires WHERE name=? AND userid=?");
            ps.setString(1, pGoodsOfEmpiresName);
            ps.setLong(2, pUserId);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                GoodsOfEmpires res = new GoodsOfEmpires();
                res.setId(rs.getLong(1));
                res.setName(rs.getString(2));
                res.setDescription(rs.getString(3));
                res.setGoodid(rs.getLong(4));
                return res;
            }
        }catch (SQLException ex) {
            Logger.getLogger(GoodsOfEmpiresJDBCDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
