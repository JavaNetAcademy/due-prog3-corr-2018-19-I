package hu.javanetacademy.hoe.goodsOfEmpires.service.object;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.goodsOfEmpires.dao.file.GoodsOfEmpiresJDBCDAOImpl;
import hu.javanetacademy.hoe.goodsOfEmpires.dao.model.GoodsOfEmpires;
import hu.javanetacademy.hoe.goodsOfEmpires.dao.model.GoodsOfEmpiresDAOInterface;

import java.util.List;

/**
 * @author adam
 */
public class GoodsOfEmpiresService {
   private GoodsOfEmpiresDAOInterface dao= new GoodsOfEmpiresJDBCDAOImpl();
   
   public GoodsOfEmpires create(GoodsOfEmpires pNewGoodsOfEmpires){
       GoodsOfEmpires avb = dao.getByNameFromUser(pNewGoodsOfEmpires.getName(), pNewGoodsOfEmpires.getGoodid());
       if(avb==null)
        return dao.create(pNewGoodsOfEmpires);
       else 
           throw new CustomException();
   }
   
   public List<GoodsOfEmpires> getGoodsOfEmpiresByUser(long pUserId){
       return dao.getByUser(pUserId);
   }
   
   public GoodsOfEmpires get(long goodsOfEmpiresid) {
       return dao.get(goodsOfEmpiresid);
   }
}
