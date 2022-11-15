public class NormalSachbearbeiterBearbeitenAAS {
    private final SachbearbeiterBearbeitenK sbK;
    private final SachbearbeiterBearbeitenAAS sbAAS;
    public NormalSachbearbeiterBearbeitenAAS() {
        sbK = new SachbearbeiterBearbeitenK();
        sbAAS = new SachbearbeiterBearbeitenAAS();
    }

    public void oeffnen() {
        boolean success;
        String alterName;
        String neuerName;
        String passwort;
        do {
            do {
                praesentiereSachbearbeiter();
                alterName = sbAAS.sachbearbeiterAuswaehlen.oeffnen();
                if(alterName.equals("Abbruch")) {
                    return;
                }
                if(sbK.istAdmin(alterName)) {
                    System.out.println("Sie haben die Berechtigung nicht, um die Daten dieses Nutzers zu ändern!");
                }
            }while(sbK.istAdmin(alterName));
            Eingabe.abbruchInfo();
            success = true;
            neuerName = Eingabe.eingeben("Bitte geben Sie den neuen Namen des Sachbearbeiters ein: ");
            if(neuerName.equals("abbruch")) {
                return;
            }
            passwort = Eingabe.eingeben("Bitte geben Sie das neue Passwort des Sachbearbeiters ein: ");
            if(passwort.equals("abbruch")) {
                return;
            }
            try {
                sbK.schreibeSachbearbeiter(alterName, neuerName, passwort, false);
            }catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
                success = false;
            }
        }while(!success);
        sbAAS.ausgefuehrt(alterName);

    }
    private void praesentiereSachbearbeiter() {
    }
}
