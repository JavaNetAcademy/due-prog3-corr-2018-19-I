package hu.javanetacademy.hoe.speciesspecialproperty.service.object;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.speciesspecialproperty.dao.jdbc.SspJDBCDAOImpl;
import hu.javanetacademy.hoe.speciesspecialproperty.dao.model.SpeciesSpecialProperty;
import hu.javanetacademy.hoe.speciesspecialproperty.dao.model.SpeciesSpecialPropertyDao;
import java.util.List;

/**
 * @author sviktor75 / Szabó Viktor / vts4gv
 */
public class speciesspecialpropertyService {
    
    private SpeciesSpecialPropertyDao dao = new SspJDBCDAOImpl();
    
    public SpeciesSpecialProperty create (SpeciesSpecialProperty pNewSsp){
        if (dao.getByName(pNewSsp.getName()) != null){ //Ha létezik már ilyen nevű SpeciesSpecialProperty az adott ID-jű fajnak, akkor 
            throw new CustomException(); //hibát jelez,
        }
        else {
            dao.create(pNewSsp); //különben létrehozza.
            return null;
        }
    }
    
    public SpeciesSpecialProperty delete(long pSspId){
        return dao.delete(pSspId);
    }
    
    public SpeciesSpecialProperty getById(long pSspId){
        return dao.getById(pSspId);
    }

    public SpeciesSpecialProperty modify(long pSspId, SpeciesSpecialProperty pSsp){
        return dao.modify(pSspId, pSsp);
    }

    public List<SpeciesSpecialProperty> getSpeciesSpecialPropertyList() {
        return dao.getSpeciesSpecialPropertyList();
    }
    
    public List<SpeciesSpecialProperty> getBySpecies(long pSpeciesId){
        return dao.getBySpecies(pSpeciesId);
    }
    
    
    
    
}
