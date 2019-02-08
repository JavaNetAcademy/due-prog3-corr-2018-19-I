package hu.javanetacademy.hoe.factories.service.object;

import hu.javanetacademy.hoe.base.util.CustomException;

/**
 * @author jrajmund
 */
public class FactoriesException extends CustomException {

    public String message;
    public int errCode;

    public FactoriesException(FactoriesErrors code) {
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
