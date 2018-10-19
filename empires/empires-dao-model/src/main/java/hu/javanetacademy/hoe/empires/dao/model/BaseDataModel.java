/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javanetacademy.hoe.empires.dao.model;

/**
 *
 * @author Laptop
 */
public class BaseDataModel {
    
    protected long id,userid,level,property;
   protected String name,description;
   
   public BaseDataModel() {
	}
   

    public BaseDataModel(long id, long userid, long level, String name, String description) {
        this.id = id;
        this.userid = userid;
        this.level = level;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public long getProperty() {
        return property;
    }

    public void setProperty(long property) {
        this.property = property;
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
