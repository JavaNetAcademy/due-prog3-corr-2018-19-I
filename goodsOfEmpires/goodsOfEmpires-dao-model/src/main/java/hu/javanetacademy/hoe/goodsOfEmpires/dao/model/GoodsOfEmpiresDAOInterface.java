package hu.javanetacademy.hoe.goodsOfEmpires.dao.model;

import java.util.List;

/**
 * @author adam
 */
public interface GoodsOfEmpiresDAOInterface {

public GoodsOfEmpires create(GoodsOfEmpires pGoodsOfEmpires);
public GoodsOfEmpires modify(long pOldGoodsOfEmpiresId, GoodsOfEmpires pNewGoodsOfEmpires);
public GoodsOfEmpires delete(long pGoodsOfEmpiresId);

public GoodsOfEmpires get(long pGoodsOfEmpiresId);
public List<GoodsOfEmpires> getByUser(long pUserId);
public GoodsOfEmpires getByNameFromUser(String pGoodsOfEmpiresName, long pUserId);

}
