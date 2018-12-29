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

    public Empires modify(long pempiresId, String originalName, Empires pempires) {

 boolean exists = false;
        String empiresName = pempires.getName(); 
        
         if (!empiresName.equals(originalName)) {
            exists = dao.existsByName(pempires.getName(), pempires.getUserid());
        }
        
        if (exists == false) {
            return dao.modify(pempiresId, pempires);
        } else {
            throw new CustomException();
        }
    }
     public Empires delete(long empiresId) {
        return dao.delete(empiresId);
    }

    public Empires get(long empiresId) {
        return dao.get(empiresId);
    }

    public List<Empires> getByUser(long pUserId) {
        return dao.getByUser(pUserId);
    }

}
