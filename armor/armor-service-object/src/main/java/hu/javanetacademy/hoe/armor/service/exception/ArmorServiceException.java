package hu.javanetacademy.hoe.armor.service.exception;

/**
 *
 * @author Gonda Gergely
 *
 */
public class ArmorServiceException extends RuntimeException {

	private static final long serialVersionUID = -4397753313080068407L;

	public ArmorServiceException() {
		super();
	}

	public ArmorServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ArmorServiceException(String message) {
		super(message);
	}

	public ArmorServiceException(Throwable cause) {
		super(cause);
	}

}
