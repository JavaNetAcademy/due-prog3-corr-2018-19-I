package hu.javanetacademy.hoe.factories.dao.model;

import hu.javanetacademy.hoe.empires.dao.model.Empires;
import java.util.List;

/**
 * @author jrajmund
 */
public interface FactoriesDao {

    public Factories create(Factories pFactory);

    public boolean existsById(Factories pFactory);

    public List<Factories> getByUser(long pUserId);

    public Factories delete(long pFactoryId);

    public Factories modify(long pOldFactoryId, Factories pNewFactory);

    public boolean existsByNameDescId(Factories pFactory);

    public Factories get(long pFactoryId);
    
    public Empires getByLevel(long pEmpireId);
}
