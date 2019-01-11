package hu.javanetacademy.hoe.vehicles.dao.model;

/**
 *
 * @author jbasiszta
 */
public interface VehicleDao {
    public Vehicle Create(Vehicle vehicle);
    public Vehicle GetByName(String name);
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
