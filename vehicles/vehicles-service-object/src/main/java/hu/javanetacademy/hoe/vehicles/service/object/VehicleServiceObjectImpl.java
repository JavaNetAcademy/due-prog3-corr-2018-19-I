package hu.javanetacademy.hoe.vehicles.service.object;

import hu.javanetacademy.hoe.vehicles.dao.jdbc.VehicleDaoJDBCImpl;
import hu.javanetacademy.hoe.vehicles.dao.model.Vehicle;
import hu.javanetacademy.hoe.vehicles.dao.model.VehicleDao;
import hu.javanetacademy.hoe.base.util.CustomException;
import java.util.List;

/**
 *
 * @author jbasiszta
 */
public class VehicleServiceObjectImpl {

    private VehicleDao dao = new VehicleDaoJDBCImpl();

    public Vehicle create(Vehicle vehicle) {
        Vehicle existing = dao.getByName(vehicle.getName());
        if (existing == null) {
            return dao.create(vehicle);
        }
        throw new CustomException();
//        return null;
    }

    public List<Vehicle> getAll() {
        return dao.getAll();
    }
}
