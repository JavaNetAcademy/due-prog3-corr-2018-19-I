package hu.javanetacademy.hoe.skills.sercice.object.exceptions;

import hu.javanetacademy.hoe.base.util.CustomException;

/**
 * @author Kovacs Maria
 */
public class SkillsException extends CustomException {
    public String message;
    public int errCode;

    public SkillsException(SkillErrors code) {
        this.message = code.getMsg();
        this.errCode = code.getId();
    }

    public int getErrCode() {
        return errCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
