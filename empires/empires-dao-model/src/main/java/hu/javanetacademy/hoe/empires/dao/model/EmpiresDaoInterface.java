package hu.javanetacademy.hoe.empires.dao.model;

import java.util.List;

/**
 *
 * @author Laptop
 */
public interface EmpiresDaoInterface {

    public Empires create(Empires pEmpires);

    public Empires modify(long pOldempiresId, Empires pNewempires);

    public Empires delete(long pEmpiresId);

    public Empires get(long pEmpiresId);

    public List<Empires> getByUser(long pUserId);

   public boolean existsByName(String pEmpiresName, long pUserId);

}
