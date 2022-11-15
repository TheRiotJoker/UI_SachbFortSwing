public class SachbearbeiterErfassenAAS {
    private final SachbearbeiterErfassenK seK;
    public SachbearbeiterErfassenAAS() {
        seK = new SachbearbeiterErfassenK();
    }
    public void oeffne() {
        System.out.println("======Sachbearbeiter Erfassen======");
        String benutzername;
        String passwort;
        String adminStatus;
        boolean isAdmin;
        boolean success = false;
        do {
            Eingabe.abbruchInfo();
            benutzername = Eingabe.eingeben("Bitte geben Sie den Namen des Sachbearbeiters ein: ");
            if(benutzername.equalsIgnoreCase("abbruch")) {
                return;
            }
            passwort = Eingabe.eingeben("Bitte geben Sie das Passwort ein: ");
            if(passwort.equalsIgnoreCase("abbruch")) {
                return;
            }
            do {
                adminStatus = Eingabe.eingeben("Bitte geben Sie den Adminstatus ein [J/N] ein: ");
                if(adminStatus.equalsIgnoreCase("abbruch")) {
                    return;
                }
            }while(!adminStatus.equals("J") && !adminStatus.equals("N"));
            isAdmin = adminStatus.equals("J");
            success = seK.erfasseSachbearbeiter(benutzername,passwort,isAdmin);
        }while(!success);

    }
}
