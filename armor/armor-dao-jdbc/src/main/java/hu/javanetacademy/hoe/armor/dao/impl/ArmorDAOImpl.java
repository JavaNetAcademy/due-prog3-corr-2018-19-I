package hu.javanetacademy.hoe.armor.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import hu.javanetacademy.hoe.armor.dao.ArmorDAO;
import hu.javanetacademy.hoe.armor.dao.ArmorDAOConstants;
import hu.javanetacademy.hoe.armor.dao.entity.Armor;
import hu.javanetacademy.hoe.armor.dao.exception.ArmorDAOException;

/**
 *
 * @author Gonda Gergely
 *
 */
public class ArmorDAOImpl implements ArmorDAO {

	private static final Logger LOG = Logger.getLogger(ArmorDAOImpl.class.getName());

	private Connection con;

	public ArmorDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
		} catch (Exception e) {
			ArmorDAOImpl.LOG.log(Level.SEVERE, "Failed connection to the database!", e);
			throw new ArmorDAOException("Failed connection to the database!", e);
		}
	}

	@Override
	public void create(Armor armor) {
		if (armor == null) {
			throw new ArmorDAOException("Given parameter can not be null: armor");
		}

		ArmorDAOImpl.LOG.log(Level.INFO, "Called create() whit params: " + armor.toString());
		try {
			StringBuilder sb = new StringBuilder("");
			sb.append("INSERT INTO ").append(ArmorDAOConstants.TABLE_NAME_ARMOR).append(" (")
					.append(ArmorDAOConstants.COLUMN_NAME_NAME).append(',')
					.append(ArmorDAOConstants.COLUMN_NAME_DESCRIPTION).append(',')
					.append(ArmorDAOConstants.COLUMN_NAME_PRICE).append(") VALUES(?,?,?)");

			PreparedStatement ps = con.prepareStatement(sb.toString());
			ps.setString(1, armor.getName());
			ps.setString(2, armor.getDescription());
			ps.setLong(3, armor.getPrice());
			ps.executeUpdate();
		} catch (Exception e) {
			ArmorDAOImpl.LOG.log(Level.SEVERE, "Error occurred while creating armor!", e);
			throw new ArmorDAOException("Error occurred while creating armor!", e);
		}
	}

	@Override
	public List<Armor> getAll() {
		ArmorDAOImpl.LOG.log(Level.INFO, "Called getAll() whit no params.");
		List<Armor> result = new ArrayList<>();
		try {
			StringBuilder sb = new StringBuilder("");
			sb.append("SELECT * FROM ").append(ArmorDAOConstants.TABLE_NAME_ARMOR).append(" ORDER BY ")
					.append(ArmorDAOConstants.COLUMN_NAME_ID).append(" DESC");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sb.toString());
			while (rs.next()) {
				Armor armor = new Armor();
				armor.setId(rs.getLong(ArmorDAOConstants.COLUMN_NAME_ID));
				armor.setName(rs.getString(ArmorDAOConstants.COLUMN_NAME_NAME));
				armor.setDescription(rs.getString(ArmorDAOConstants.COLUMN_NAME_DESCRIPTION));
				armor.setPrice(rs.getLong(ArmorDAOConstants.COLUMN_NAME_PRICE));
				result.add(armor);
			}
		} catch (Exception e) {
			ArmorDAOImpl.LOG.log(Level.SEVERE, "Error occurred while get all armor!", e);
			throw new ArmorDAOException("Error occurred while get all armor!", e);
		}
		return result;
	}

	@Override
	public Armor getById(Long id) {
		Armor armor = null;
		try {
			StringBuilder sb = new StringBuilder("");
			sb.append("SELECT * FROM ").append(ArmorDAOConstants.TABLE_NAME_ARMOR).append(" WHERE ")
					.append(ArmorDAOConstants.COLUMN_NAME_ID).append(" = ?");

			PreparedStatement ps = con.prepareStatement(sb.toString());
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				armor = new Armor();
				armor.setId(rs.getLong(ArmorDAOConstants.COLUMN_NAME_ID));
				armor.setName(rs.getString(ArmorDAOConstants.COLUMN_NAME_NAME));
				armor.setDescription(rs.getString(ArmorDAOConstants.COLUMN_NAME_DESCRIPTION));
				armor.setPrice(rs.getLong(ArmorDAOConstants.COLUMN_NAME_PRICE));
			}
		} catch (Exception e) {
			ArmorDAOImpl.LOG.log(Level.SEVERE, "Error occurred while get armor by id!", e);
			throw new ArmorDAOException("Error occurred while get armor by id!", e);
		}
		return armor;
	}

	@Override
	public void update(Armor armor) {
		try {
			StringBuilder sb = new StringBuilder("");
			sb.append("UPDATE ").append(ArmorDAOConstants.TABLE_NAME_ARMOR).append(" SET ")
					.append(ArmorDAOConstants.COLUMN_NAME_NAME).append(" = ?,")
					.append(ArmorDAOConstants.COLUMN_NAME_DESCRIPTION).append(" = ?,")
					.append(ArmorDAOConstants.COLUMN_NAME_PRICE).append(" = ? WHERE ")
					.append(ArmorDAOConstants.COLUMN_NAME_ID).append(" = ?");

			PreparedStatement ps = con.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, armor.getName());
			ps.setString(2, armor.getDescription());
			ps.setLong(3, armor.getPrice());
			ps.setLong(4, armor.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			ArmorDAOImpl.LOG.log(Level.SEVERE, "Error occurred while updating armor!", e);
			throw new ArmorDAOException("Error occurred while updating admor!", e);
		}
	}

	@Override
	public void delete(Long id) {
		try {
			StringBuilder sb = new StringBuilder("");
			sb.append("DELETE FROM ").append(ArmorDAOConstants.TABLE_NAME_ARMOR).append(" WHERE ")
					.append(ArmorDAOConstants.COLUMN_NAME_ID).append(" = ?");

			PreparedStatement ps = con.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			ArmorDAOImpl.LOG.log(Level.SEVERE, "Error occurred while deleting armor!", e);
			throw new ArmorDAOException("Error occurred while deleting admor!", e);
		}
	}

}
