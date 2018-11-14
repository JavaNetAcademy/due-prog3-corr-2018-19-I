package hu.javanetacademy.hoe.factories.service.object;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.factories.dao.jdbc.FactoriesDaoJDBCImpl;
import hu.javanetacademy.hoe.factories.dao.model.Factories;
import hu.javanetacademy.hoe.factories.dao.model.FactoriesDao;

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
}
