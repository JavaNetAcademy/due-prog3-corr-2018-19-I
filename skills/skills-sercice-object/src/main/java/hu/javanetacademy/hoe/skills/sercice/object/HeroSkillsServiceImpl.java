package hu.javanetacademy.hoe.skills.sercice.object;

import hu.javanetacademy.hoe.skills.dao.jdbc.HeroSkillsDaoImpl;
import hu.javanetacademy.hoe.skills.dao.model.HeroSkill;
import hu.javanetacademy.hoe.skills.dao.model.IHeroSkillsDao;
import hu.javanetacademy.hoe.skills.sercice.object.exceptions.SkillErrors;
import hu.javanetacademy.hoe.skills.sercice.object.exceptions.SkillsException;
import java.util.List;

/**
 * @author Kovacs Maria
 */
public class HeroSkillsServiceImpl {

    private IHeroSkillsDao dao = new HeroSkillsDaoImpl();

    public HeroSkill learn(HeroSkill pHeroSkill) {
        if (dao.get(pHeroSkill.getId(), pHeroSkill.getHeroId()) == null) {
            return dao.learn(pHeroSkill);
        } else {
            throw new SkillsException(SkillErrors.ALRAEDY_KNOWN);
        }
    }

    public HeroSkill modifyLevel(HeroSkill pHeroSkill) {
        if (dao.get(pHeroSkill.getId(), pHeroSkill.getHeroId()) != null) {
            return dao.modifyLevel(pHeroSkill);
        } else {
            throw new SkillsException(SkillErrors.NOT_KNOWN);
        }
    }

    public boolean forget(long pSkillId, long pHeroId) {
        if (dao.get(pSkillId, pHeroId) != null) {
            return dao.forget(pSkillId, pHeroId);
        } else {
            throw new SkillsException(SkillErrors.NOT_KNOWN);
        }                
    }

    public HeroSkill get(long pSkillId, long pHeroId) {
        HeroSkill temp = dao.get(pSkillId, pHeroId);
        if (temp != null) {
            return temp;
        } else {
            throw new SkillsException(SkillErrors.NOT_KNOWN);
        }
    }

    public List<HeroSkill> skillsByHero(long pHeroId) {
        return dao.skillsByHero(pHeroId);

    }
}
