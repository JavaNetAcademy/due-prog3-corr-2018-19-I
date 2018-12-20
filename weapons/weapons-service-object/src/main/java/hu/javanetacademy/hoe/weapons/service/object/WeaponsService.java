package hu.javanetacademy.hoe.weapons.service.object;

import java.util.List;

import hu.javanetacademy.hoe.weapon.dao.jdbc.WeaponDaoJDBCImpl;
import hu.javanetacademy.hoe.weapons.dao.model.Weapon;
import hu.javanetacademy.hoe.weapons.dao.model.WeaponDAOInterface;

/**
 *
 * @author Richard
 */
public class WeaponsService {
    WeaponDAOInterface dao = new WeaponDaoJDBCImpl();

    public Weapon buy(long id) {
        return null;
    }
    
    public Weapon create(Weapon weapon) {
        return dao.create(weapon);
    }
    
    public Weapon update(long weaponId, Weapon weapon) {
        return dao.update(weaponId, weapon);
    }
    
    public Weapon delete(long weaponId) {
        return dao.delete(weaponId);
    }
    
    public Weapon get(long weaponId) {
        return dao.get(weaponId);
    }

    public List<Weapon> getByUser(long pUserId) {
        return dao.getByUser(pUserId);
    }
}
