package hu.javanetacademy.hoe.ssp.dao.model;

/**
 *
 * @author user
 */
public class Ssp extends BaseDataModel{

    private long speciesid;
    private int level, damage, defense;

    public Ssp() {
        super();
    }

    public Ssp(long speciesid, int level, int damage, int defense, long id, String name, String description) {
        super(id, name, description);
        this.speciesid = speciesid;
        this.level = level;
        this.damage = damage;
        this.defense = defense;
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    
    
}
