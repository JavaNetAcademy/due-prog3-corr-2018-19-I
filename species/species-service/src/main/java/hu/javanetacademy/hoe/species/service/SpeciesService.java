package hu.javanetacademy.hoe.species.service;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.species.jdbc.SpeciesJDBC;
import hu.javanetacademy.hoe.species.model.Species;
import hu.javanetacademy.hoe.species.model.SpeciesxHero;
import hu.javanetacademy.hoe.hero.dao.model.Hero;
import java.util.List;

/**
 * @author gotriang
 */
public class SpeciesService {
  
    private SpeciesJDBC dao = new SpeciesJDBC();

    
    public Species create(Species pSpecies) {
        boolean exists = dao.existsByName(pSpecies.getName());
        if (exists == false) {
            return dao.create(pSpecies);
        } else {
            throw new CustomException();
        }
    }

    
    public Species modify(long pSpeciesId, Species pSpecies, String originalSpeciesName) {
         boolean exists = false;
        String speciesName = pSpecies.getName(); // ha if-en belül species.getName()-et hívtam nem működik jól
        
        // ha csak description-t frissítünk nem kell vizsgálni, hogy létezik-e már a név
        if (!speciesName.equals(originalSpeciesName)) {
            exists = dao.existsByName(pSpecies.getName());
        }
        
        if (exists == false) {
            return dao.modify(pSpeciesId, pSpecies, originalSpeciesName);
        } else {
            throw new CustomException();
        }
    }
    
     public Species delete(long pSpeciesId) {
        return dao.delete(pSpeciesId);
    }

    
    public Species get(long pSpeciesId) {
        return dao.get(pSpeciesId);
    }

    
    public List<Hero> getHeroList(long pSpeciesId) {
        return dao.getHeroList(pSpeciesId);
    }
    
    public List<Species> getSpeciesList() {
        return dao.getSpeciesList();
    }

    
    public SpeciesxHero createconnector(SpeciesxHero pSpeciesxHero) {
      
            return dao.createconnector(pSpeciesxHero);
       
    }

    
    public SpeciesxHero modifyconnector(long pSpeciesxHeroId, SpeciesxHero pSpeciesxHero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public SpeciesxHero deleteconnector(long pSpeciesxHeroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public SpeciesxHero getconnector(long pHeroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public boolean existsByName(String pSpeciesName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public boolean existsByHeroId(String pHeroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
