package hu.javanetacademy.hoe.armor.dao.file;

import java.sql.Connection;
import java.sql.DriverManager;

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

}
