package hu.javanetacademy.hoe.factories.dao.model;

/**
 * @author jrajmund
 */
public class BaseDataModel {

    protected String name, description;
    protected long id;

    public BaseDataModel() {
    }

    public BaseDataModel(String name, String description, long id) {
        this.name = name;
        this.description = description;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
