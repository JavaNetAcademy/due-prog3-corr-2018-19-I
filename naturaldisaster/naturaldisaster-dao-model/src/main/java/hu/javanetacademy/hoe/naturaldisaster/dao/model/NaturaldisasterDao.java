/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.naturaldisaster.dao.model;
import java.util.List;
/**
 *
 * @author Barna
 */
public interface NaturaldisasterDao {
    public Naturaldisaster create(Naturaldisaster naturaldisaster);
    public Naturaldisaster getByName(String name);
    public List<Naturaldisaster> getAll();
    public void delete(String name);
    
}
