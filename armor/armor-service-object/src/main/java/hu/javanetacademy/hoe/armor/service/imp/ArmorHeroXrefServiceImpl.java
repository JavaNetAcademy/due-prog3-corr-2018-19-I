package hu.javanetacademy.hoe.armor.service.imp;

import java.util.List;
import java.util.logging.Logger;

import hu.javanetacademy.hoe.armor.dao.ArmorHeroXrefDAO;
import hu.javanetacademy.hoe.armor.dao.dto.ArmorHeroXrefDTO;
import hu.javanetacademy.hoe.armor.dao.impl.ArmorHeroXrefDAOImpl;
import hu.javanetacademy.hoe.armor.service.ArmorHeroXrefService;

/**
 *
 * @author Gonda Gergely
 *
 */
public class ArmorHeroXrefServiceImpl implements ArmorHeroXrefService {

	private static final Logger LOG = Logger.getLogger(ArmorHeroXrefService.class.getName());

	@SuppressWarnings("unused")
	private final ArmorHeroXrefDAO dao;

	public ArmorHeroXrefServiceImpl() {
		dao = new ArmorHeroXrefDAOImpl();
	}

	@Override
	public void create(ArmorHeroXrefDTO armorHeroXref) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ArmorHeroXrefDTO> getAllByHeroId(Long heroId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllByHeroId(Long heroId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllByArmorId(Long armorId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
