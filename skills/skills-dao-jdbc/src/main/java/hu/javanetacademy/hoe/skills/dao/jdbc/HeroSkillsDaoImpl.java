package hu.javanetacademy.hoe.skills.dao.jdbc;

import hu.javanetacademy.hoe.skills.dao.model.HeroSkill;
import hu.javanetacademy.hoe.skills.dao.model.IHeroSkillsDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kovacs Maria
 */
public class HeroSkillsDaoImpl implements IHeroSkillsDao{
    private Connection con;

    public HeroSkillsDaoImpl() {
        try {
            con = ConnectionUtil.getConnection();
        } catch (Exception e) {
            System.exit(100);
        }
    }
    
    @Override
    public HeroSkill learn(HeroSkill pHeroSkill) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO skills_of_heroes(skill_id,hero_id,skill_level) VALUES(?,?,?)");
            ps.setLong(1, pHeroSkill.getId());
            ps.setLong(2, pHeroSkill.getHeroId());
            ps.setLong(3, pHeroSkill.getSkillLevel());
            if (ps.executeUpdate() > 0) {
                return pHeroSkill;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HeroSkillsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public HeroSkill modifyLevel(HeroSkill pHeroSkill) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE skills_of_heroes SET skill_level=? WHERE skill_id=? AND hero_id=?");
            ps.setLong(1, pHeroSkill.getSkillLevel());
            ps.setLong(2, pHeroSkill.getId());
            ps.setLong(3, pHeroSkill.getHeroId());
            if (ps.executeUpdate() > 0) {
                return pHeroSkill;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HeroSkillsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean forget(long pSkillId, long pHeroId) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM skills_of_heroes WHERE skill_id=? AND hero_id=?");
            ps.setLong(1, pSkillId);
            ps.setLong(2, pHeroId);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SkillsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public HeroSkill get(long pSkillId, long pHeroId) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT skills.id, skills.name, skills.description, "
                    + "skills.offensive, skills.valueInCombat, skills_of_heroes.skill_level, skills_of_heroes.hero_id "
                    + "FROM skills INNER JOIN skills_of_heroes ON skills.id=skills_of_heroes.skill_id where skills.id=? "
                    + "AND skills_of_heroes.hero_id=?");
            ps.setLong(1, pSkillId);
            ps.setLong(2, pHeroId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                HeroSkill rsSkill = new HeroSkill();
                rsSkill.setId(pSkillId);
                rsSkill.setName(rs.getString(2));
                rsSkill.setDescription(rs.getString(3));
                rsSkill.setOffensive(rs.getBoolean(4));
                rsSkill.setValueInCombat(rs.getLong(5));
                rsSkill.setSkillLevel(rs.getLong(6));
                rsSkill.setHeroId(pHeroId);
                return rsSkill;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SkillsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public long knownLevel(long skillId, long pHeroId){
        try {
            PreparedStatement ps = con.prepareStatement("SELECT skill_level FROM skills_of_heroes WHERE skill_id=? AND hero_id=?");
            ps.setLong(1, skillId);
            ps.setLong(2, pHeroId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getLong(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HeroSkillsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}

