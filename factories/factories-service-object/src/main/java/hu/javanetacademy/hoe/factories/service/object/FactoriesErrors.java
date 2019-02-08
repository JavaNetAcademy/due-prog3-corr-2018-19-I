package hu.javanetacademy.hoe.factories.service.object;

/**
 * @author jrajmund
 */
public enum FactoriesErrors {
    NO_NAME(0, "Nincs név!"),
    NO_DESCRIPTION(1, "Nincs leírás!"),
    NO_NO(2, "Hiba!");

    private final int id;
    private final String msg;

    FactoriesErrors(int id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public int getId() {
        return this.id;
    }

    public String getMsg() {
        return this.msg;
    }
}
