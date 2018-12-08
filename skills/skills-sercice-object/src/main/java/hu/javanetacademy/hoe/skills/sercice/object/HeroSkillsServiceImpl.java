package hu.javanetacademy.hoe.skills.sercice.object;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.skills.dao.jdbc.HeroSkillsDaoImpl;
import hu.javanetacademy.hoe.skills.dao.model.HeroSkill;
import hu.javanetacademy.hoe.skills.dao.model.IHeroSkillsDao;

/**
 * @author Kovacs Maria
 */
public class HeroSkillsServiceImpl {
    
   private IHeroSkillsDao dao = new HeroSkillsDaoImpl();
   
    public HeroSkill learn(HeroSkill pHeroSkill) {
        HeroSkill temp = dao.learn(pHeroSkill);
        if (temp != null) {
            return temp;
        } else {
            throw new CustomException();
        }
    }

    public HeroSkill modifyLevel(HeroSkill pHeroSkill) {
        long temp = dao.knownLevel(pHeroSkill.getId(), pHeroSkill.getHeroId());
        if (temp > 0) {
            return dao.modifyLevel(pHeroSkill);
        } else {
            throw new CustomException();
        }
    }
        
    public boolean forget(long pSkillId, long pHeroId) {
        return dao.forget(pSkillId, pHeroId);
    }

    public HeroSkill get(long pSkillId, long pHeroId) {
        HeroSkill temp = dao.get(pSkillId, pHeroId);
        if (temp != null) {
            return temp;
        } else {
            throw new CustomException();
        }
    }

    public long knownLevel(long skillId, long pHeroId){
        return dao.knownLevel(skillId, pHeroId);
    }
    
}

