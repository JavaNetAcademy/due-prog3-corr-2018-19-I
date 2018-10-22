package hu.javanetacademy.hoe.armor.dao.entity;

import java.io.Serializable;

/**
 *
 * @author Gonda Gergely
 *
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		BaseEntity other = (BaseEntity) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

}
