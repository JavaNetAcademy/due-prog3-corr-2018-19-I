package hu.javanetacademy.hoe.vehicles.dao.model;

/**
 *
 * @author jbasiszta
 */
public class Vehicle {
    private long id;
    private String name;
    private String description;
    private long avgSpeed;
    private long maxSpeed;
    private long maxSpeedTimeout;
    private long maxLoad;
    private long crew;
    private long price;
    
    public Vehicle() {
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

    public long getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(long avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public long getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(long maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public long getMaxSpeedTimeout() {
        return maxSpeedTimeout;
    }

    public void setMaxSpeedTimeout(long maxSpeedTimeout) {
        this.maxSpeedTimeout = maxSpeedTimeout;
    }

    public long getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(long maxLoad) {
        this.maxLoad = maxLoad;
    }

    public long getCrew() {
        return crew;
    }

    public void setCrew(long crew) {
        this.crew = crew;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
    
    
}
