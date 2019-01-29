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
import hu.javanetacademy.hoe.armor.service.ArmorService;
import hu.javanetacademy.hoe.armor.service.exception.ArmorServiceException;

/**
 *
 * @author Gonda Gergely
 *
 */
public class ArmorServiceImpl implements ArmorService {

	private static final Logger LOG = Logger.getLogger(ArmorServiceImpl.class.getName());

	private final ArmorDAO armorDao;

	private final ArmorPropertiesCodebookXreDAO armorPropertiesCodebookXreDao;

	public ArmorServiceImpl() {
		armorDao = new ArmorDAOImpl();
		armorPropertiesCodebookXreDao = new ArmorPropertiesCodebookXreDAOImpl();
	}

	@Override
	public void create(ArmorDTO armor) {
		try {
			armorDao.create(mapToDAO(armor));
		} catch (Exception e) {
			ArmorServiceImpl.LOG.log(Level.SEVERE, e.getMessage(), e);
			throw new ArmorServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<ArmorDTO> getAll() {
		List<ArmorDTO> result = new ArrayList<>();
		try {
			armorDao.getAll().forEach(item -> result.add(mapToDTO(item)));
		} catch (Exception e) {
			ArmorServiceImpl.LOG.log(Level.SEVERE, e.getMessage(), e);
			throw new ArmorServiceException(e.getMessage(), e);
		}
		return result;
	}

	@Override
	public ArmorDTO getById(Long id) {
		ArmorDTO result = null;
		try {
			result = mapToDTO(armorDao.getById(id));
		} catch (Exception e) {
			ArmorServiceImpl.LOG.log(Level.SEVERE, e.getMessage(), e);
			throw new ArmorServiceException(e.getMessage(), e);
		}
		return result;
	}

	@Override
	public void update(ArmorDTO armor) {
		try {
			armorDao.update(mapToDAO(armor));
		} catch (Exception e) {
			ArmorServiceImpl.LOG.log(Level.SEVERE, e.getMessage(), e);
			throw new ArmorServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void delete(Long id) {
		try {
			armorDao.delete(id);
		} catch (Exception e) {
			ArmorServiceImpl.LOG.log(Level.SEVERE, e.getMessage(), e);
			throw new ArmorServiceException(e.getMessage(), e);
		}
	}

	private Armor mapToDAO(ArmorDTO armor) {
		Armor dto = new Armor();
		dto.setId(armor.getId());
		dto.setName(armor.getName());
		dto.setPrice(armor.getPrice());
		dto.setDescription(armor.getDescription());
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
