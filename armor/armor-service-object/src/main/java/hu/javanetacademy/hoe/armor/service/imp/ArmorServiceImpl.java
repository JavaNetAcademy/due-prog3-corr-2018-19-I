package hu.javanetacademy.hoe.armor.service.imp;

import java.util.ArrayList;
import java.util.List;

import hu.javanetacademy.hoe.armor.dao.file.ArmorDAOImpl;
import hu.javanetacademy.hoe.armor.dao.model.Armor;
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

	@Override
	public void create(Armor armor) {
		try {
			dao.create(armor);
		} catch (Exception e) {
			// TODO loglás
			e.printStackTrace();// ideiglenes
		}
	}

	@Override
	public List<Armor> getAll() {
		List<Armor> armors = new ArrayList<>();
		try {
			armors.addAll(dao.getAll());
		} catch (Exception e) {
			// TODO loglás
			e.printStackTrace();// ideiglenes
		}
		return armors;
	}

	@Override
	public Armor getById(Long id) {
		Armor armor = null;
		try {
			armor = dao.getById(id);
		} catch (Exception e) {
			// TODO loglás
			e.printStackTrace();// ideiglenes
		}
		return armor;
	}

	@Override
	public void update(Armor armor) {
		try {
			dao.update(armor);
		} catch (Exception e) {
			// TODO loglás
			e.printStackTrace();// ideiglenes
		}
	}

}
