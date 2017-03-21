package nl.tomvangrinsven.dea.webappBackend;

/**
 * Created by Tom van Grinsven on 3/14/2017.
 */
public class Country {
    public String getCode() {
        return Code;
    }

    public String getName() {
        return Name;
    }

    private String Code;
    private String Name;

    public Country(String code, String name) {
        Code = code;
        Name = name;
    }
}
