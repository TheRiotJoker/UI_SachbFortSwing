import java.util.HashMap;

public class Sachbearbeiter {

    private HashMap<String, Fortbildung> bestandeneFortbildungen;
    private HashMap<String, Fortbildung> belegteFortbildungen;
    private static final HashMap<String, Sachbearbeiter> dieSachbearbeiter = new HashMap<>();
    private String name;


    private boolean admin;
    private String passwort;
    public Sachbearbeiter(String name, String pw, boolean admin) throws IllegalArgumentException{
        this.name = name;
        setzeName(name);
        setzePasswort(pw);
        this.admin = admin;
        bestandeneFortbildungen = new HashMap<>();
        belegteFortbildungen = new HashMap<>();
        fuegeHinzu(this);
    }

    public static void fuegeHinzu(Sachbearbeiter sachbearbeiter) {
        dieSachbearbeiter.put(sachbearbeiter.name, sachbearbeiter);
    }
    public boolean pruefeLogin(String pw) {
        return passwort.equals(pw);
    }
    public static boolean pruefeBenutzername(String name) {
        return name.length() >= 4;
    }
    public static String[] gibAlleNamen() {
        return dieSachbearbeiter.keySet().toArray(new String[0]);
    }

    public static boolean pruefePasswort(String pw) {
        //das passwort muss mindestens 7 zeichen lang sein
        return pw.length() >= 7;
    }
    private static boolean istBenutzernameVorhanden(String name) {
        for(String s : dieSachbearbeiter.keySet()) {
            if(s.equals(name)) {
                return true;
            }
        }
        return false;
    }
    public static boolean mindestensEinAdministratorExistiert() {
        int counter = 0;
        for(Sachbearbeiter s : dieSachbearbeiter.values()) {
            if(s.istAdmin()) {
                counter++;
            }
            if(counter > 1) {
                return true;
            }
        }
        return false;
    }

    public HashMap<String, Fortbildung> gibBelegteFortbildungen() {
        return belegteFortbildungen;
    }


    public HashMap<String, Fortbildung> gibBestandeneFortbildungen() {
        return bestandeneFortbildungen;
    }
    public void fuegeHinzuBelegteFortbildungen(Fortbildung f, String s) {
        for(Fortbildung fb : f.gibVoraussetzungen()) {
            if(!bestandeneFortbildungen.containsValue(fb)) {
                throw new IllegalArgumentException("Diese Fortbildung kann von diesem Sachbearbeiter nicht belegt werden, da dieser die Voraussetzungen nicht erfüllt!");
            }
        }
        belegteFortbildungen.put(s, f);
    }
    public void fuegeHinzuBestandeneFortbildungen(Fortbildung f, String s) {
        if(!belegteFortbildungen.containsValue(f)) {
            throw new IllegalArgumentException("Der Sachbearbeiter kann eine nicht belegte Fortbildung nicht bestehen!");
        }
        bestandeneFortbildungen.put(s,f);
    }
    public static Sachbearbeiter gib(String name) {
        return dieSachbearbeiter.get(name);
    }

    public void loescheFortbildungsZuordnung(String zuordnung) {
        //gib fortbildung, die zu löschen ist:
        Fortbildung f = bestandeneFortbildungen.get(zuordnung);
        //Die Fortbildung darf nicht gelöscht werden, wenn sie eine voraussetzung darstellt für eine andere fortbildung
        for(Fortbildung belegteF : belegteFortbildungen.values()) { //iteriere durch alle belegte Fortbildungen
            if(belegteF.gibVoraussetzungen().contains(f)) { //wenn eine belegte Fortbildung die zu löschende als Voraussetzung hat
                throw new IllegalArgumentException("Die Fortbildung darf nicht gelöscht werden, da sie eine Voraussetzung für eine andere eingetragene Fortbildung ist!");
            }
        }
        belegteFortbildungen.remove(zuordnung);
        bestandeneFortbildungen.remove(zuordnung);
    }

    public String gibName() {
        return name;
    }
    public void setzeName(String name) {
        if(istBenutzernameVorhanden(name) || !pruefeBenutzername(name)) {
            throw new IllegalArgumentException("Der Name ist entweder vorhanden oder ungültig!");
        }
        this.name = name;
    }

    public String gibPasswort() {
        return passwort;
    }

    public void setzePasswort(String passwort) {
        if(pruefePasswort(passwort)) {
            this.passwort = passwort;
        } else {
            throw new IllegalArgumentException("Das Passwort ist nicht gültig!");
        }
    }
    public boolean istAdmin() {
        return admin;
    }

    public void setzeBerechtigung(boolean admin) {
        if(!admin && this.admin) {
            if(!mindestensEinAdministratorExistiert()) {
                throw new IllegalArgumentException("Der letzte Administrator darf nicht geloescht werden!");
            }
        }
        this.admin = admin;
    }
    public static boolean mindestensEinSachbearbeiterExistiert() {
        return dieSachbearbeiter.values().size() >= 1;
    }
    public static boolean mindestensEineFortbildungsZuordnungExistiert() {
        for(Sachbearbeiter s : dieSachbearbeiter.values()) {
            if(s.belegteFortbildungen.values().size() >= 1) {
                return true;
            }
        }
        return false;
    }
    public static void loesche(String name) {
        Sachbearbeiter s = dieSachbearbeiter.get(name);
        if(s == null) {
            throw new IllegalArgumentException("Ein Sachbearbeiter mit dem eingegebenen Namen existiert nicht!");
        }
        if(s.istAdmin()) {
            s.setzeBerechtigung(false);
        }
        dieSachbearbeiter.remove(name);
    }
    public static void nehmeRaus(String name) {
        dieSachbearbeiter.remove(name);
    }

}