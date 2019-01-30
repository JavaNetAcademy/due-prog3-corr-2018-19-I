package hu.javanetacademy.hoe.armor.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import hu.javanetacademy.hoe.armor.dao.ArmorDAO;
import hu.javanetacademy.hoe.armor.dao.ArmorPropertiesCodebookXreDAO;
import hu.javanetacademy.hoe.armor.dao.dto.ArmorDTO;
import hu.javanetacademy.hoe.armor.dao.dto.ArmorPropertiesCodebookXrefDTO;
import hu.javanetacademy.hoe.armor.dao.entity.Armor;
import hu.javanetacademy.hoe.armor.dao.entity.ArmorPropertiesCodebookXref;
import hu.javanetacademy.hoe.armor.dao.impl.ArmorDAOImpl;
import hu.javanetacademy.hoe.armor.dao.impl.ArmorPropertiesCodebookXreDAOImpl;
import hu.javanetacademy.hoe.armor.service.ArmorPropertiesCodebookXreService;
import hu.javanetacademy.hoe.armor.service.exception.ArmorPropertiesCodebookXreServiceException;

/**
 *
 * @author Gonda Gergely
 *
 */
public class ArmorPropertiesCodebookXreServiceImpl implements ArmorPropertiesCodebookXreService {

	private static final Logger LOG = Logger.getLogger(ArmorPropertiesCodebookXreServiceImpl.class.getName());

	private final ArmorDAO armorDao;

	private final ArmorPropertiesCodebookXreDAO armorPropertiesCodebookXreDao;

	public ArmorPropertiesCodebookXreServiceImpl() {
		armorDao = new ArmorDAOImpl();
		armorPropertiesCodebookXreDao = new ArmorPropertiesCodebookXreDAOImpl();
	}

	@Override
	public void create(ArmorPropertiesCodebookXrefDTO armorHeroXref) {
		try {
			armorPropertiesCodebookXreDao.create(mapToDAO(armorHeroXref));
		} catch (Exception e) {
			ArmorPropertiesCodebookXreServiceImpl.LOG.log(Level.SEVERE, e.getMessage(), e);
			throw new ArmorPropertiesCodebookXreServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<ArmorPropertiesCodebookXrefDTO> getAllByArmorId(Long armorId) {
		List<ArmorPropertiesCodebookXrefDTO> result = new ArrayList<>();
		try {
			armorPropertiesCodebookXreDao.getAllByArmorId(armorId).forEach(item -> result.add(mapToDTO(item)));
		} catch (Exception e) {
			ArmorPropertiesCodebookXreServiceImpl.LOG.log(Level.SEVERE, e.getMessage(), e);
			throw new ArmorPropertiesCodebookXreServiceException(e.getMessage(), e);
		}
		return result;
	}

	@Override
	public void deleteAllByArmorId(Long armorId) {
		try {
			armorPropertiesCodebookXreDao.deleteAllByArmorId(armorId);
		} catch (Exception e) {
			ArmorPropertiesCodebookXreServiceImpl.LOG.log(Level.SEVERE, e.getMessage(), e);
			throw new ArmorPropertiesCodebookXreServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void deleteAllByPropertiesCodebookId(Long propertiesCodebookId) {
		try {
			armorPropertiesCodebookXreDao.deleteAllByPropertiesCodebookId(propertiesCodebookId);
		} catch (Exception e) {
			ArmorPropertiesCodebookXreServiceImpl.LOG.log(Level.SEVERE, e.getMessage(), e);
			throw new ArmorPropertiesCodebookXreServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void delete(Long id) {
		try {
			armorPropertiesCodebookXreDao.delete(id);
		} catch (Exception e) {
			ArmorPropertiesCodebookXreServiceImpl.LOG.log(Level.SEVERE, e.getMessage(), e);
			throw new ArmorPropertiesCodebookXreServiceException(e.getMessage(), e);
		}
	}

	private ArmorPropertiesCodebookXref mapToDAO(ArmorPropertiesCodebookXrefDTO armorHeroXref) {
		ArmorPropertiesCodebookXref dao = new ArmorPropertiesCodebookXref();
		dao.setId(armorHeroXref.getId());
		dao.setArmorId(armorHeroXref.getArmor().getId());
		dao.setPropertiesCodebookId(armorHeroXref.getPropertiesCodebook().getId());
		return dao;
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
