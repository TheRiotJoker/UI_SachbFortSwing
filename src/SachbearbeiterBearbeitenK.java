public class SachbearbeiterBearbeitenK {
    public void schreibeSachbearbeiter(String alterName, String name, String passwort, boolean istAdmin) {
        Sachbearbeiter s = Sachbearbeiter.gib(alterName);
        if(s == null) {
            throw new IllegalArgumentException("Dieser Nutzer existiert nicht!");
        }
        if(!Sachbearbeiter.pruefePasswort(passwort)) {
            throw new IllegalArgumentException("Das Passwort ist ungültig!");
        }
        if(!Sachbearbeiter.pruefeBenutzername(name)) {
            throw new IllegalArgumentException("Der Benutzername ist ungültig!");
        }
        if(!Sachbearbeiter.mindestensEinAdministratorExistiert() && !istAdmin) {
            throw new IllegalArgumentException("Dem letzten Admin dürfen die Rechte nicht entzogen werden!");
        }
            Sachbearbeiter.nehmeRaus(alterName);
            s.setzeBerechtigung(istAdmin);
            s.setzeName(name);
            s.setzePasswort(passwort);
            Sachbearbeiter.fuegeHinzu(s);
    }
    public boolean istAdmin(String benutzername) {
        if(Sachbearbeiter.gib(benutzername) != null) {
            return (Sachbearbeiter.gib(benutzername).istAdmin());
        } else {
            throw new IllegalArgumentException("Nutzer existiert nicht!");
        }

    }
}
