package hu.javanetacademy.hoe.armor.dao;

import java.util.List;

import hu.javanetacademy.hoe.armor.dao.entity.ArmorPropertiesCodebookXref;

public interface ArmorPropertiesCodebookXreDAO {
	public void create(ArmorPropertiesCodebookXref armorHeroXref);

	public List<ArmorPropertiesCodebookXref> getAllByArmorId(Long armorId);

	public void deleteAllByArmorId(Long armorId);

	public void deleteAllByPropertiesCodebookId(Long propertiesCodebookId);

	public void delete(Long id);

}
