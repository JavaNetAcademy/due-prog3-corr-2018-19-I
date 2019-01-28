/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.naturaldisaster.service;

/**
 *
 * @author Barna
 */
import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.naturaldisaster.dao.jdbc.NaturaldisasterDaoJDBC;
import hu.javanetacademy.hoe.naturaldisaster.dao.model.Naturaldisaster;
import hu.javanetacademy.hoe.naturaldisaster.dao.model.NaturaldisasterDao;
import java.util.List;

public class NaturaldisasterService {
    private NaturaldisasterDao dao = new NaturaldisasterDaoJDBC();
    
     public Naturaldisaster create(Naturaldisaster naturaldisaster) {
        Naturaldisaster existing = dao.getByName(naturaldisaster.getName());
        if (existing == null) {
            return dao.create(naturaldisaster);
        }
        throw new CustomException();
        //FIX ME?
        //Probably not properly workin
    }

    public List<Naturaldisaster> getAll() {
        return dao.getAll();
    }
    
     public Naturaldisaster getbyId(String name){
         return dao.getByName(name);
       }
    
}
