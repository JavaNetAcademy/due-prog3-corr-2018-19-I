package hu.javanetacademy.hoe.skills.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Kovacs Maria
 */
public class ConnectionUtil {

    private static final String USERNAME = "hoe";
    private static final String PASSWORD = "hoe";
    private static final String CONN_STRING = "jdbc:mysql://localhost/hoe?useSSL=false";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
    }
}

