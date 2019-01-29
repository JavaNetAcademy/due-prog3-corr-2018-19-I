package hu.javanetacademy.hoe.armor.service;

import java.util.List;

import hu.javanetacademy.hoe.armor.dao.dto.ArmorDTO;

/**
 *
 * @author Gonda Gergely
 *
 */
public interface ArmorService {

	public void create(ArmorDTO armor);

	public List<ArmorDTO> getAll();

	public ArmorDTO getById(Long id);

	public void update(ArmorDTO armor);

	public void delete(Long id);

}
