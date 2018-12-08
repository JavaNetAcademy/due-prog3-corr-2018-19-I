package hu.javanetacademy.hoe.skills.dao.model;


/**
 * @author Kovacs Maria
 */
public interface IHeroSkillsDao {

    public HeroSkill learn(HeroSkill pHeroSkill);

    public HeroSkill modifyLevel(HeroSkill pHeroSkill);

    public boolean forget(long pSkillId, long pHeroId);

    public HeroSkill get(long pSkillId, long pHeroId);
    
    public long knownLevel(long skillId, long pHeroId);

}

