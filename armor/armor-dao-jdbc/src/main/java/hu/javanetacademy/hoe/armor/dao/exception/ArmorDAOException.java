package hu.javanetacademy.hoe.armor.dao.exception;

public class ArmorDAOException extends RuntimeException {

	private static final long serialVersionUID = -4397753313080068407L;

	public ArmorDAOException() {
		super();
	}

	public ArmorDAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public ArmorDAOException(String message) {
		super(message);
	}

	public ArmorDAOException(Throwable cause) {
		super(cause);
	}

}
