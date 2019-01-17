package hu.javanetacademy.hoe.vehicles.dao.model;

import java.util.List;

/**
 *
 * @author jbasiszta
 */
public interface VehicleDao {
    public Vehicle Create(Vehicle vehicle);
    public Vehicle GetByName(String name);
    public List<Vehicle> GetAll();

//    public Vehicle Create(
//            String name,
//            String description,
//            long avgSpeed,
//            long maxSpeed,
//            long maxSpeedTimeout,
//            long maxLoad,
//            long crew,
//            long price
//    );
}
