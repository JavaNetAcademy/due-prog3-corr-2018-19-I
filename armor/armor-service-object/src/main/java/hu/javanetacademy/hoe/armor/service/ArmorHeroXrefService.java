package hu.javanetacademy.hoe.armor.service;

import java.util.List;

import hu.javanetacademy.hoe.armor.dao.dto.ArmorHeroXrefDTO;

public interface ArmorHeroXrefService {

	public void create(ArmorHeroXrefDTO armorHeroXref);

	public List<ArmorHeroXrefDTO> getAllByHeroId(Long heroId);

	public void deleteAllByHeroId(Long heroId);

	public void deleteAllByArmorId(Long armorId);

	public void delete(Long id);

}
