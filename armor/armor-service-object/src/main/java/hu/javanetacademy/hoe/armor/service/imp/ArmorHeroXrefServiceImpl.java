package hu.javanetacademy.hoe.armor.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import hu.javanetacademy.hoe.armor.dao.ArmorDAO;
import hu.javanetacademy.hoe.armor.dao.ArmorHeroXrefDAO;
import hu.javanetacademy.hoe.armor.dao.ArmorPropertiesCodebookXreDAO;
import hu.javanetacademy.hoe.armor.dao.dto.ArmorDTO;
import hu.javanetacademy.hoe.armor.dao.dto.ArmorHeroXrefDTO;
import hu.javanetacademy.hoe.armor.dao.dto.ArmorPropertiesCodebookXrefDTO;
import hu.javanetacademy.hoe.armor.dao.entity.Armor;
import hu.javanetacademy.hoe.armor.dao.entity.ArmorHeroXref;
import hu.javanetacademy.hoe.armor.dao.entity.ArmorPropertiesCodebookXref;
import hu.javanetacademy.hoe.armor.dao.impl.ArmorDAOImpl;
import hu.javanetacademy.hoe.armor.dao.impl.ArmorHeroXrefDAOImpl;
import hu.javanetacademy.hoe.armor.dao.impl.ArmorPropertiesCodebookXreDAOImpl;
import hu.javanetacademy.hoe.armor.service.ArmorHeroXrefService;
import hu.javanetacademy.hoe.armor.service.exception.ArmorHeroXrefServiceException;
import hu.javanetacademy.hoe.hero.service.object.HeroService;

/**
 *
 * @author Gonda Gergely
 *
 */
public class ArmorHeroXrefServiceImpl implements ArmorHeroXrefService {

	private static final Logger LOG = Logger.getLogger(ArmorHeroXrefService.class.getName());

	private final ArmorDAO armorDao;

	private final HeroService heroService;

	private final ArmorHeroXrefDAO armorHeroXrefDao;

	private final ArmorPropertiesCodebookXreDAO armorPropertiesCodebookXreDao;

	public ArmorHeroXrefServiceImpl() {
		armorDao = new ArmorDAOImpl();
		heroService = new HeroService();
		armorHeroXrefDao = new ArmorHeroXrefDAOImpl();
		armorPropertiesCodebookXreDao = new ArmorPropertiesCodebookXreDAOImpl();
	}

	@Override
	public void create(ArmorHeroXrefDTO armorHeroXref) {
		try {
			armorHeroXrefDao.create(mapToDAO(armorHeroXref));
		} catch (Exception e) {
			ArmorHeroXrefServiceImpl.LOG.log(Level.SEVERE, e.getMessage(), e);
			throw new ArmorHeroXrefServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<ArmorHeroXrefDTO> getAllByHeroId(Long heroId) {
		List<ArmorHeroXrefDTO> result = new ArrayList<>();
		try {
			armorHeroXrefDao.getAllByHeroId(heroId).forEach(item -> result.add(mapToDTO(item)));
		} catch (Exception e) {
			ArmorHeroXrefServiceImpl.LOG.log(Level.SEVERE, e.getMessage(), e);
			throw new ArmorHeroXrefServiceException(e.getMessage(), e);
		}
		return result;
	}

	@Override
	public void deleteAllByHeroId(Long heroId) {
		try {
			armorHeroXrefDao.deleteAllByHeroId(heroId);
		} catch (Exception e) {
			ArmorHeroXrefServiceImpl.LOG.log(Level.SEVERE, e.getMessage(), e);
			throw new ArmorHeroXrefServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void deleteAllByArmorId(Long armorId) {
		try {
			armorHeroXrefDao.deleteAllByArmorId(armorId);
		} catch (Exception e) {
			ArmorHeroXrefServiceImpl.LOG.log(Level.SEVERE, e.getMessage(), e);
			throw new ArmorHeroXrefServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void delete(Long id) {
		try {
			armorHeroXrefDao.delete(id);
		} catch (Exception e) {
			ArmorHeroXrefServiceImpl.LOG.log(Level.SEVERE, e.getMessage(), e);
			throw new ArmorHeroXrefServiceException(e.getMessage(), e);
		}
	}

	private ArmorHeroXref mapToDAO(ArmorHeroXrefDTO armorHeroXref) {
		ArmorHeroXref dao = new ArmorHeroXref();
		dao.setId(armorHeroXref.getId());
		dao.setArmorId(armorHeroXref.getArmor().getId());
		dao.setHeroId(armorHeroXref.getHero().getId());
		return dao;
	}

	private ArmorHeroXrefDTO mapToDTO(ArmorHeroXref item) {
		ArmorHeroXrefDTO dto = new ArmorHeroXrefDTO();
		dto.setId(item.getId());
		dto.setArmor(this.mapToDTO(armorDao.getById(item.getArmorId())));
		dto.setHero(heroService.get(item.getHeroId()));
		return dto;
	}

	private ArmorDTO mapToDTO(Armor armor) {
		ArmorDTO dto = new ArmorDTO();
		dto.setId(armor.getId());
		dto.setName(armor.getName());
		dto.setPrice(armor.getPrice());
		dto.setDescription(armor.getDescription());

		List<ArmorPropertiesCodebookXrefDTO> armorPropList = new ArrayList<>();

		armorPropertiesCodebookXreDao.getAllByArmorId(armor.getId()).forEach(item -> armorPropList.add(mapToDTO(item)));

		dto.setArmorPropertiesCodebookXrefs(armorPropList);
		return dto;
	}

	private ArmorPropertiesCodebookXrefDTO mapToDTO(ArmorPropertiesCodebookXref item) {
		ArmorPropertiesCodebookXrefDTO dto = new ArmorPropertiesCodebookXrefDTO();

		Armor armor = armorDao.getById(item.getArmorId());

		ArmorDTO armorDto = new ArmorDTO();
		armorDto.setId(armor.getId());
		armorDto.setName(armor.getName());
		armorDto.setPrice(armor.getPrice());
		armorDto.setDescription(armor.getDescription());

		dto.setId(item.getId());
		dto.setArmor(armorDto);

		// TODO teljes mapolás nem lehetséges mivel nincsen meg a modul akitől le tudnám
		// kérni adapteren keresztül páncélhoz tartozó tulajdonságokat a 2 microservice
		// között.
		// dto.setPropertiesCodebook(propertiesCodebook);
		return dto;
	}

}
