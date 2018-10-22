package hu.javanetacademy.hoe.armor.dao.entity;

public class ArmorPropertiesCodebookXref extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long armorId;
	private Long propertiesCodebookId;

	public Long getArmorId() {
		return armorId;
	}

	public void setArmorId(Long armorId) {
		this.armorId = armorId;
	}

	public Long getPropertiesCodebookId() {
		return propertiesCodebookId;
	}

	public void setPropertiesCodebookId(Long propertiesCodebookId) {
		this.propertiesCodebookId = propertiesCodebookId;
	}

}
