package hu.javanetacademy.hoe.pets.dao.model;

/**
 * @author Heyzel (Horvath Gergely)
 */
public class Pet extends BaseDataModel {

    private long heroid;
    private int level, damage, defense;

    public Pet() {
        super();
    }

    public Pet(long heroid, int level, int damage, int defense, String name, String description, long id) {
        super(name, description, id);
        this.heroid = heroid;
        this.level = level;
        this.damage = damage;
        this.defense = defense;
    }

    public long getHeroid() {
        return heroid;
    }

    public int getLevel() {
        return level;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setHeroid(long heroid) {
        this.heroid = heroid;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
