package hu.javanetacademy.hoe.user.servece.object;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.user.dao.jdbc.UserDaoJDBCImpl;
import hu.javanetacademy.hoe.user.dao.model.User;
import hu.javanetacademy.hoe.user.dao.model.UserDao;

/**
 * @author krisztian
 */
public class UserServiceObjectImpl {
    UserDao dao = new UserDaoJDBCImpl();
    
    public User login(String pName, String pPassword){
        User user = dao.login(pName, pPassword);
        if(user!=null)
            return user;
        throw new CustomException();        
    }
    
    public User registration(String pName, String pPassword){
        User avb = dao.getbyName(pName);
        if(avb == null){
            return dao.registration(pName, pPassword);
        }    
        throw new CustomException();
    }
        
}
