package hu.javanetacademy.hoe.factories.service.object;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.empires.dao.model.Empires;
import hu.javanetacademy.hoe.factories.dao.jdbc.FactoriesDaoJDBCImpl;
import hu.javanetacademy.hoe.factories.dao.model.Factories;
import hu.javanetacademy.hoe.factories.dao.model.FactoriesDao;
import java.util.List;

/**
 * @author jrajmund
 */
public class FactoriesService {

    private FactoriesDao dao = new FactoriesDaoJDBCImpl();

    public Factories create(Factories pNewFactory) {
        boolean exists = dao.existsById(pNewFactory);
        if (exists == false) {
            return dao.create(pNewFactory);
        } else {
            throw new CustomException();
        }
    }

    public List<Factories> getByUser(long pUserId) {
        return dao.getByUser(pUserId);
    }

    public Factories delete(long pFactoryId) {
        return dao.delete(pFactoryId);
    }

    public Factories modify(long pOldFactoryId, Factories pNewFactory) {
        boolean exists = dao.existsByNameDescId(pNewFactory);
        if (exists == false) {
            return dao.modify(pOldFactoryId, pNewFactory);
        } else {
            throw new CustomException();
        }
    }

    public Factories get(long pFactoryId) {
        return dao.get(pFactoryId);
    }

    public Empires getByLevel(long pEmpireId) {
        return dao.getByLevel(pEmpireId);
    }
}
