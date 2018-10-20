package hu.javanetacademy.hoe.weapon.dao.model;

import java.util.List;

/**
 *
 * @author Richard
 */
public interface WeaponDAOInterface {
    public Weapon buy(long id);
    public List<Weapon> getForHero(long pHeroId);
}
