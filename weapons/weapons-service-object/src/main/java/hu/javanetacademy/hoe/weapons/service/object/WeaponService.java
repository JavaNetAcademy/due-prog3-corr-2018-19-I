package hu.javanetacademy.hoe.weapon.service.object;

import hu.javanetacademy.hoe.weapon.dao.jdbc.WeaponDaoJDBCImpl;
import hu.javanetacademy.hoe.weapon.dao.model.Weapon;
import hu.javanetacademy.hoe.weapon.dao.model.WeaponDAOInterface;
import java.util.List;

/**
 *
 * @author Richard
 */
public class WeaponService {
    WeaponDAOInterface dao  = new WeaponDaoJDBCImpl();
    
    public Weapon buy(long id) {
        return null;
    }
    
    public List<Weapon> getForHero(long pHeroId) {
        return null;
    }
}
