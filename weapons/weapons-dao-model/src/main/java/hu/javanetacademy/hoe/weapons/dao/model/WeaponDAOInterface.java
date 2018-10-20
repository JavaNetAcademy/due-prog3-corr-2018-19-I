package hu.javanetacademy.hoe.weapons.dao.model;

import java.util.List;

/**
 *
 * @author Richard
 */
public interface WeaponDAOInterface {
    public Weapon buy(long id);
    public List<Weapon> getForHero(long pHeroId);
}
