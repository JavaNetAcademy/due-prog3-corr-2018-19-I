package hu.javanetacademy.hoe.culturalbuilding.dao.file;

import hu.javanetacademy.hoe.culturalbuilding.dao.model.CulturalBuilding;
import hu.javanetacademy.hoe.culturalbuilding.dao.model.CulturalBuildingDAO;

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
 * @author Soos Gabor
 *
 */
public class CulturalBuildingDAOImpl implements CulturalBuildingDAO {

	private static final String SELECT_SQL = "SELECT id,name,description FROM culturalbuilding WHERE id=?";
	private static final String SELECT2_SQL = "SELECT id,name,description FROM culturalbuilding WHERE name=?";
	private static final String SELECT_ALL_SQL = "SELECT id,name,description FROM culturalbuilding";
	private static final String INSERT_SQL = "INSERT INTO culturalbuilding(name,description) VALUES(?,?)";
	private static final String UPDATE_SQL = "UPDATE culturalbuilding SET name=?,description=? WHERE id=?";
	private static final String DELETE_SQL = "DELETE FROM culturalbuilding WHERE id=?";
	private Connection con;
	private Logger logger;


	public CulturalBuildingDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
			logger = Logger.getLogger(CulturalBuildingDAOImpl.class.getName());
		} catch (Exception e) {
			System.exit(100);
		}
	}

	@Override
	public CulturalBuilding create(CulturalBuilding culturalBuilding) {
		try {
            PreparedStatement ps =con.prepareStatement(INSERT_SQL,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, culturalBuilding.getName());
            ps.setString(2, culturalBuilding.getDescription());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
            	culturalBuilding.setId(rs.getLong(1));
                return culturalBuilding;
            }
        } catch (SQLException ex) {
			logger.log(Level.SEVERE, null, ex);
        }
		return null;
	}

	

	@Override
	public List<CulturalBuilding> getAll() {
		List<CulturalBuilding> resultList=new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	CulturalBuilding culturalBuilding = new CulturalBuilding();
            	culturalBuilding.setId(rs.getLong(1));
            	culturalBuilding.setName(rs.getString(2));
            	culturalBuilding.setDescription(rs.getString(3));
            	resultList.add(culturalBuilding);
            }
            return resultList;
        } catch (SQLException e) {e.printStackTrace();}
        return null;
	}

	@Override
	public CulturalBuilding getById(Long id) {
        try {
            PreparedStatement ps = con.prepareStatement(SELECT_SQL);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	CulturalBuilding culturalBuilding = new CulturalBuilding();
            	culturalBuilding.setId(rs.getLong(1));
            	culturalBuilding.setName(rs.getString(2));
            	culturalBuilding.setDescription(rs.getString(3));
                return culturalBuilding;
            }
        } catch (SQLException e) {e.printStackTrace();}
        return null;
	}

	@Override
	public CulturalBuilding update(CulturalBuilding culturalBuilding) {
        try {
            PreparedStatement ps = con.prepareStatement(UPDATE_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, culturalBuilding.getName());
            ps.setString(2, culturalBuilding.getDescription());
            ps.setLong(3, culturalBuilding.getId());
            ps.executeUpdate();
            return culturalBuilding;
        } catch (SQLException ex) {
        	logger.log(Level.SEVERE, null, ex);
        }
        return null;
	}
	
	@Override
	public void delete(long cBuildingId) {
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_SQL);
            ps.setLong(1, cBuildingId);
            ps.executeUpdate();
        } catch (SQLException ex) {
        	logger.log(Level.SEVERE, null, ex);
        }
	}

	@Override
	public boolean existsByName(String cBuildingName) {
        try {
            PreparedStatement ps = con.prepareStatement(SELECT2_SQL);
            ps.setString(1, cBuildingName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
        	logger.log(Level.SEVERE, null, ex);
        }
		return false;
	}
}
