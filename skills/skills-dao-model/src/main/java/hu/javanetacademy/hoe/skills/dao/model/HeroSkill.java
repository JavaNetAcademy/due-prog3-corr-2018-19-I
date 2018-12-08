package hu.javanetacademy.hoe.skills.dao.model;

/**
 * @author Kovacs Maria
 */
public class HeroSkill extends SkillBase{
    private long skillLevel;
    private long heroId;

    public HeroSkill() {
        super();
    }

    public HeroSkill(long skillLevel, long heroId, long id, String name, String description, boolean offensive, long valueInCombat) {
        super(id, name, description, offensive, valueInCombat);
        this.skillLevel = skillLevel;
        this.heroId = heroId;
    }

    public long getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(long skillLevel) {
        this.skillLevel = skillLevel;
    }

    public long getHeroId() {
        return heroId;
    }

    public void setHeroId(long heroId) {
        this.heroId = heroId;
    }    
}
