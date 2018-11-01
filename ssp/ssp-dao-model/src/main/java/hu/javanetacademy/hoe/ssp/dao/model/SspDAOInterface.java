package hu.javanetacademy.hoe.ssp.dao.model;

import java.util.List;
/**
 *
 * @author user
 */
public interface SspDAOInterface {
    
    public Ssp create(Ssp pSsp);
    public Ssp get (long SspId);
    public Ssp delete (long SspId);
    public Ssp modify (long pOldSspId, Ssp pNewSsp);
    
    public List<Ssp> getForSpecies(long pSpeciesId);
    
    public boolean existByName(String pSspName, long pSpeciesId);
    
}
