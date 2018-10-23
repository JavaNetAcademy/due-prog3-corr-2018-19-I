package hu.javanetacademy.hoe.armor.dao.entity;

/**
 *
 * @author Gonda Gergely
 *
 */
public class Armor extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private Long price;

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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

}
