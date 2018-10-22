package hu.javanetacademy.hoe.armor.dao.dto;

import hu.javanetacademy.hoe.hero.dao.model.Hero;

public class ArmorHeroXrefDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private ArmorDTO armor;
	private Hero hero;

	public ArmorDTO getArmor() {
		return armor;
	}

	public void setArmor(ArmorDTO armor) {
		this.armor = armor;
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

}
