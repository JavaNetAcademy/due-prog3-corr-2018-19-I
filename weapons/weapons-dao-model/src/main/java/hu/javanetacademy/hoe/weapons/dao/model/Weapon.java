package hu.javanetacademy.hoe.weapons.dao.model;

/**
 *
 * @author Richard
 */
public class Weapon {
    private long id;
    private String name;
    private String description;
    private int price;
    private long userid;
    
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getUserId() {
        return userid;
    }

    public void setUserId(long userid) {
        this.userid = userid;
    }
    
    
}
