package hu.javanetacademy.hoe.armor.dao.exception;

public class ArmorHeroXrefDAOException extends RuntimeException {

	private static final long serialVersionUID = -2873424644693665068L;

	public ArmorHeroXrefDAOException() {
		super();
	}

	public ArmorHeroXrefDAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public ArmorHeroXrefDAOException(String message) {
		super(message);
	}

	public ArmorHeroXrefDAOException(Throwable cause) {
		super(cause);
	}

}
