package hu.javanetacademy.hoe.skills.sercice.object;

import hu.javanetacademy.hoe.skills.dao.jdbc.SkillsDaoImpl;
import hu.javanetacademy.hoe.skills.dao.model.ISkillsDao;
import hu.javanetacademy.hoe.skills.dao.model.Skill;
import hu.javanetacademy.hoe.skills.dao.model.SkillBase;
import hu.javanetacademy.hoe.skills.sercice.object.exceptions.SkillErrors;
import hu.javanetacademy.hoe.skills.sercice.object.exceptions.SkillsException;
import java.util.List;

/**
 * @author Kovacs Maria
 */
public class SkillsServiceImpl {

    private ISkillsDao dao = new SkillsDaoImpl();

    public Skill create(Skill pSkill) {
        if (pSkill.getName() == null || pSkill.getName().isEmpty()) {
            throw new SkillsException(SkillErrors.NO_NAME);
        }
         if (dao.getByName(pSkill.getName()) != null) {                   
            throw new SkillsException(SkillErrors.USED_NAME);
        }
        if (pSkill.getValueInCombat() <= 0) {
            throw new SkillsException(SkillErrors.NO_COMBAT_VALUE);
        }
        if (pSkill.getReqLevel() <= 0) {
            throw new SkillsException(SkillErrors.NO_REQ_LEVEL);
        }       
        if (pSkill.getReqJobIds().isEmpty()) {
            throw new SkillsException(SkillErrors.NO_JOB);           
        }else{
            return dao.create(pSkill);
        }
    }

    public Skill modify(long pOldSkillId, Skill pSkill) {
        if (pSkill.getName() == null || pSkill.getName().isEmpty()) {
            throw new SkillsException(SkillErrors.NO_NAME);
        }
        Skill temp = dao.getByName(pSkill.getName());
        if (temp != null && !temp.getName().equals(dao.get(pOldSkillId).getName())) {         
            throw new SkillsException(SkillErrors.USED_NAME);
        }  
        if (pSkill.getValueInCombat() <= 0) {
            throw new SkillsException(SkillErrors.NO_COMBAT_VALUE);
        }
        if (pSkill.getReqLevel() <= 0) {
            throw new SkillsException(SkillErrors.NO_REQ_LEVEL);
        }              
        if (pSkill.getReqJobIds().isEmpty()) {
            throw new SkillsException(SkillErrors.NO_JOB);
        }else{
             return dao.modify(pOldSkillId, pSkill);
        }                
    }

    public boolean delete(long pSkillId) {
        if (!dao.isUsed(pSkillId)) {
            return dao.delete(pSkillId);
        } else {
            throw new SkillsException(SkillErrors.USED_BY_HERO);
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

    public List<SkillBase> availableSkills(long pHeroId, long pHeroLevel, long pJobId) {
        return dao.availableSkils(pHeroId, pHeroLevel, pJobId);
    }

    public List<Skill> getAll() {
        return dao.getAll();
    }

    public List<SkillBase> notUsedByHero(long pHeroId) {
        return dao.notUsedByHero(pHeroId);
    }
}
