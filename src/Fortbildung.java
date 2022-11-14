import java.util.ArrayList;
import java.util.HashMap;

public class Fortbildung {

    private ArrayList<Fortbildung> voraussetzungen;
    private static HashMap<String, Fortbildung> dieFortbildungen;
    private String name;

    public Fortbildung(String name) {
        this.name = name;
        dieFortbildungen.put(name, this);
    }

    public static String[] gibFortbildungNamen() {
        return dieFortbildungen.keySet().toArray(new String[0]);
    }

    public ArrayList<Fortbildung> gibVoraussetzungen() {
        return voraussetzungen;
    }
    public static Fortbildung gib(String name) {
        return dieFortbildungen.get(name);
    }
    public String gibName() {
        return name;
    }
    public void setzeName(String name) {
        this.name = name;
    }
    public void fuegeHinzuVoraussetzungen(Fortbildung f) {
        this.voraussetzungen.add(f);
    }

}