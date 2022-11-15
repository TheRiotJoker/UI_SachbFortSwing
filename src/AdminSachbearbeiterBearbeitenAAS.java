public class AdminSachbearbeiterBearbeitenAAS {
    private final SachbearbeiterBearbeitenK sbK;
    private final SachbearbeiterBearbeitenAAS sbAAS;
    public AdminSachbearbeiterBearbeitenAAS() {
        sbK = new SachbearbeiterBearbeitenK();
        sbAAS = new SachbearbeiterBearbeitenAAS();
    }

    public void oeffnen() {
        System.out.println("======Admin Panel: Sachbearbeiter Bearbeiten======");
        boolean success;
        String alterName;
        String neuerName;
        String passwort;
        String adminStatus;
        praesentiereSachbearbeiter();
        boolean istAdmin = false;
        do {
            alterName = sbAAS.sachbearbeiterAuswaehlen.oeffnen();
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
            do {
                adminStatus = Eingabe.eingeben("Bitte geben Sie den neuen Adminstatus des Sachbearbeiters ein[J/N]: ");
            }while(!adminStatus.equals("J") && !adminStatus.equals("N"));
            istAdmin = adminStatus.equals("J");
            try {
                sbK.schreibeSachbearbeiter(alterName, neuerName, passwort, istAdmin);
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
