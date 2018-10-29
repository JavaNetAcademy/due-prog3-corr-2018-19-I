package hu.javanetacademy.hoe.settlements.dao.model;

/**
 *
 * @author Prototype_ (Szabó Zoltán)
 */
public class Settlements extends BaseDataModel{
    private long empireid;

    public Settlements() {
        super();
    }

    
    public long getEmpireid() {
        return empireid;
    }

    public void setEmpireid(long empireid) {
        this.empireid = empireid;
    }
    
    
}
