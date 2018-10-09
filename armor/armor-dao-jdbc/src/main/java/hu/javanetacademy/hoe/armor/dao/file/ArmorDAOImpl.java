package hu.javanetacademy.hoe.armor.dao.file;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import hu.javanetacademy.hoe.armor.dao.model.Armor;
import hu.javanetacademy.hoe.armor.dao.model.ArmorDAO;

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
			System.exit(100);
		}
	}

	@Override
	public void create(Armor armor) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Armor> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Armor getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Armor armor) {
		// TODO Auto-generated method stub

	}

}
