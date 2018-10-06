package hu.javanetacademy.hoe.user.dao.model;

/**
 * @author krisztian
 */
public interface UserDao {
    
    public User login(String pName, String pPassword);
    public User getbyName(String pName);
    public User registration(String pName, String pPassword);
    
}
