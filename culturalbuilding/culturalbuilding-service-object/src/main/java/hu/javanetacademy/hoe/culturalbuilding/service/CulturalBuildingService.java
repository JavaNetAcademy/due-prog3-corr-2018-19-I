package hu.javanetacademy.hoe.culturalbuilding.service;

import java.util.ArrayList;
import java.util.List;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.culturalbuilding.dao.file.CulturalBuildingDAOImpl;
import hu.javanetacademy.hoe.culturalbuilding.dao.model.CulturalBuilding;
import hu.javanetacademy.hoe.culturalbuilding.dao.model.CulturalBuildingDAO;

/**
*
* @author Soos Gabor
*
*/
public class CulturalBuildingService {

	private final CulturalBuildingDAO dao;

	public CulturalBuildingService() {
		dao = new CulturalBuildingDAOImpl();
	}

	public void create(CulturalBuilding CulturalBuilding) {
		try {
			dao.create(CulturalBuilding);
		} catch (Exception e) {
			throw new CustomException();
		}
	}

	public List<CulturalBuilding> getAll() {
		List<CulturalBuilding> culturalBuildings = new ArrayList<>();
		try {
			culturalBuildings.addAll(dao.getAll());
		} catch (Exception e) {
			throw new CustomException();
		}
		return culturalBuildings;
	}

	public CulturalBuilding getById(Long id) {
		CulturalBuilding culturalBuilding = new CulturalBuilding();
		try {
			culturalBuilding = dao.getById(id);
		} catch (Exception e) {
			throw new CustomException();
		}
		return culturalBuilding;
	}

	public CulturalBuilding update(CulturalBuilding culturalBuilding) {
		try {
			return dao.update(culturalBuilding);
		} catch (Exception e) {
			throw new CustomException();
		}
	}
	
	
    public CulturalBuilding modify(String originalName, CulturalBuilding culturalBuilding) {
        boolean exists = false;
        String name = culturalBuilding.getName();
        if (!name.equals(originalName)) {
            exists = dao.existsByName(culturalBuilding.getName());
        }
        if (exists == false) {
            return dao.update(culturalBuilding);
        } else {
            throw new CustomException();
        }
    }
	
	public void delete(long  cBuildingId) {
		try {
			dao.delete(cBuildingId);
		} catch (Exception e) {
			throw new CustomException();
		}
	}
}
