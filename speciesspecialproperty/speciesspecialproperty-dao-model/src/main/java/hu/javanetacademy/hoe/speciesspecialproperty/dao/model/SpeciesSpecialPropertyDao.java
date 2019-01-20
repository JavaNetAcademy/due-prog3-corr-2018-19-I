package hu.javanetacademy.hoe.speciesspecialproperty.dao.model;

import java.util.List;
/**
  * @author sviktor75 / Szabó Viktor / vts4gv
 */

public interface SpeciesSpecialPropertyDao {
    
    public SpeciesSpecialProperty create (SpeciesSpecialProperty pSsp);
    public SpeciesSpecialProperty getById(long pSspId);
    public SpeciesSpecialProperty getByName(String pSspName);
    public SpeciesSpecialProperty delete (long specialPropertyId);
   // public void modify (long specialPropertyId); //tulajdonságonként egy-egy
    
    public List<SpeciesSpecialProperty> getBySpecies(long pSpeciesId);
}
