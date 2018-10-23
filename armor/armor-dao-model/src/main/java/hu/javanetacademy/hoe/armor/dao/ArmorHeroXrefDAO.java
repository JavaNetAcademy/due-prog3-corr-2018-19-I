package hu.javanetacademy.hoe.armor.dao;

import java.util.List;

import hu.javanetacademy.hoe.armor.dao.entity.ArmorHeroXref;

public interface ArmorHeroXrefDAO {

	public void create(ArmorHeroXref armorHeroXref);

	public List<ArmorHeroXref> getAllByHeroId(Long heroId);

	public void deleteAllByHeroId(Long heroId);

	public void deleteAllByArmorId(Long armorId);

	public void delete(Long id);

}
