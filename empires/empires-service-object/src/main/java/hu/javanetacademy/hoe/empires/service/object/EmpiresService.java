package hu.javanetacademy.hoe.empires.service.object;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.empires.dao.jdbc.EmpiresDaoJDBCImpl;
import hu.javanetacademy.hoe.empires.dao.model.Empires;
import hu.javanetacademy.hoe.empires.dao.model.EmpiresDaoInterface;
import java.util.List;

/**
 * @author Laptop
 */
public class EmpiresService {

    private EmpiresDaoInterface dao = new EmpiresDaoJDBCImpl();

    public Empires create(Empires pNewEmpires) {
        boolean exists = dao.existsByName(pNewEmpires.getName(), pNewEmpires.getUserid());
        if (exists == false) {
            return dao.create(pNewEmpires);
        } else {
            throw new CustomException();
        }
    }

    public Empires modify(long empiresId, Empires empires) {
        boolean exists = dao.existsByName(empires.getName(), empires.getUserid());
        if (exists == false) {
            return dao.modify(empiresId, empires);
        } else {
            throw new CustomException();
        }
    }

    public Empires get(long empiresId) {
        return dao.get(empiresId);
    }

    public List<Empires> getByUser(long pUserId) {
        return dao.getByUser(pUserId);
    }

}
