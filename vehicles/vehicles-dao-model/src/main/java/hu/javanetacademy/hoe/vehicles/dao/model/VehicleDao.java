package hu.javanetacademy.hoe.vehicles.dao.model;

import java.util.List;

/**
 *
 * @author jbasiszta
 */
public interface VehicleDao {
    public Vehicle create(Vehicle vehicle);
    public Vehicle getByName(String name);
    public Vehicle getById(long id);
    public List<Vehicle> getAll();
    public void delete(long id);

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
