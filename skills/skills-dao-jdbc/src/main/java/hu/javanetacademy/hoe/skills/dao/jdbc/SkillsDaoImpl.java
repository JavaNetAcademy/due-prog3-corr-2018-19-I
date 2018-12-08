package hu.javanetacademy.hoe.skills.dao.jdbc;

import hu.javanetacademy.hoe.skills.dao.model.ISkillsDao;
import hu.javanetacademy.hoe.skills.dao.model.Skill;
import hu.javanetacademy.hoe.skills.dao.model.SkillBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kovacs Maria
 */
public class SkillsDaoImpl implements ISkillsDao {

    private Connection con;

    public SkillsDaoImpl() {
        try {
            con = ConnectionUtil.getConnection();
        } catch (Exception e) {
            System.exit(100);
        }
    }

    @Override
    public Skill create(Skill pSkill) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO skills(name,description,offensive,valueInCombat,reqLevel) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pSkill.getName());
            ps.setString(2, pSkill.getDescription());
            ps.setBoolean(3, pSkill.isOffensive());
            ps.setLong(4, pSkill.getValueInCombat());
            ps.setLong(5, pSkill.getReqLevel());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pSkill.setId(rs.getLong(1));
                insertJobIds(rs.getLong(1), pSkill.getReqJobIds());
                return pSkill;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SkillsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Skill modify(long pOldSkillId, Skill pSkill) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE skills SET name=?,description=?,offensive=?,valueInCombat=?,reqLevel=? WHERE id=?");
            ps.setString(1, pSkill.getName());
            ps.setString(2, pSkill.getDescription());
            ps.setBoolean(3, pSkill.isOffensive());
            ps.setLong(4, pSkill.getValueInCombat());
            ps.setLong(5, pSkill.getReqLevel());
            ps.setLong(6, pOldSkillId);
            ps.executeUpdate();
            insertJobIds(pOldSkillId, pSkill.getReqJobIds());
            deleteJobIds(pOldSkillId, pSkill.getReqJobIds());
            return pSkill;
        } catch (SQLException ex) {
            Logger.getLogger(SkillsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean delete(long pSkillId) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM skills_for_job WHERE skill_id=?");
            ps.setLong(1, pSkillId);
            ps.executeUpdate();
            ps = con.prepareStatement("DELETE FROM skills WHERE id=?");
            ps.setLong(1, pSkillId);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SkillsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Skill get(long pSkillId) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT name,description,offensive,valueInCombat,reqLevel FROM skills WHERE id=?");
            ps.setLong(1, pSkillId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Skill rsSkill = new Skill();
                rsSkill.setId(pSkillId);
                rsSkill.setName(rs.getString(1));
                rsSkill.setDescription(rs.getString(2));
                rsSkill.setOffensive(rs.getBoolean(3));
                rsSkill.setValueInCombat(rs.getLong(4));
                rsSkill.setReqLevel(rs.getLong(5));
                rsSkill.setReqJobIds(getJobsById(pSkillId));
                return rsSkill;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SkillsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Skill getByName(String pName) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT skills_for_job.job_id FROM skills INNER JOIN skills_for_job ON "
                    + "skills.id=skills_for_job.skill_id where skills.name=?");
            ps.setString(1, pName);
            ResultSet rs = ps.executeQuery();
            List<Long> rsJobs = new ArrayList<>();
            while (rs.next()) {
                rsJobs.add(rs.getLong(1));
            }
            ps = con.prepareStatement("SELECT id,description,offensive,valueInCombat,reqLevel FROM skills WHERE name=?");
            ps.setString(1, pName);
            rs = ps.executeQuery();
            if (rs.next()) {
                Skill rsSkill = new Skill();
                rsSkill.setId(rs.getLong(1));
                rsSkill.setName(pName);
                rsSkill.setDescription(rs.getString(2));
                rsSkill.setOffensive(rs.getBoolean(3));
                rsSkill.setValueInCombat(rs.getLong(4));
                rsSkill.setReqLevel(rs.getLong(5));
                rsSkill.setReqJobIds(rsJobs);
                return rsSkill;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SkillsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public boolean isUsed(long pSkillId) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM skills_of_heroes WHERE skill_id=?");
            ps.setLong(1, pSkillId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getLong(1) > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SkillsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<SkillBase> availableSkils(long pHeroLevel, long pJobId) {
        List<SkillBase> rsList = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT skills.id, skills.name, skills.description,"
                    + " skills.offensive, skills.valueInCombat FROM skills INNER JOIN skills_for_job ON "
                    + "skills.id=skills_for_job.skill_id where skills_for_job.job_id=? and skills.reqLevel>=?");
            ps.setLong(1, pJobId);
            ps.setLong(2, pHeroLevel);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SkillBase rsSkill = new SkillBase();
                rsSkill.setId(rs.getLong(1));
                rsSkill.setName(rs.getString(2));
                rsSkill.setDescription(rs.getString(3));
                rsSkill.setOffensive(rs.getBoolean(4));
                rsSkill.setValueInCombat(rs.getLong(5));
                rsList.add(rsSkill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SkillsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsList;
    }

    @Override
    public List<Skill> getAll() {
        List<Skill> rsList = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id,name,description,offensive,valueInCombat,reqLevel FROM skills");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Skill rsSkill = new Skill();
                rsSkill.setId(rs.getLong(1));
                rsSkill.setName(rs.getString(2));
                rsSkill.setDescription(rs.getString(3));
                rsSkill.setOffensive(rs.getBoolean(4));
                rsSkill.setValueInCombat(rs.getLong(5));
                rsSkill.setReqLevel(rs.getLong(6));
                rsSkill.setReqJobIds(getJobsById(rs.getLong(1)));
                rsList.add(rsSkill);
            }
        } catch (Exception e) {
        }
        return rsList;
    }

    private List<Long> getJobsById(long pSkillId) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT job_id FROM skills_for_job WHERE skill_id=?");
            ps.setLong(1, pSkillId);
            ResultSet rs = ps.executeQuery();
            List<Long> rsJobs = new ArrayList<>();
            while (rs.next()) {
                rsJobs.add(rs.getLong(1));
            }
            return rsJobs;
        } catch (Exception e) {
        }
        return null;
    }

    private void insertJobIds(long pSkillId, List<Long> pJobIds) {
        try {
            StringBuilder str = new StringBuilder("INSERT IGNORE INTO skills_for_job VALUES (");
            str.append(pSkillId);
            str.append(",");
            str.append(pJobIds.get(0));
            str.append(")");
            int i = 1;
            while (i < pJobIds.size()) {
                str.append(", (");
                str.append(pSkillId);
                str.append(",");
                str.append(pJobIds.get(i));
                str.append(")");
                i++;
            }
            PreparedStatement ps = con.prepareStatement(str.toString());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SkillsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void deleteJobIds(long pSkillId, List<Long> pJobIds) {
        try {
            StringBuilder str = new StringBuilder("DELETE FROM skills_for_job WHERE job_id NOT IN (");
            str.append(pJobIds.get(0));
            int i = 1;
            while (i < pJobIds.size()) {
                str.append(",");
                str.append(pJobIds.get(i));
                i++;
            }
            str.append(") AND skill_id=");
            str.append(pSkillId);
            PreparedStatement ps = con.prepareStatement(str.toString());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SkillsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
