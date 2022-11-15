public class FortbildungZuordnenAAS {
    private final SachbearbeiterAuswaehlenAAS saAAS;
    private final FortbildungenAuswaehlenAAS faAAS;
    private final FortbildungZuordnenK faK;
    public FortbildungZuordnenAAS() {
        saAAS = new SachbearbeiterAuswaehlenAAS();
        faAAS = new FortbildungenAuswaehlenAAS();
        faK = new FortbildungZuordnenK();
    }
    public void oeffnen() {
        System.out.println("Bitte waehlen Sie zunächst den Sachbearbeiter");
        String benutzername = saAAS.oeffnen();
        System.out.println("Bitte wählen Sie jetzt die Fortbildung: ");
        String fortbildungsName = faAAS.oeffne();
        String typ;
        do {
            typ = Eingabe.eingeben("Typ der Fortbildung: [belegt] / [bestanden]");
            if(!typ.equals("belegt") && !typ.equals("bestanden")) {
                System.out.println("Bitte entweder [belegt] oder [bestanden] eingeben!" );
            }
        }while(!typ.equals("belegt") && !typ.equals("bestanden"));
        faK.ordneFortbildungZu(benutzername, fortbildungsName, typ);

    }
}
