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
import hu.javanetacademy.hoe.armor.dao.ArmorPropertiesCodebookXreDAO;
import hu.javanetacademy.hoe.armor.dao.entity.ArmorPropertiesCodebookXref;
import hu.javanetacademy.hoe.armor.dao.exception.ArmorDAOException;
import hu.javanetacademy.hoe.armor.dao.exception.ArmorPropertiesCodebookXreDAOException;

public class ArmorPropertiesCodebookXreDAOImpl implements ArmorPropertiesCodebookXreDAO {

	private static final Logger LOG = Logger.getLogger(ArmorPropertiesCodebookXreDAOImpl.class.getName());

	private Connection con;

	public ArmorPropertiesCodebookXreDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
		} catch (Exception e) {
			ArmorPropertiesCodebookXreDAOImpl.LOG.log(Level.SEVERE, "Failed connection to the database!", e);
			throw new ArmorPropertiesCodebookXreDAOException("Failed connection to the database!", e);
		}
	}

	@Override
	public void create(ArmorPropertiesCodebookXref armorPropertiesCodebookXref) {
		if (armorPropertiesCodebookXref == null) {
			throw new ArmorPropertiesCodebookXreDAOException("Given parameter can not be null: armorHeroXref");
		}

		ArmorPropertiesCodebookXreDAOImpl.LOG.log(Level.INFO,
				"Called create() whit params: " + armorPropertiesCodebookXref.toString());
		try {
			StringBuilder sb = new StringBuilder("");
			sb.append("INSERT INTO ").append(ArmorDAOConstants.TABLE_NAME_ARMOR_PROPERTIES_CODEBOOK_XREF).append(" (")
					.append(ArmorDAOConstants.COLUMN_NAME_ARMOR_ID).append(',')
					.append(ArmorDAOConstants.COLUMN_NAME_PROPERTIES_CODEBOOK_ID).append(") VALUES(?,?)");

			PreparedStatement ps = con.prepareStatement(sb.toString());
			ps.setLong(1, armorPropertiesCodebookXref.getArmorId());
			ps.setLong(2, armorPropertiesCodebookXref.getPropertiesCodebookId());
			ps.executeUpdate();
		} catch (Exception e) {
			ArmorPropertiesCodebookXreDAOImpl.LOG.log(Level.SEVERE,
					"Error occurred while creating armorPropertiesCodebookXref!", e);
			throw new ArmorPropertiesCodebookXreDAOException(
					"Error occurred while creating armorPropertiesCodebookXref!", e);
		}
	}

	@Override
	public List<ArmorPropertiesCodebookXref> getAllByArmorId(Long armorId) {
		ArmorPropertiesCodebookXreDAOImpl.LOG.log(Level.INFO, "Called getAllByArmorId() whit params: " + armorId);
		List<ArmorPropertiesCodebookXref> result = new ArrayList<>();
		try {
			StringBuilder sb = new StringBuilder("");
			sb.append("SELECT * FROM ").append(ArmorDAOConstants.TABLE_NAME_ARMOR_PROPERTIES_CODEBOOK_XREF)
					.append(" WHERE ").append(ArmorDAOConstants.COLUMN_NAME_ARMOR_ID).append(" = ?")
					.append(" ORDER BY ").append(ArmorDAOConstants.COLUMN_NAME_ID).append(" DESC");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sb.toString());
			while (rs.next()) {
				ArmorPropertiesCodebookXref armorPropertiesCodebookXref = new ArmorPropertiesCodebookXref();
				armorPropertiesCodebookXref.setId(rs.getLong(ArmorDAOConstants.COLUMN_NAME_ID));
				armorPropertiesCodebookXref.setArmorId(rs.getLong(ArmorDAOConstants.COLUMN_NAME_ARMOR_ID));
				armorPropertiesCodebookXref
						.setPropertiesCodebookId(rs.getLong(ArmorDAOConstants.COLUMN_NAME_PROPERTIES_CODEBOOK_ID));
				result.add(armorPropertiesCodebookXref);
			}
		} catch (Exception e) {
			ArmorPropertiesCodebookXreDAOImpl.LOG.log(Level.SEVERE,
					"Error occurred while get all armorPropertiesCodebookXref!", e);
			throw new ArmorDAOException("Error occurred while get all armorPropertiesCodebookXref!", e);
		}
		return result;
	}

	@Override
	public void deleteAllByArmorId(Long armorId) {
		try {
			StringBuilder sb = new StringBuilder("");
			sb.append("DELETE FROM ").append(ArmorDAOConstants.TABLE_NAME_ARMOR_PROPERTIES_CODEBOOK_XREF)
					.append(" WHERE ").append(ArmorDAOConstants.COLUMN_NAME_ARMOR_ID).append(" = ?");

			PreparedStatement ps = con.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, armorId);
			ps.executeUpdate();
		} catch (Exception e) {
			ArmorPropertiesCodebookXreDAOImpl.LOG.log(Level.SEVERE, "Error occurred while deleting armorHeroXref!", e);
			throw new ArmorDAOException("Error occurred while deleting armorHeroXref!", e);
		}
	}

	@Override
	public void deleteAllByPropertiesCodebookId(Long propertiesCodebookId) {
		try {
			StringBuilder sb = new StringBuilder("");
			sb.append("DELETE FROM ").append(ArmorDAOConstants.TABLE_NAME_ARMOR_PROPERTIES_CODEBOOK_XREF)
					.append(" WHERE ").append(ArmorDAOConstants.COLUMN_NAME_PROPERTIES_CODEBOOK_ID).append(" = ?");

			PreparedStatement ps = con.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, propertiesCodebookId);
			ps.executeUpdate();
		} catch (Exception e) {
			ArmorPropertiesCodebookXreDAOImpl.LOG.log(Level.SEVERE, "Error occurred while deleting armorHeroXref!", e);
			throw new ArmorDAOException("Error occurred while deleting armorHeroXref!", e);
		}
	}

	@Override
	public void delete(Long id) {
		try {
			StringBuilder sb = new StringBuilder("");
			sb.append("DELETE FROM ").append(ArmorDAOConstants.TABLE_NAME_ARMOR_PROPERTIES_CODEBOOK_XREF)
					.append(" WHERE ").append(ArmorDAOConstants.COLUMN_NAME_ID).append(" = ?");

			PreparedStatement ps = con.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			ArmorPropertiesCodebookXreDAOImpl.LOG.log(Level.SEVERE, "Error occurred while deleting armorHeroXref!", e);
			throw new ArmorDAOException("Error occurred while deleting armorHeroXref!", e);
		}
	}

}
