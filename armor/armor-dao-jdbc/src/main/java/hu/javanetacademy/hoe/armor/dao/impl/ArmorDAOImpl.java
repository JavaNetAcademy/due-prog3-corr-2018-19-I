package hu.javanetacademy.hoe.armor.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.javanetacademy.hoe.armor.dao.ArmorDAO;
import hu.javanetacademy.hoe.armor.dao.ArmorDAOConstants;
import hu.javanetacademy.hoe.armor.dao.entity.Armor;

/**
 *
 * @author Gonda Gergely
 *
 */
public class ArmorDAOImpl implements ArmorDAO {

	private Connection con;

	public ArmorDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
		} catch (Exception e) {
			// TODO ideiglenes
			// System.exit(100);
			e.printStackTrace();
		}
	}

	@Override
	public void create(Armor armor) {
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
		} catch (SQLException ex) {
			// TODO ideiglenes
			ex.printStackTrace();
		}
	}

	@Override
	public List<Armor> getAll() {
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
		} catch (SQLException ex) {
			// TODO ideiglenes
			ex.printStackTrace();
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
		} catch (SQLException ex) {
			// TODO ideiglenes
			ex.printStackTrace();
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
		} catch (SQLException ex) {
			// TODO ideiglenes
			ex.printStackTrace();
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
		} catch (SQLException ex) {
			// TODO ideiglenes
			ex.printStackTrace();
		}
	}

}
