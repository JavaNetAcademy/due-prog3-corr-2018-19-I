package hu.javanetacademy.hoe.pets.dao.model;

/**
 * @author Heyzel (Horvath Gergely)
 */
public class Pet extends BaseDataModel {

    private long heroid;

    public Pet() {
        super();
    }

    public long getHeroid() {
        return heroid;
    }

    public void setHeroid(long heroid) {
        this.heroid = heroid;
    }
}
