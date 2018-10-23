package hu.javanetacademy.hoe.armor.dao.dto;

import java.util.List;

/**
 *
 * @author Gonda Gergely
 *
 */
public class ArmorDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private List<ArmorPropertiesCodebookXrefDTO> armorPropertiesCodebookXrefs;
	private String price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<ArmorPropertiesCodebookXrefDTO> getArmorPropertiesCodebookXrefs() {
		return armorPropertiesCodebookXrefs;
	}

	public void setArmorPropertiesCodebookXrefs(List<ArmorPropertiesCodebookXrefDTO> armorPropertiesCodebookXrefs) {
		this.armorPropertiesCodebookXrefs = armorPropertiesCodebookXrefs;
	}

}
