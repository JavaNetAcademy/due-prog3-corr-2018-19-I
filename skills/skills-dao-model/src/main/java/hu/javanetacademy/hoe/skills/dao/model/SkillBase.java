package hu.javanetacademy.hoe.skills.dao.model;

/**
 * @author Kovacs Maria
 */
public class SkillBase {
    protected long id;
    protected String name;
    protected String description;
    protected boolean offensive;
    protected long valueInCombat;

    public SkillBase() {
    }

    public SkillBase(long id, String name, String description, boolean offensive, long valueInCombat) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.offensive = offensive;
        this.valueInCombat = valueInCombat;
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

    public boolean isOffensive() {
        return offensive;
    }

    public void setOffensive(boolean offensive) {
        this.offensive = offensive;
    }

    public long getValueInCombat() {
        return valueInCombat;
    }

    public void setValueInCombat(long valueInCombat) {
        this.valueInCombat = valueInCombat;
    }

    
}
