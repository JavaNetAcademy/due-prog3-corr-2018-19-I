package hu.javanetacademy.hoe.settlements.service.object;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.settlements.dao.jdbc.SettlementsDaoJDBCImpl;
import hu.javanetacademy.hoe.settlements.dao.model.Settlements;
import hu.javanetacademy.hoe.settlements.dao.model.SettlementsDaoInterface;
import java.util.List;

/**
 *
 * @author Prototype_ (Szabó Zoltán)
 */
public class SettlementsService {
    private SettlementsDaoInterface dao = new SettlementsDaoJDBCImpl();
    
    public Settlements create(Settlements pNewSettlements){
        boolean exists = dao.existsByName(pNewSettlements.getName(), pNewSettlements.getEmpireid());
        if (exists == false){
            return dao.create(pNewSettlements);
        }else{
            throw new CustomException();
        }
    }
    public Settlements modify(long settlementsid, String originalName, Settlements settlements){
        boolean exists = false;
        String settlementsName = settlements.getName();
        
        if(!settlementsName.equals(originalName)){
            exists = dao.existsByName(settlements.getName(), settlements.getEmpireid());
        }
        if (exists == false){
            return dao.modify(settlementsid, settlements);
        }else {
            throw new CustomException();
        }
    }
    public Settlements delete(long settlementsid){
        return dao.delete(settlementsid);
    }
    public Settlements get(long settlementsid){
        return dao.get(settlementsid);
    }
    public List<Settlements> getByEmpire(long empireId){
        return dao.getByEmpire(empireId);
    }
}
