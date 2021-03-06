package hu.javanetacademy.hoe.hero.service.object;

import java.util.List;

import hu.javanetacademy.hoe.base.util.CustomException;
import hu.javanetacademy.hoe.hero.dao.file.HeroJDBCDAOImpl;
import hu.javanetacademy.hoe.hero.dao.model.Hero;
import hu.javanetacademy.hoe.hero.dao.model.HeroDAOInterface;
import hu.javanetacademy.hoe.job.model.JobxHero;
import hu.javanetacademy.hoe.job.service.JobService;
import hu.javanetacademy.hoe.species.model.SpeciesxHero;
import hu.javanetacademy.hoe.species.service.SpeciesService;

/**
 * @author krisztian
 */
public class HeroService {
	private final HeroDAOInterface dao = new HeroJDBCDAOImpl();

	public Hero create(Hero pNewHero, JobxHero pJobxHero, SpeciesxHero pSpeciesxHero) {
		Hero avb = dao.getByNameFromUser(pNewHero.getName(), pNewHero.getUserid());

		if (avb == null) {
			dao.create(pNewHero);
			long heroid = pNewHero.getId();
			pJobxHero.setHeroId(heroid);
			JobService jobdao = new JobService();
			jobdao.createconnector(pJobxHero);

			pSpeciesxHero.setHeroId(heroid);
			SpeciesService speciesdao = new SpeciesService();
			speciesdao.createconnector(pSpeciesxHero);
			return pNewHero;
		} else {
			throw new CustomException();
		}
	}

	public List<Hero> getHeroByUser(long pUserId) {
		return dao.getByUser(pUserId);
	}

	public Hero get(long heroid) {
		return dao.get(heroid);
	}

	public Hero modify(long pHeroId, Hero pHero) {
		return dao.modify(pHeroId, pHero);
	}

	public Hero delete(long pHeroId) {
		return dao.delete(pHeroId);
	}
}
