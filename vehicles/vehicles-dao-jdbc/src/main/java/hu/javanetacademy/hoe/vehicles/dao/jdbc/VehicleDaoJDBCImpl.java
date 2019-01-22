/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.vehicles.dao.jdbc;

import hu.javanetacademy.hoe.vehicles.dao.model.Vehicle;
import hu.javanetacademy.hoe.vehicles.dao.model.VehicleDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jbasiszta
 */
public class VehicleDaoJDBCImpl implements VehicleDao {

    private Connection con;

    public VehicleDaoJDBCImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hoe?useSSL=false", "hoe", "hoe");
        } catch (Exception e) {
            System.exit(100);
        }
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        try {
            PreparedStatement ps = con.prepareStatement(

                    "INSERT INTO vehicle(name, description, avg_speed, max_speed, max_speed_timeout, max_load, crew, price) "
                    + "VALUES(?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, vehicle.getName());
            ps.setString(2, vehicle.getDescription());
            ps.setLong(3, vehicle.getAvgSpeed());
            ps.setLong(4, vehicle.getMaxSpeed());
            ps.setLong(5, vehicle.getMaxSpeedTimeout());
            ps.setLong(6, vehicle.getMaxLoad());
            ps.setLong(7, vehicle.getCrew());
            ps.setLong(8, vehicle.getPrice());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                vehicle.setId(rs.getLong(1));
                return vehicle;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Vehicle getByName(String name) {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT id, name, description, avg_speed, max_speed, max_speed_timeout, max_load, crew, price "
                    + "FROM vehicle WHERE name=?");
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getLong(1));
                vehicle.setName(rs.getString(2));
                vehicle.setDescription(rs.getString(3));
                vehicle.setAvgSpeed(rs.getLong(4));
                vehicle.setMaxSpeed(rs.getLong(5));
                vehicle.setMaxSpeedTimeout(rs.getLong(6));
                vehicle.setMaxLoad(rs.getLong(7));
                vehicle.setCrew(rs.getLong(8));
                vehicle.setPrice(rs.getLong(9));
                return vehicle;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Vehicle getById(long id) {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT id, name, description, avg_speed, max_speed, max_speed_timeout, max_load, crew, price "
                    + "FROM vehicle WHERE id=?");
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getLong(1));
                vehicle.setName(rs.getString(2));
                vehicle.setDescription(rs.getString(3));
                vehicle.setAvgSpeed(rs.getLong(4));
                vehicle.setMaxSpeed(rs.getLong(5));
                vehicle.setMaxSpeedTimeout(rs.getLong(6));
                vehicle.setMaxLoad(rs.getLong(7));
                vehicle.setCrew(rs.getLong(8));
                vehicle.setPrice(rs.getLong(9));
                return vehicle;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Vehicle> getAll() {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT id, name, description, avg_speed, max_speed, max_speed_timeout, max_load, crew, price "
                    + "FROM vehicle");

            ResultSet rs = ps.executeQuery();
            List<Vehicle> results = new ArrayList<>();

            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getLong(1));
                vehicle.setName(rs.getString(2));
                vehicle.setDescription(rs.getString(3));
                vehicle.setAvgSpeed(rs.getLong(4));
                vehicle.setMaxSpeed(rs.getLong(5));
                vehicle.setMaxSpeedTimeout(rs.getLong(6));
                vehicle.setMaxLoad(rs.getLong(7));
                vehicle.setCrew(rs.getLong(8));
                vehicle.setPrice(rs.getLong(9));
                results.add(vehicle);
            }
            return results;
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM vehicle WHERE id=?", Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDaoJDBCImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
