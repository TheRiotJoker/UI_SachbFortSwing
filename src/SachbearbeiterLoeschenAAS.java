public class SachbearbeiterLoeschenAAS {
    private final SachbearbeiterLoeschenK sblK;
    private final SachbearbeiterAuswaehlenAAS saAAS;
    public SachbearbeiterLoeschenAAS() {
        sblK = new SachbearbeiterLoeschenK();
        saAAS = new SachbearbeiterAuswaehlenAAS();
    }
    public void oeffnen() {
        System.out.println("======Sachbearbeiter Löschen======");
        boolean success = false;
        String benutzername;
        do {
            Eingabe.abbruchInfo();
            benutzername = "";
            if(benutzername.equals("abbruch")) {
                return;
            }
            success = sblK.loescheSachbearbeiter(benutzername);
        }while(!success);
        ausgefuehrt(benutzername);
    }
    public void ausgefuehrt(String name) {
        System.out.println("Der Sachbearbeiter "+name+" wurde erfolgreich gelöscht.");
    }
}
