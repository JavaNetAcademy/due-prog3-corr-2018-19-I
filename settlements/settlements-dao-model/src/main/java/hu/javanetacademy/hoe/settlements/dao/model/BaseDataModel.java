
package hu.javanetacademy.hoe.settlements.dao.model;

/**
 *
 * @author Prototype_ (Szabó Zoltán)
 */
public class BaseDataModel {
    protected long id;
    protected String name,description;

    public BaseDataModel() {
    }

    public BaseDataModel(long id, long empireid, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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
    
    
}
