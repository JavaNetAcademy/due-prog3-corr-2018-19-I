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

import hu.javanetacademy.hoe.armor.dao.ArmorDAOConstants;
import hu.javanetacademy.hoe.armor.dao.ArmorHeroXrefDAO;
import hu.javanetacademy.hoe.armor.dao.entity.ArmorHeroXref;
import hu.javanetacademy.hoe.armor.dao.exception.ArmorDAOException;
import hu.javanetacademy.hoe.armor.dao.exception.ArmorHeroXrefDAOException;

public class ArmorHeroXrefDAOImpl implements ArmorHeroXrefDAO {

	private static final Logger LOG = Logger.getLogger(ArmorHeroXrefDAOImpl.class.getName());

	private Connection con;

	public ArmorHeroXrefDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
		} catch (Exception e) {
			ArmorHeroXrefDAOImpl.LOG.log(Level.SEVERE, "Failed connection to the database!", e);
			throw new ArmorHeroXrefDAOException("Failed connection to the database!", e);
		}
	}

	@Override
	public void create(ArmorHeroXref armorHeroXref) {
		if (armorHeroXref == null) {
			throw new ArmorDAOException("Given parameter can not be null: armorHeroXref");
		}

		ArmorHeroXrefDAOImpl.LOG.log(Level.INFO, "Called create() whit params: " + armorHeroXref.toString());
		try {
			StringBuilder sb = new StringBuilder("");
			sb.append("INSERT INTO ").append(ArmorDAOConstants.TABLE_NAME_ARMOR_HERO_XREF).append(" (")
					.append(ArmorDAOConstants.COLUMN_NAME_ARMOR_ID).append(',')
					.append(ArmorDAOConstants.COLUMN_NAME_HERO_ID).append(") VALUES(?,?)");

			PreparedStatement ps = con.prepareStatement(sb.toString());
			ps.setLong(1, armorHeroXref.getArmorId());
			ps.setLong(2, armorHeroXref.getHeroId());
			ps.executeUpdate();
		} catch (Exception e) {
			ArmorHeroXrefDAOImpl.LOG.log(Level.SEVERE, "Error occurred while creating armorHeroXref!", e);
			throw new ArmorDAOException("Error occurred while creating armorHeroXref!", e);
		}
	}

	@Override
	public List<ArmorHeroXref> getAllByHeroId(Long heroId) {
		ArmorHeroXrefDAOImpl.LOG.log(Level.INFO, "Called getAllByHeroId() whit params: " + heroId);
		List<ArmorHeroXref> result = new ArrayList<>();
		try {
			StringBuilder sb = new StringBuilder("");
			sb.append("SELECT * FROM ").append(ArmorDAOConstants.TABLE_NAME_ARMOR_HERO_XREF).append(" WHERE ")
					.append(ArmorDAOConstants.COLUMN_NAME_HERO_ID).append(" = ?").append(" ORDER BY ")
					.append(ArmorDAOConstants.COLUMN_NAME_ID).append(" DESC");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sb.toString());
			while (rs.next()) {
				ArmorHeroXref armorHeroXref = new ArmorHeroXref();
				armorHeroXref.setId(rs.getLong(ArmorDAOConstants.COLUMN_NAME_ID));
				armorHeroXref.setArmorId(rs.getLong(ArmorDAOConstants.COLUMN_NAME_ARMOR_ID));
				armorHeroXref.setHeroId(rs.getLong(ArmorDAOConstants.COLUMN_NAME_HERO_ID));
				result.add(armorHeroXref);
			}
		} catch (Exception e) {
			ArmorHeroXrefDAOImpl.LOG.log(Level.SEVERE, "Error occurred while get all armorHeroXref!", e);
			throw new ArmorDAOException("Error occurred while get all armorHeroXref!", e);
		}
		return result;
	}

	@Override
	public void deleteAllByHeroId(Long heroId) {
		try {
			StringBuilder sb = new StringBuilder("");
			sb.append("DELETE FROM ").append(ArmorDAOConstants.TABLE_NAME_ARMOR_HERO_XREF).append(" WHERE ")
					.append(ArmorDAOConstants.COLUMN_NAME_HERO_ID).append(" = ?");

			PreparedStatement ps = con.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, heroId);
			ps.executeUpdate();
		} catch (Exception e) {
			ArmorHeroXrefDAOImpl.LOG.log(Level.SEVERE, "Error occurred while deleting armorHeroXref!", e);
			throw new ArmorDAOException("Error occurred while deleting armorHeroXref!", e);
		}
	}

	@Override
	public void deleteAllByArmorId(Long armorId) {
		try {
			StringBuilder sb = new StringBuilder("");
			sb.append("DELETE FROM ").append(ArmorDAOConstants.TABLE_NAME_ARMOR_HERO_XREF).append(" WHERE ")
					.append(ArmorDAOConstants.COLUMN_NAME_ARMOR_ID).append(" = ?");

			PreparedStatement ps = con.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, armorId);
			ps.executeUpdate();
		} catch (Exception e) {
			ArmorHeroXrefDAOImpl.LOG.log(Level.SEVERE, "Error occurred while deleting armorHeroXref!", e);
			throw new ArmorDAOException("Error occurred while deleting armorHeroXref!", e);
		}
	}

	@Override
	public void delete(Long id) {
		try {
			StringBuilder sb = new StringBuilder("");
			sb.append("DELETE FROM ").append(ArmorDAOConstants.TABLE_NAME_ARMOR_HERO_XREF).append(" WHERE ")
					.append(ArmorDAOConstants.COLUMN_NAME_ID).append(" = ?");

			PreparedStatement ps = con.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			ArmorHeroXrefDAOImpl.LOG.log(Level.SEVERE, "Error occurred while deleting armorHeroXref!", e);
			throw new ArmorDAOException("Error occurred while deleting armorHeroXref!", e);
		}
	}

}
