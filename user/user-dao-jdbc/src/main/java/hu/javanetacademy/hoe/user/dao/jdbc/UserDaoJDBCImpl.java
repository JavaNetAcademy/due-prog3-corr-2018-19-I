package hu.javanetacademy.hoe.user.dao.jdbc;

import hu.javanetacademy.hoe.user.dao.model.User;
import hu.javanetacademy.hoe.user.dao.model.UserDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author krisztian
 */
public class UserDaoJDBCImpl implements UserDao {

    private Connection con;

    public UserDaoJDBCImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        } catch (Exception e) {
            System.exit(100);
        }
    }

    @Override
    public User login(String pName, String pPassword) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id,name,password FROM user WHERE name=? AND password =?");
            ps.setString(1, pName);
            ps.setString(2, pPassword);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getLong(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                return user;
            }
        } catch (SQLException e) {e.printStackTrace();}
        return null;
    }

    @Override
    public User registration(String pName, String pPassword) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO user(name,password,role) VALUES(?,?,'user')", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pName);
            ps.setString(2, pPassword);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getLong(1));
                user.setName(pName);
                user.setPassword(pPassword);
                return user;
            }
        } catch (SQLException e) {e.printStackTrace();}
        return null;
    }

    @Override
    public User getbyName(String pName) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id,name,password FROM user WHERE name=?");
            ps.setString(1, pName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getLong(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                return user;
            }
        } catch (SQLException e) {e.printStackTrace();}
        return null;
    }

}
