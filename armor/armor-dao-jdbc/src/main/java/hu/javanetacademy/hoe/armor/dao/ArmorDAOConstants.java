package hu.javanetacademy.hoe.armor.dao;

/**
 *
 * @author Gonda Gergely
 *
 */
public final class ArmorDAOConstants {

	public static final String TABLE_NAME_ARMOR = "armor";
	public static final String TABLE_NAME_ARMOR_HERO_XREF = "armor_hero_xref";
	public static final String TABLE_NAME_ARMOR_PROPERTIES_CODEBOOK_XREF = "armor_properties_codebook_xref";

	public static final String COLUMN_NAME_ID = "id";
	public static final String COLUMN_NAME_NAME = "name";
	public static final String COLUMN_NAME_DESCRIPTION = "description";
	public static final String COLUMN_NAME_PRICE = "price";
	public static final String COLUMN_NAME_ARMOR_ID = "armor_id";
	public static final String COLUMN_NAME_HERO_ID = "hero_id";
	public static final String COLUMN_NAME_PROPERTIES_CODEBOOK_ID = "properties_codebook_id";

	private ArmorDAOConstants() {
		// NOPE
	}
}
