/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.naturaldisaster.dao.model;

/**
 *
 * @author Barna
 */
public class Naturaldisaster {

    private long id;
    private String name;
    private String description;
    private String effect;
    private String deadlyto;
    
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEffect() {
        return effect;
    }

    public String getDeadlyto() {
        return deadlyto;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public void setDeadlyto(String deadlyto) {
        this.deadlyto = deadlyto;
    }   
    
    
}
