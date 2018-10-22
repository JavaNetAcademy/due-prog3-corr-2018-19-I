package hu.javanetacademy.hoe.armor.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import hu.javanetacademy.hoe.armor.dao.ArmorHeroXrefDAO;
import hu.javanetacademy.hoe.armor.dao.entity.ArmorHeroXref;

public class ArmorHeroXrefDAOImpl implements ArmorHeroXrefDAO {

	private Connection con;

	public ArmorHeroXrefDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
		} catch (Exception e) {
			// System.exit(100);
			e.printStackTrace();
		}
	}

	@Override
	public void create(ArmorHeroXref armorHeroXref) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ArmorHeroXref> getAllByHeroId(Long heroId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllByHeroId(Long heroId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Long id) {
		// TODO Auto-generated method stub

	}

}
