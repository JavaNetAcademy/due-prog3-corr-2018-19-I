package hu.javanetacademy.hoe.armor.service.imp;

import java.util.List;

import hu.javanetacademy.hoe.armor.dao.ArmorDAO;
import hu.javanetacademy.hoe.armor.dao.dto.ArmorDTO;
import hu.javanetacademy.hoe.armor.dao.impl.ArmorDAOImpl;
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
	public void create(ArmorDTO armor) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ArmorDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArmorDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ArmorDTO armor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
