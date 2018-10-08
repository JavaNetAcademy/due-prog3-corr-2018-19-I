/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.specfajkepesseg.dao.model;

/**
 *
 * @author user
 */
public class sfk {
    
    private long id;
    private String name;
    private String description;


    public sfk() {
    }

    public sfk(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
    
    
}
