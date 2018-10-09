
package hu.javanetacademy.hoe.empires.service.object;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.empires.dao.jdbc.EmpiresDaoJDBCImpl;
import hu.javanetacademy.hoe.empires.dao.model.Empires;
import hu.javanetacademy.hoe.empires.dao.model.EmpiresDaoInterface;
import java.util.List;

/**
 *
 * @author Laptop
 */
public class EmpiresService {
    private EmpiresDaoInterface dao= new EmpiresDaoJDBCImpl();
   
   public Empires create(Empires pNewEmpires){
       Empires avb = dao.getByNameFromUser(pNewEmpires.getName(), pNewEmpires.getUserid());
       if(avb==null)
        return dao.create(pNewEmpires);
       else 
          throw new CustomException();
   }
   
   public List<Empires> getHeroByUser(long pUserId){
       return dao.getByUser(pUserId);
   }
    
}
