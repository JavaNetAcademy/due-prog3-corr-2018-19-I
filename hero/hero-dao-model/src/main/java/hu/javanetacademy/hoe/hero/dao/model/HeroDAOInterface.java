package hu.javanetacademy.hoe.hero.dao.model;

import java.util.List;

/**
 * @author krisztian
 */
public interface HeroDAOInterface {

public Hero create(Hero pHero);
public Hero modify(long pOldHeroId, Hero pNewHero);
public Hero delete(long pHeroId);

public Hero get(long pHeroId);
public List<Hero> getByUser(long pUserId);
public Hero getByNameFromUser(String pHeroName, long pUserId);

}
