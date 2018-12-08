package hu.javanetacademy.hoe.skills.sercice.object.exceptions;

import hu.javanetacademy.hoe.base.util.CustomException;

/**
 * @author Kovacs Maria
 */
public class NoJobForSkillException extends CustomException{
    public String message;

    public NoJobForSkillException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

