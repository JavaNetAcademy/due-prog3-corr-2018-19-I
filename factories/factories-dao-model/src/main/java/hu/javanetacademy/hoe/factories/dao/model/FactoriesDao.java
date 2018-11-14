package hu.javanetacademy.hoe.factories.dao.model;

import java.util.List;

/**
 * @author jrajmund
 */
public interface FactoriesDao {

    public Factories create(Factories pFactory);

    public boolean existsById(Factories pFactory);
}
