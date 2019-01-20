package hu.javanetacademy.hoe.ssp.dao.model;

/**
  * @author sviktor75 / Szabó Viktor / vts4gv
 */

public class SpeciesSpecialProperty {
    
    protected long id;
    protected String name;
    protected String description;
    private long speciesid;
    private int level;
    private int defense;
    private int damage;

    public SpeciesSpecialProperty() {
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

    public long getSpeciesid() {
        return speciesid;
    }

    public void setSpeciesid(long speciesid) {
        this.speciesid = speciesid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
}
