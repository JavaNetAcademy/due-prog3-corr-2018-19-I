package hu.javanetacademy.hoe.culturalbuilding.dao.model;

import java.util.List;

import hu.javanetacademy.hoe.culturalbuilding.dao.model.CulturalBuilding;

/**
*
* @author Soos Gabor
*
*/
public interface CulturalBuildingDAO {
	public CulturalBuilding create(CulturalBuilding CulturalBuilding);

	public List<CulturalBuilding> getAll();

	public CulturalBuilding getById(Long id);

	public CulturalBuilding update(CulturalBuilding CulturalBuilding);
	
	public void delete(long cBuildingId);
	
	public boolean existsByName(String cBuildingName);
}
