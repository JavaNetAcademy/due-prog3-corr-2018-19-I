package hu.javanetacademy.hoe.weapons.service.object;

import hu.javanetacademy.hoe.weapons.dao.jdbc.WeaponDaoJDBCImpl;
import hu.javanetacademy.hoe.weapons.dao.model.Weapon;
import hu.javanetacademy.hoe.weapons.dao.model.WeaponDAOInterface;
import java.util.List;

/**
 *
 * @author Richard
 */
public class WeaponsService {
    WeaponDAOInterface dao  = new WeaponDaoJDBCImpl();
    
    public Weapon buy(long id) {
        return null;
    }
    
    public List<Weapon> getForHero(long pHeroId) {
        return null;
    }
}
