package hu.javanetacademy.hoe.vehicles.service.object;

import hu.javanetacademy.hoe.vehicles.dao.jdbc.VehicleDaoJDBCImpl;
import hu.javanetacademy.hoe.vehicles.dao.model.Vehicle;
import hu.javanetacademy.hoe.vehicles.dao.model.VehicleDao;
import hu.javanetacademy.hoe.base.util.CustomException;

/**
 *
 * @author jbasiszta
 */
public class VehicleServiceObjectImpl {

    VehicleDao dao = new VehicleDaoJDBCImpl();

    public Vehicle Create(Vehicle vehicle) {
        Vehicle existing = dao.GetByName(vehicle.getName());
        if (existing == null) {
            return dao.Create(vehicle);
        }
        throw new CustomException();
//        return null;
    }
}
