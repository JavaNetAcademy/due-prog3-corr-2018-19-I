package hu.javanetacademy.hoe.skills.sercice.object.exceptions;

/**
 * @author Kovacs Maria
 */
public enum SkillErrors {
    NO_NAME(0, "A nevet nem lehet kihagyni."),
    USED_NAME(1, "Van már ilyen nevű képesség."),
    NO_COMBAT_VALUE(2,"A hatás nagyobb, mint 0"),
    NO_REQ_LEVEL(3,"A hősszint nagyobb, mint 0"),
    NO_JOB(4, "Legalább egy foglalkozást hozzá kell rendelni."),
    USED_BY_HERO(5, "Használja már egy hős."),
    ALRAEDY_KNOWN(6, "Már megtanult képesség."),
    NOT_KNOWN(7, "Nem ismeri a hős ezt a képességet.");

    private final int id;
    private final String msg;

    SkillErrors(int id, String msg) {
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
