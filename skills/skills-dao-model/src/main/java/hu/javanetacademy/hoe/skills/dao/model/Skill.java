package hu.javanetacademy.hoe.skills.dao.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kovacs Maria
 */
public class Skill extends SkillBase{
    
    private long reqLevel;
    private List<Long> reqJobIds = new ArrayList<>();

    public Skill() {
        super();
    }

    public Skill(long id, String name, String description, boolean offensive, long valueInCombat, long reqLevel, List<Long> reqJobIds) {
        super(id, name, description, offensive, valueInCombat);
        this.reqLevel = reqLevel;
        this.reqJobIds = reqJobIds;
    }

    public long getReqLevel() {
        return reqLevel;
    }

    public void setReqLevel(long reqLevel) {
        this.reqLevel = reqLevel;
    }

    public List<Long> getReqJobIds() {
        return reqJobIds;
    }

    public void setReqJobIds(List<Long> reqJobIds) {
        this.reqJobIds = reqJobIds;
    }
    
    public boolean isAvailableForLevel(long pHeroLevel) {
        return this.reqLevel <= pHeroLevel;
    }

    public boolean isAvailableForJob(long pJobId) {
        return this.reqJobIds.contains(pJobId);
    }
    
}