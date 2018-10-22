package hu.javanetacademy.hoe.armor.dao.entity;

public class ArmorHeroXref extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long armorId;
	private Long heroId;

	public Long getArmorId() {
		return armorId;
	}

	public void setArmorId(Long armorId) {
		this.armorId = armorId;
	}

	public Long getHeroId() {
		return heroId;
	}

	public void setHeroId(Long heroId) {
		this.heroId = heroId;
	}

}
