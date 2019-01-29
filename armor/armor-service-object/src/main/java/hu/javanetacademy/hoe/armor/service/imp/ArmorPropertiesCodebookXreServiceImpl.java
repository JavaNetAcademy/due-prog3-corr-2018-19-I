package hu.javanetacademy.hoe.armor.service.imp;

import java.util.List;
import java.util.logging.Logger;

import hu.javanetacademy.hoe.armor.dao.ArmorPropertiesCodebookXreDAO;
import hu.javanetacademy.hoe.armor.dao.dto.ArmorPropertiesCodebookXrefDTO;
import hu.javanetacademy.hoe.armor.dao.impl.ArmorPropertiesCodebookXreDAOImpl;
import hu.javanetacademy.hoe.armor.service.ArmorPropertiesCodebookXreService;

/**
 *
 * @author Gonda Gergely
 *
 */
public class ArmorPropertiesCodebookXreServiceImpl implements ArmorPropertiesCodebookXreService {

	private static final Logger LOG = Logger.getLogger(ArmorPropertiesCodebookXreServiceImpl.class.getName());

	@SuppressWarnings("unused")
	private final ArmorPropertiesCodebookXreDAO dao;

	public ArmorPropertiesCodebookXreServiceImpl() {
		dao = new ArmorPropertiesCodebookXreDAOImpl();
	}

	@Override
	public void create(ArmorPropertiesCodebookXrefDTO armorHeroXref) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ArmorPropertiesCodebookXrefDTO> getAllByArmorId(Long armorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllByArmorId(Long armorId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllByPropertiesCodebookId(Long propertiesCodebookId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
