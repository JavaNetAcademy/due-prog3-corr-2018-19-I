package hu.javanetacademy.hoe.skills.sercice.object;

import hu.javanetacademy.hoe.skills.dao.jdbc.SkillsDaoImpl;
import hu.javanetacademy.hoe.skills.dao.model.ISkillsDao;
import hu.javanetacademy.hoe.skills.dao.model.Skill;
import hu.javanetacademy.hoe.skills.dao.model.SkillBase;
import hu.javanetacademy.hoe.skills.sercice.object.exceptions.NoJobForSkillException;
import hu.javanetacademy.hoe.skills.sercice.object.exceptions.NoNameForSkillException;
import hu.javanetacademy.hoe.skills.sercice.object.exceptions.NoRequiredLevelException;
import hu.javanetacademy.hoe.skills.sercice.object.exceptions.NoValueInCombatException;
import hu.javanetacademy.hoe.skills.sercice.object.exceptions.UsedByHeroException;
import hu.javanetacademy.hoe.skills.sercice.object.exceptions.UsedSkillNameException;
import java.util.List;

/**
 * @author Kovacs Maria
 */
public class SkillsServiceImpl {
    
    private ISkillsDao dao = new SkillsDaoImpl();
    
    public Skill create(Skill pSkill) {
        if (pSkill.getName() == null || pSkill.getName().isEmpty()) {
            throw new NoNameForSkillException("A nevet nem lehet kihagyni.");
        }   
        if (pSkill.getReqJobIds().isEmpty()) {
            throw new NoJobForSkillException("Legalább egy foglalkozást hozzá kell rendelni.");
        }
        if (pSkill.getValueInCombat()<=0) {
            throw new NoValueInCombatException("A hatás nagyobb, mint 0");
        }
        if (pSkill.getReqLevel()<=0) {
            throw new NoRequiredLevelException("A hősszint nagyobb, mint 0");
        }                
        Skill temp = dao.getByName(pSkill.getName());
        if (temp == null) {
            return dao.create(pSkill);
        } else {
            throw new UsedSkillNameException("Van mar ilyen nevű képesség.");
        }
        
        
    }
    public Skill modify(long pOldSkillId, Skill pSkill) {
        if (pSkill.getName() == null || pSkill.getName().isEmpty()) {
            throw new NoNameForSkillException("A nevet nem lehet kihagyni.");
        }
        if (pSkill.getReqJobIds().isEmpty()) {
            throw new NoJobForSkillException("Legalább egy foglalkozást hozzá kell rendelni.");
        }
        if (pSkill.getValueInCombat()<=0) {
            throw new NoValueInCombatException("A hatás nagyobb, mint 0");
        }
        if (pSkill.getReqLevel()<=0) {
            throw new NoRequiredLevelException("A hősszint nagyobb, mint 0");
        }   
        Skill temp = dao.getByName(pSkill.getName());
        if (temp == null || temp.getName().equals(dao.get(pOldSkillId).getName())) {
            return dao.modify(pOldSkillId, pSkill);
        } else {
            throw new UsedSkillNameException("Van mar ilyen nevű képesség.");
        }
    }
    
    public boolean delete(long pSkillId) {
        if (!dao.isUsed(pSkillId)) {
            return dao.delete(pSkillId);
        } else {
            throw new UsedByHeroException("Használja már egy hős.");
        }
        
    }
    
    public Skill get(long pSkillId) {
        return dao.get(pSkillId);
    }
    
    public Skill getByName(String pName) {
        return dao.getByName(pName);
    }
    
    public boolean isUsed(long pSkillId) {
        return dao.isUsed(pSkillId);
    }
    
    public List<SkillBase> availableSkils(long pHeroLevel, long pJobId) {
        return dao.availableSkils(pHeroLevel, pJobId);
    }
    
    public List<Skill> getAll() {
        return dao.getAll();
    }
}

