package hu.javanetacademy.hoe.factories.dao.model;

/**
 * @author jrajmund
 */
public class Factories extends BaseDataModel {

    private long empireid, userid;

    public Factories() {
        super();
    }

    public long getEmpireid() {
        return empireid;
    }

    public void setEmpireid(long empireid) {
        this.empireid = empireid;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }
    
}
