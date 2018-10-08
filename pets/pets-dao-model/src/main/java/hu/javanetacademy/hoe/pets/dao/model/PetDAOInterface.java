package hu.javanetacademy.hoe.pets.dao.model;

import java.util.List;

/**
 * @author Heyzel (Horvath Gergely)
 */
public interface PetDAOInterface {

    public Pet create(Pet pPet);

    public Pet modify(long pOldPetId, Pet pNewPet);

    public Pet delete(long pPetId);

    public Pet get(long pPetId);

    public List<Pet> getForHero(long pHeroId);
}
