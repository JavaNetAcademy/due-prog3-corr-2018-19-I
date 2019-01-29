package hu.javanetacademy.hoe.armor.dao.dto;

import hu.javanetacademy.hoe.base.model.PropertiesCodebook;

public class ArmorPropertiesCodebookXrefDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	private ArmorDTO armor;
	private PropertiesCodebook propertiesCodebook;

	public ArmorDTO getArmor() {
		return armor;
	}

	public void setArmor(ArmorDTO armor) {
		this.armor = armor;
	}

	public PropertiesCodebook getPropertiesCodebook() {
		return propertiesCodebook;
	}

	public void setPropertiesCodebook(PropertiesCodebook propertiesCodebook) {
		this.propertiesCodebook = propertiesCodebook;
	}

	@Override
	public String toString() {
		return "ArmorPropertiesCodebookXrefDTO [armor=" + armor + ", propertiesCodebook=" + propertiesCodebook + "]";
	}

}
