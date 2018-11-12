package hu.javanetacademy.hoe.factories.dao.model;

import java.util.List;

/**
 * @author jrajmund
 */
public interface FactoriesDao {

    public Factories create(Factories pFactory);

    public Factories modify(long pOldFactoryId, Factories pNewFactory);

    public Factories delete(long pFactoryId);

    public Factories get(long pFactoryId);

    public List<Factories> getByEmpire(long pEmpireId);

    public boolean existsByName(String pFactoryName, long pEmpireId);
}
