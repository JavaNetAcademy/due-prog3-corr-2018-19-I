package hu.javanetacademy.hoe.hero.service.object;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.hero.dao.file.HeroJDBCDAOImpl;
import hu.javanetacademy.hoe.hero.dao.model.Hero;
import hu.javanetacademy.hoe.hero.dao.model.HeroDAOInterface;

import java.util.List;

/**
 * @author krisztian
 */
public class HeroService {
   private HeroDAOInterface dao= new HeroJDBCDAOImpl();
   
   public Hero create(Hero pNewHero){
       Hero avb = dao.getByNameFromUser(pNewHero.getName(), pNewHero.getUserid());
       if(avb==null)
        return dao.create(pNewHero);
       else 
           throw new CustomException();
   }
   
   public List<Hero> getHeroByUser(long pUserId){
       return dao.getByUser(pUserId);
   }
   
}
