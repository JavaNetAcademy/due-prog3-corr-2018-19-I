package hu.javanetacademy.hoe.armor.service.imp;

import hu.javanetacademy.hoe.armor.dao.file.ArmorDAOImpl;
import hu.javanetacademy.hoe.armor.dao.model.ArmorDAO;
import hu.javanetacademy.hoe.armor.service.ArmorService;

/**
 *
 * @author Gonda Gergely
 *
 */
public class ArmorServiceImpl implements ArmorService {

	@SuppressWarnings("unused")
	private final ArmorDAO dao;

	public ArmorServiceImpl() {
		dao = new ArmorDAOImpl();
	}

}
