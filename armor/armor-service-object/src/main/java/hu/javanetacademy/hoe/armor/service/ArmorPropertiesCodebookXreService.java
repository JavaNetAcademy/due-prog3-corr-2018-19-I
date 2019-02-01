package hu.javanetacademy.hoe.armor.service;

import java.util.List;

import hu.javanetacademy.hoe.armor.dao.dto.ArmorPropertiesCodebookXrefDTO;

public interface ArmorPropertiesCodebookXreService {

	public void create(ArmorPropertiesCodebookXrefDTO armorHeroXref);

	public List<ArmorPropertiesCodebookXrefDTO> getAllByArmorId(Long armorId);

	public void deleteAllByArmorId(Long armorId);

	public void deleteAllByPropertiesCodebookId(Long propertiesCodebookId);

	public void delete(Long id);

}
