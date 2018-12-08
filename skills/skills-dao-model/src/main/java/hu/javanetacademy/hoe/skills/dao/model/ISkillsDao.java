package hu.javanetacademy.hoe.skills.dao.model;

import java.util.List;

/**
 * @author Kovacs Maria
 */
public interface ISkillsDao {

    public Skill create(Skill pSkill);

    public Skill modify(long pOldSkillId, Skill pSkill);

    public boolean delete(long pSkillId);

    public Skill get(long pSkillId);

    public Skill getByName(String pName);

    public boolean isUsed(long pSkillId);

    public List<SkillBase> availableSkils(long pHeroLevel, long pJobId);

    public List<Skill> getAll();

}

