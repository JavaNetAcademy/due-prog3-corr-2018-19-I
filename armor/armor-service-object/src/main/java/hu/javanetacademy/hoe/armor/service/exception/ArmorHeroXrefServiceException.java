package hu.javanetacademy.hoe.armor.service.exception;

/**
 *
 * @author Gonda Gergely
 *
 */
public class ArmorHeroXrefServiceException extends RuntimeException {

	private static final long serialVersionUID = -2873424644693665068L;

	public ArmorHeroXrefServiceException() {
		super();
	}

	public ArmorHeroXrefServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ArmorHeroXrefServiceException(String message) {
		super(message);
	}

	public ArmorHeroXrefServiceException(Throwable cause) {
		super(cause);
	}

}
