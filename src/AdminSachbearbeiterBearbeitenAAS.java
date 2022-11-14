public class AdminSachbearbeiterBearbeitenAAS {
    private final SachbearbeiterBearbeitenK sbK;

    public AdminSachbearbeiterBearbeitenAAS() {
        sbK = new SachbearbeiterBearbeitenK();

    }

    public void oeffnen() {
        boolean success;
        String alterName;
        String neuerName;
        String passwort;
        String adminStatus;
        boolean istAdmin = false;
        do {
            Eingabe.abbruchInfo();
            success = true;
            alterName = Eingabe.eingeben("Bitte geben Sie den jetzigen Namen des Sachbearbeiters ein: ");
            if(alterName.equals("abbruch")) {
                return;
            }
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
        praesentiereSachbearbeiter(neuerName, passwort, adminStatus);

    }
    private void praesentiereSachbearbeiter(String neuerName, String passwort, String adminStatus) {
        System.out.println("Der neue Sachbearbeiter wurde erfolgreich angelegt!");
        System.out.println("Die neuen Daten: ");
        System.out.println("Name: \t"+neuerName);
        System.out.println("Passwort: \t"+passwort);
        System.out.println("Admin Status: \t"+adminStatus);

    }
}
