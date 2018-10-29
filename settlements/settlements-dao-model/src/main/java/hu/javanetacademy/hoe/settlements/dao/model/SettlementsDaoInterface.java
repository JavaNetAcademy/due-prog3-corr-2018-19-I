
package hu.javanetacademy.hoe.settlements.dao.model;

import java.util.List;

/**
 *
 * @author Prototype_ (Szabó Zoltán)
 */
public interface SettlementsDaoInterface {
    
    public Settlements create(Settlements pSettlements);
    public Settlements modify(long psettlementsid, Settlements pSettlements);
    public Settlements delete(long psettlementsid);
    public Settlements get(long psettlementsid);
    public List<Settlements> getByEmpire(long pempiresId);
    public boolean existsByName(String pSettlementsName, long pempiresId);
    
}
