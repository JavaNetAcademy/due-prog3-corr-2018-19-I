package hu.javanetacademy.hoe.armor.service;

import java.util.List;

import hu.javanetacademy.hoe.armor.dao.entity.Armor;

/**
 *
 * @author Gonda Gergely
 *
 */
public interface ArmorService {

	public void create(Armor armor);

	public List<Armor> getAll();

	public Armor getById(Long id);

	public void update(Armor armor);

}
