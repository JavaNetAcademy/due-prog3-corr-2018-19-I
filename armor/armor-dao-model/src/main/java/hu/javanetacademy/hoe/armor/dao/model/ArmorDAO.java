package hu.javanetacademy.hoe.armor.dao.model;

import java.util.List;

/**
 *
 * @author Gonda Gergely
 *
 */
public interface ArmorDAO {

	public void create(Armor armor);

	public List<Armor> getAll();

	public Armor getById(Long id);

	public void update(Armor armor);

}
