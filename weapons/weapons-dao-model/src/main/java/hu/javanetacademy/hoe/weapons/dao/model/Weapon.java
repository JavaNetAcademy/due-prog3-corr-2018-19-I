package hu.javanetacademy.hoe.weapons.dao.model;

/**
 *
 * @author Richard
 */
public class Weapon {
    private long id;
    private String name;
    private String description;
    private long heroid;
    
    public Weapon() {
        
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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

    public long getHeroid() {
        return heroid;
    }

    public void setHeroid(long heroid) {
        this.heroid = heroid;
    }
    
    
}
