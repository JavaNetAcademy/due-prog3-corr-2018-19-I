package hu.javanetacademy.hoe.pets.pets.service.object;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.pets.dao.jdbc.PetJDBCDAOimpl;
import hu.javanetacademy.hoe.pets.dao.model.Pet;
import hu.javanetacademy.hoe.pets.dao.model.PetDAOInterface;
import java.util.List;

/**
 * @author Heyzel (Horvath Gergely)
 */
public class PetsService {
    private PetDAOInterface dao = new PetJDBCDAOimpl();
   
   public Pet create(Pet pNewPet){
       boolean exists = dao.existsByName(pNewPet.getName(), pNewPet.getHeroid());
       if(exists == false)
        return dao.create(pNewPet);
       else 
           throw new CustomException();
   }
   
   public List<Pet> getForHero(long pHeroId){
       return dao.getForHero(pHeroId);
   }
}
