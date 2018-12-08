package hu.javanetacademy.hoe.skills.sercice.object.exceptions;

import hu.javanetacademy.hoe.base.util.CustomException;

/**
 * @author Kovacs Maria
 */
public class UsedByHeroException extends CustomException{
    public String message;

    public UsedByHeroException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

