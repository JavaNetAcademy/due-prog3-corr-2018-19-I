
package hu.javanetacademy.hoe.empires.dao.model;

/**
 *
 * @author Laptop
 */
public class Empires extends BaseDataModel{
    private long userid;
    
 public Empires() {
         super();
    }

      public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }
    
}
