public class SachbearbeiterBearbeitenK {
    public void schreibeSachbearbeiter(String alterName, String name, String passwort, boolean istAdmin) {
        Sachbearbeiter s = Sachbearbeiter.gib(alterName);
        if(s == null) {
            throw new IllegalArgumentException("Dieser Nutzer existiert nicht!");
        }
        if(!Sachbearbeiter.pruefePasswort(passwort)) {
            System.out.println("Das Passwort ist ungültig!");
            return;
        }
        if(!Sachbearbeiter.pruefeBenutzername(name)) {
            System.out.println("Der Benutzername ist ungültig!");
            return;
        }
        if(!Sachbearbeiter.mindestensEinAdministratorExistiert() && !istAdmin) {
            System.out.println("Dem letzten Admin dürfen die Rechte nicht entzogen werden!");
            return;
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
