public class FortbildungsZuordnungAuswaehlenAAS {
    private final SachbearbeiterAuswaehlenAAS saAAS;
    private String benutzername;
    private final FortbildungsZuordnungAuswaehlenK fzaK;
    public FortbildungsZuordnungAuswaehlenAAS() {

        saAAS = new SachbearbeiterAuswaehlenAAS();
        fzaK = new FortbildungsZuordnungAuswaehlenK();
    }
    public String[] oeffnen() {
        System.out.println("======Fortbildungszuordnung Auswählen======");
        System.out.println("Bitte waehlen Sie den Sachbearbeiter aus: ");
        String benutzer = saAAS.oeffnen();
        benutzername = benutzer;
        return fzaK.gibZuordnungen(benutzer);

    }

    public String getBenutzername() {
        return benutzername;
    }
}
