package hu.javanetacademy.hoe.base.model;

public class PropertiesCodebook {

	private Long id;
	private String code;
	private String name;
	private String description;
	private Long offensiveValue;
	private Long defensive_value;
	private Long dexterity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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

	public Long getOffensiveValue() {
		return offensiveValue;
	}

	public void setOffensiveValue(Long offensiveValue) {
		this.offensiveValue = offensiveValue;
	}

	public Long getDefensive_value() {
		return defensive_value;
	}

	public void setDefensive_value(Long defensive_value) {
		this.defensive_value = defensive_value;
	}

	public Long getDexterity() {
		return dexterity;
	}

	public void setDexterity(Long dexterity) {
		this.dexterity = dexterity;
	}

}
