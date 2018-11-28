/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.species.model;

/**
 *
 * @author gotriang
 */
public class SpeciesxHero  {
    protected long id,heroid,speciesid;
  

    public SpeciesxHero() {
    }

    public SpeciesxHero(long id, long heroid, long speciesid) {
         this.id = id;
        this.heroid = heroid;
        this.speciesid = speciesid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHeroId() {
        return heroid;
    }

    public void setHeroId(long heroid) {
        this.heroid = heroid;
    }

    public long getSpeciesId() {
        return speciesid;
    }

    public void setSpeciesId(long speciesid) {
        this.speciesid = speciesid;
    }
    }