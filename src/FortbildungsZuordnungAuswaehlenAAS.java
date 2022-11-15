public class FortbildungsZuordnungAuswaehlenAAS {
    private final SachbearbeiterAuswaehlenAAS saAAS;
    private String benutzername;
    private final FortbildungsZuordnungAuswaehlenK fzaK;
    public FortbildungsZuordnungAuswaehlenAAS() {

        saAAS = new SachbearbeiterAuswaehlenAAS();
        fzaK = new FortbildungsZuordnungAuswaehlenK();
    }
    public String[] oeffnen() {
        System.out.println("Bitte waehlen Sie den Sachbearbeiter aus: ");
        String benutzer = saAAS.oeffnen();
        benutzername = benutzer;
        String typ;
        do {
            typ = Eingabe.eingeben("Typ der Fortbildung: [belegt] / [bestanden]");
            if(!typ.equals("belegt") && !typ.equals("bestanden")) {
                System.out.println("Bitte entweder [belegt] oder [bestanden] eingeben!" );
            }
        }while(!typ.equals("belegt") && !typ.equals("bestanden"));
        String[] fortbildungen = fzaK.gibZuordnungen(benutzer, typ);
        System.out.println("Dem Nutzer "+ benutzer +" sind die folgenden Fortbildungen des Typs "+typ+" zugeordnet:");
        for(String s : fortbildungen) {
            System.out.println();
        }
        return fortbildungen;

    }

    public String getBenutzername() {
        return benutzername;
    }
}
