/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.ssp.service.object;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.ssp.dao.jdbc.SspJDBCDAOImpl;
import hu.javanetacademy.hoe.ssp.dao.model.SspDAOInterface;
import hu.javanetacademy.hoe.ssp.dao.model.Ssp;

import java.util.List;

/**
 *
 * @author user
 */
public class SspService {
    
    private SspDAOInterface dao = new SspJDBCDAOImpl();
    
    public Ssp create (Ssp pNewSsp){
        if (dao.existByName(pNewSsp.getName(),pNewSsp.getSpeciesid())){ //Ha létezik már ilyen nevű ssp az adott ID-jű fajnak, akkor 
            throw new CustomException(); //hibát jelez,
        }
        else {
            return dao.create(pNewSsp); //különben létrehozza.
        }
    }
    
    public Ssp delete(long sspId){
        return dao.delete(sspId);
    }
    
    public Ssp get(long pSspId){
        return dao.get(pSspId);
    }
    
    public List<Ssp> getFroSpecies(long pSpeciesId){
        return dao.getForSpecies(pSpeciesId);
    }
    
    public Ssp modify(long pSspId){
        return dao.modify(pSspId);
    }
    
    
    
}
