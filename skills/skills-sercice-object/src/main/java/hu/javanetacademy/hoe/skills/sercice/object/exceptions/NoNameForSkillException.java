package hu.javanetacademy.hoe.skills.sercice.object.exceptions;

import hu.javanetacademy.hoe.base.util.CustomException;

/**
 * @author Kovacs Maria
 */
public class NoNameForSkillException extends CustomException {

    public String message;

    public NoNameForSkillException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
    
}