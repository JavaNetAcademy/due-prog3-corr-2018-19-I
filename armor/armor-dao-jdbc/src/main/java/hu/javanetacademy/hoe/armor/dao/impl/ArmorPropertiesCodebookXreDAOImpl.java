package hu.javanetacademy.hoe.armor.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import hu.javanetacademy.hoe.armor.dao.ArmorPropertiesCodebookXreDAO;
import hu.javanetacademy.hoe.armor.dao.entity.ArmorPropertiesCodebookXref;

public class ArmorPropertiesCodebookXreDAOImpl implements ArmorPropertiesCodebookXreDAO {

	private Connection con;

	public ArmorPropertiesCodebookXreDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
		} catch (Exception e) {
			// System.exit(100);
			e.printStackTrace();
		}
	}

	@Override
	public void create(ArmorPropertiesCodebookXref armorHeroXref) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ArmorPropertiesCodebookXref> getAllByArmorId(Long armorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllByArmorId(Long armorId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Long id) {
		// TODO Auto-generated method stub

	}

}
