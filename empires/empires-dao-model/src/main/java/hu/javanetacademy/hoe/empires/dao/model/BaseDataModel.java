
package hu.javanetacademy.hoe.empires.dao.model;

/**
 *
 * @author Laptop
 */
public class BaseDataModel {
     protected String name,description;
    protected long id,level,property;
      public BaseDataModel() {
    }

    public BaseDataModel(String name, String description, long id, long level, long property) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.level = level;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    
    
}
