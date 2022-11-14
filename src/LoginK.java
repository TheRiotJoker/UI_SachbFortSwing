

public class LoginK {
    public boolean pruefeLogin(String name, String passwort, boolean istAdmin) {
        Sachbearbeiter s = Sachbearbeiter.gib(name);
        if(s == null) { //wenn nutzer nicht existiert
            return false;
        }
        if(s.istAdmin() != istAdmin) {
            return false;
        }
        //ist passwort gueltig?
        return s.pruefeLogin(passwort);
    }
}
