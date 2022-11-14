public class SachbearbeiterBearbeitenK {
    public void schreibeSachbearbeiter(String alterName, String name, String passwort, boolean istAdmin) {
        Sachbearbeiter s = Sachbearbeiter.gib(alterName);
        if(s == null) {
            throw new IllegalArgumentException("Dieser Nutzer existiert nicht!");
        }
        Sachbearbeiter.nehmeRaus(alterName);
        s.setzeBerechtigung(istAdmin);
        s.setzeName(name);
        s.setzePasswort(passwort);
        Sachbearbeiter.fuegeHinzu(s);
    }
}
