package hu.javanetacademy.hoe.speciesspecialproperty.service.object;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.speciesspecialproperty.dao.jdbc.SspJDBCDAOImpl;

import hu.javanetacademy.hoe.speciesspecialproperty.dao.model.SpeciesSpecialProperty;

import java.util.List;
import hu.javanetacademy.hoe.speciesspecialproperty.dao.model.SpeciesSpecialPropertyDao;

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
            return dao.create(pNewSsp); //különben létrehozza.
        }
    }
    
    public SpeciesSpecialProperty delete(long pSspId){
        return dao.delete(pSspId);
    }
    
    public SpeciesSpecialProperty getById(long pSspId){
        return dao.getById(pSspId);
    }
    
    public List<SpeciesSpecialProperty> getBySpecies(long pSpeciesId){
        return dao.getBySpecies(pSpeciesId);
    }
    /*
    public PropertyLevelAttribute modify(long pSspId){
        return dao.modify(pSspId);
    }
    */
    
    
}
